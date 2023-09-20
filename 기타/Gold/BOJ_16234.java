import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 땅의 크기 N, 인구 차이의 범위 L 이상 R 이하,
    static int N, L, R;
    // 지도를 표현할 map, 방문 여부 visited,
    static int[][] map;
    static boolean[][] visited;
    // 이동 방향 dx, dy, bfs를 위한 큐, 연합을 표현할 union를 선언한다.
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue;
    static ArrayList<int[]> union;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, L, R이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 3. N*N만큼의 정보를 map에 저장한다.
        map = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. 연합이 없을 때 까지 반복하여
        int count = 0;
        while(true){
            // visited를 초기화하고
            visited = new boolean[N][N];
            boolean isUnion = false;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(!visited[i][j]) {
                        // bfs를 통해 연합을 찾아
                        int sum = bfs(i, j);
                        // 연합이 있을 경우 인구를 이동시키고 isUnion을 true로 설정한다.
                        if(union.size() > 1){
                            move(sum);
                            isUnion = true;
                        }
                    }
                }
            }

            // 연합이 없을 경우 종료하고 있을 경우 count를 1 증가시킨다.
            if(!isUnion) break;
            count++;
        }

        // 5. count를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int y, int x){
        // queue, union을 초기화하고
        queue = new LinkedList<>();
        union = new ArrayList<>();

        // 시작 위치를 queue, union에 추가하고
        queue.add(new int[]{y, x});
        union.add(new int[]{y, x});
        // 방문처리한 뒤 현재 인구수를 저장한다.
        visited[y][x] = true;
        int sum = map[y][x];

        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 map 범위 안이고 방문하지 않았을 경우
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N){
                    if(!visited[nextY][nextX]) {
                        // 현재 위치와 다음 위치의 인구수 차이를 비교하여
                        int diff = Math.abs(map[nowY][nowX] - map[nextY][nextX]);
                        if(diff >= L && diff <= R){
                            // L ~ R 사이라면
                            // 방문처리하고 queue, union에 추가한 뒤
                            visited[nextY][nextX] = true;
                            queue.add(new int[]{nextY, nextX});
                            union.add(new int[]{nextY, nextX});
                            // sum을 추가한다.
                            sum += map[nextY][nextX];
                        }
                    }
                }
            }
        }

        // 탐색 종료 시 sum을 리턴한다.
        return sum;
    }

    static void move(int sum){
        // 변경할 인구수를 찾아
        int change = sum / union.size();

        // 연합에 해당하는 인구수를 변경한다.
        for(int i = 0 ; i < union.size() ; i++){
            int y = union.get(i)[0];
            int x = union.get(i)[1];

            map[y][x] = change;
        }

    }
}
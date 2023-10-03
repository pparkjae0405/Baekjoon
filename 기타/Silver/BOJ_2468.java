import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 지도의 크기 N,
    static int N;
    // 지도 map, 방문 여부 visited,
    static int[][] map;
    static boolean[][] visited;
    // 이동 방향 dx, dy,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // bfs를 위한 큐, 안전영역 최대 개수 max, 최대 높이 h를 선언한다.
    static Queue<int[]> queue = new LinkedList<>();
    static int max = 1;
    static int h = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어진다.
        N = Integer.parseInt(br.readLine());

        // 3. map의 크기를 설정하고 정보를 저장하면서
        map = new int[N][N];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                // 최대 높이를 저장한다.
                if(map[i][j] > h) h = map[i][j];
            }
        }

        // 4. 1 ~ h - 1까지 돌면서
        for(int i = 1 ; i < h ; i++){
            // visited를 초기화하고
            visited = new boolean[N][N];

            // map을 돌면서
            int count = 0;
            for(int a = 0 ; a < N ; a++){
                for(int b = 0 ; b < N ; b++){
                    // 방문하지 않은 i 초과값이 있다면
                    if(!visited[a][b] && map[a][b] > i){
                        // 큐에 추가하고 방문처리한 뒤
                        queue.add(new int[]{a, b});
                        visited[a][b] = true;
                        // 안전 구역 개수를 증가시키고
                        count++;
                        // bfs를 호출하여 i 초과인 지역의 개수를 갱신한다.
                        bfs(i);
                    }
                }
            }

            // 탐색 종료 시의 안전지역 개수를 갱신한다.
            max = Math.max(max, count);
        }

        // 5. max값을 출력한다.
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int over){
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

                // 해당 위치가 지도 범위 안이고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N) {
                    // 방문하지 않고 해당 값이 over 초과라면
                    if(!visited[nextY][nextX] && map[nextY][nextX] > over){
                        // 방문처리한 뒤 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
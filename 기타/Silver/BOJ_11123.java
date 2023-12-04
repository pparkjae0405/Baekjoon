import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 케이스의 세로 길이 H, 가로 길이 W,
    static int H, W;
    // 양 정보 info, 방문 여부 visited,
    static char[][] info;
    static boolean[][] visited;
    // 이동 방향 dx, dy, bfs를 위한 큐,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    // 양 무리의 개수 count를 선언한다.
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 테스트 케이스 개수가 주어지면 그만큼 반복하여
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int a = 0 ; a < T ; a++) {
            // H, W가 주어진 뒤 count를 초기화하고
            st = new StringTokenizer(br.readLine(), " ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            count = 0;

            // info, visited의 크기를 설정하고
            info = new char[H][W];
            visited = new boolean[H][W];
            // info 정보를 저장한다.
            for(int i = 0 ; i < H ; i++){
                String str = br.readLine();
                for(int j = 0 ; j < W ; j++){
                    info[i][j] = str.charAt(j);
                }
            }

            // 3. info를 돌면서
            for(int i = 0 ; i < H ; i++){
                for(int j = 0 ; j < W ; j++){
                    // 방문하지 않은 #가 있다면
                    if(!visited[i][j] && info[i][j] == '#'){
                        // count를 증가시키고 bfs를 호출한다.
                        count++;
                        bfs(i, j);
                    }
                }
            }

            // 4. count를 출력한다.
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x){
        // 시작 위치를 방문처리하고 큐에 추가한다.
        visited[y][x] = true;
        queue.add(new int[]{y, x});

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 정보를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 범위 안에 있고
                if(nextY >= 0 && nextY < H && nextX >= 0 && nextX < W){
                    // 방문하지 않았고 #일 경우
                    if(!visited[nextY][nextX] && info[nextY][nextX] == '#'){
                        // 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
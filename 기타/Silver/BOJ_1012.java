import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 배추밭의 가로길이 M, 세로길이 N, 배추의 개수 K,
    static int M, N, K;
    // 배추밭 정보 info, 방문 여부 visited,
    static int[][] info;
    static boolean[][] visited;
    // 이동 방향 dx, dy, bfs를 위한 큐,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    // 필요한 배추흰지렁이의 개수 count를 선언한다.
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 테스트 케이스 개수 T가 주어지고
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int a = 0 ; a < T ; a++){
            // M, N, K가 주어지면
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // info, visited, count의 크기를 설정하고
            info = new int[N][M];
            visited = new boolean[N][M];
            count = 0;

            // info 정보를 저장한 뒤
            for(int i = 0 ; i < K ; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                info[y][x] = 1;
            }

            // info를 돌면서
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    // 방문하지 않은 배추가 있다면
                    if(!visited[i][j] && info[i][j] == 1){
                        // bfs를 호출하여 count를 센다.
                        bfs(i, j);
                        count++;
                    }
                }
            }

            // 3. count를 출력한다.
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
            // 현재 위치를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 배추밭 범위 내고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    // 방문하지 않은 배추가 있다면
                    if(!visited[nextY][nextX] && info[nextY][nextX] == 1){
                        // 해당 위치를 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
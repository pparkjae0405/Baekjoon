import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 통로의 세로 길이 N, 가로 길이 M,
    // 통로 정보 info, 방문 여부 visited,
    static int N, M;
    static int[][] info;
    static boolean[][] visited;
    // 이동 방향 dx, dy, bfs를 위한 큐,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    // 음식물의 크기 area, 가장 큰 음식물의 크기 max를 선언한다.
    static int area;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M, 음식물 쓰레기의 개수 K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 3. info, visited의 크기를 설정하고
        info = new int[N][M];
        visited = new boolean[N][M];
        // K개의 정보를 info에 저장한다.
        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;

            info[start][end] = 1;
        }

        // 4. info를 돌면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 방문하지 않은 쓰레기가 있을 경우
                if(!visited[i][j] && info[i][j] == 1) {
                    // 방문처리하고 큐에 추가한 뒤
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});

                    // area를 초기화하고 bfs를 호출하여 max를 갱신한다.
                    area = 0;
                    bfs();
                    max = Math.max(max, area);
                }
            }
        }

        // 5. max를 출력한다.
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 가져와 area를 증가시키고
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            area++;

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 info 범위 내에 있고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                    // 방문하지 않은 1이 있을 경우
                    if(!visited[nextY][nextX] && info[nextY][nextX] == 1) {
                        // 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
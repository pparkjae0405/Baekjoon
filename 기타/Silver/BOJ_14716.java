import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 현수막의 세로 크기 M, 가로 크기 N,
    static int M, N;
    // 현수막 정보 info, 방문 여부 visited,
    static int[][] info;
    static boolean[][] visited;
    // 이동 방향 dx, dy,
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    // bfs를 위한 큐, 글자의 개수 count를 선언한다.
    static Queue<int[]> queue = new LinkedList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. M, N이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        // info, visited의 크기를 설정한 뒤
        info = new int[M][N];
        visited = new boolean[M][N];
        // 정보를 저장한다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. info를 돌면서
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                // 방문하지 않은 1이 있을 경우
                if(!visited[i][j] && info[i][j] == 1){
                    // bfs를 호출하고 count를 증가시킨다.
                    bfs(i, j);
                    count++;
                }
            }
        }

        // 4. count를 출력한다.
        bw.write(count + "\n");

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
            for(int i = 0 ; i < 8 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 info 범위 안이고
                if(nextY >= 0 && nextY < M && nextX >= 0 && nextX < N){
                    // 방문하지 않은 1이 있을 경우
                    if(!visited[nextY][nextX] && info[nextY][nextX] == 1){
                        // 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
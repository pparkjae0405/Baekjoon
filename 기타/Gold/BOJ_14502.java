import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 지도의 세로 크기 N, M
    static int N;
    static int M;
    // 지도 map, 바이러스의 이동방향 dx, dy, 안전구역 최댓값 max 선언
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. N*M만큼 map의 크기를 설정하고, 지도의 정보를 받아 map에 저장한다.
        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. dfs 및 bfs를 통해 안전구역의 최댓값을 설정하여 출력한다.
        dfs(0);
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
    static void dfs(int depth){
        // 벽 3개를 선택했으면 bfs 호출하여 안전지대 확인 후 종료
        if(depth == 3){
            bfs();
            return;
        }

        // 0인 곳 중 3군데에 벽을 쳤을 때 경우의 수를 탐색
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 0){
                    // 0일 경우 벽을 치고 depth를 1 추가하여 재귀호출
                    map[i][j] = 1;
                    dfs(depth + 1);
                    // 확인이 끝나면 해당 위치를 0으로 롤백
                    map[i][j] = 0;
                }
            }
        }
    }

    static void bfs(){
        // 벽 3개를 완성하여 호출되는 bfs에서
        // map의 복사본과 방문여부 visited, bfs를 위한 큐를 선언하고
        int[][] copyMap = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();

        // 지도를 복사하면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                copyMap[i][j] = map[i][j];
                // 해당 위치가 바이러스이면 큐에 추가
                if(map[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
            }
        }

        // 큐가 빌 때까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 추출하여 방문처리하고
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            visited[nowY][nowX] = true;

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 copyMap 범위 안에 있고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    // 0이고 방문하지 않았을 경우
                    if(copyMap[nextY][nextX] == 0 && !visited[nextY][nextX]){
                        // 해당 위치를 2로 바꾸고 큐에 추가한다.
                        copyMap[nextY][nextX] = 2;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }

        // 바이러스의 확산이 끝났으면 copyMap을 돌면서
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 안전 영역의 수를 증가시킨다.
                if(copyMap[i][j] == 0) count++;
            }
        }

        // count가 max보다 크다면 max를 count로 설정
        if(count > max) max = count;
    }
}
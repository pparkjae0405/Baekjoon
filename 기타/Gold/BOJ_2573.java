import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 지도의 세로 크기 N, 가로 크기 M,
    static int N, M;
    // 지도를 표현할 map, 방문 여부 visited,
    static int[][] map;
    static boolean[][] visited;
    // 이동 방향 dx, dy, bfs를 위한 큐를 선언한다.
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. map의 크기를 설정하고 정보를 저장한다.
        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. 시간을 측정할 year을 선언,
        int year = 0;
        while(true) {
            // visited를 초기화하고
            visited = new boolean[N][M];

            // 덩어리 개수 count, 모두 녹았는지 여부 isMelt를 선언한 뒤
            int count = 0;
            boolean isMelt = true;
            // map을 돌면서 방문하지 않은 빙산이 있을 경우
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(!visited[i][j] && map[i][j] != 0){
                        // 덩어리 개수를 증가시키고 bfs를 호출하고
                        count++;
                        bfs(i, j);

                        // isMelt를 false로 설정한다.
                        isMelt = false;
                    }
                }
            }

            // 덩어리 개수가 2 이상일 경우 year을 출력하고 종료,
            if(count >= 2){
                bw.write(year + "\n");
                break;
            }
            // 덩어리가 분리되지 않고 모두 0이 되었을 경우 0을 출력하고 종료한다.
            if(isMelt){
                bw.write(0 + "\n");
                break;
            }

            // 탐색이 끝났을 경우 year을 1 증가시키고
            year++;
            // visited를 초기화한 뒤
            visited = new boolean[N][M];

            // map을 돌면서 얼음 주변이 바다인지 확인하여
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(map[i][j] != 0){
                        // 해당 위치를 방문처리하고
                        visited[i][j] = true;

                        // 상하좌우 위치에 방문하지 않은 0이 몇 개 있는지 확인하여
                        int zeroCount = 0;
                        for(int k = 0 ; k < 4 ; k++){
                            int nextY = i + dy[k];
                            int nextX = j + dx[k];

                            if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                                if (!visited[nextY][nextX] && map[nextY][nextX] == 0) {
                                    zeroCount++;
                                }
                            }
                        }

                        // 해당 수만큼 빼고 음수일 경우 0으로 설정한다
                        map[i][j] -= zeroCount;
                        if(map[i][j] < 0) map[i][j] = 0;
                    }
                }
            }
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

                // 해당 위치가 지도 안에 있고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    // 방문하지 않았고 0이 아닌 곳이 있다면
                    if(!visited[nextY][nextX] && map[nextY][nextX] != 0){
                        // 해당 위치를 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
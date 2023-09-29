import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 지도의 세로 크기 N, 가로 크기 M, 벽을 부술 수 있는 횟수 K,
    static int N, M, K;
    // 지도 map, 방문 여부 visited,
    static int[][] map;
    static boolean[][][] visited;
    // 이동 방향 dx, dy,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // bfs를 위한 큐, 결과값 result를 선언한다.
    static Queue<int[]> queue = new LinkedList<>();
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M, K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 3. N*M만큼 map, visited를 선언하고
        map = new int[N][M];
        visited = new boolean[N][M][K + 1];
        // map 정보를 저장한다.
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        // 4. bfs를 호출하여 최대 K번 돌았을 때의 최단 경로를 출력한다.
        bfs();
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        // 시작 위치 + 거리 + 벽을 부순 횟수를 큐에 넣고 방문처리한다.
        queue.add(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 정보를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            int nowD = now[2];
            int nowC = now[3];

            // 현재 위치가 (N - 1, M - 1)일 경우
            if(nowY == N - 1 && nowX == M - 1){
                // 현재 거리를 result에 저장하고 종료한다.
                result = nowD;
                return;
            }

            // 이외에는 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 map 범위 안이고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    // 방문하지 않았고 0이라면
                    if(!visited[nextY][nextX][nowC] && map[nextY][nextX] == 0) {
                        // 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX][nowC] = true;
                        queue.add(new int[]{nextY, nextX, nowD + 1, nowC});
                    }else{
                        // 1이고 벽을 +1번 부순 경우가 방문하지 않았다면
                        if(nowC < K && !visited[nextY][nextX][nowC + 1]){
                            // 방문처리하고 큐에 추가한다.
                            visited[nextY][nextX][nowC + 1] = true;
                            queue.add(new int[]{nextY, nextX, nowD + 1, nowC + 1});
                        }
                    }
                }
            }
        }
    }
}
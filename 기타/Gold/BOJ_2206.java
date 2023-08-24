import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 맵의 가로크기 N, 세로크기 M
    static int N, M;
    // 맵을 표현할 map, 방문여부 + 벽을 부순 여부 visited,
    static int[][] map;
    static boolean[][][] visited;
    // 이동방향 dx, dy, bfs를 위한 큐를 선언한다.
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Now> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. map, visited의 크기를 설정하고
        map = new int[N][M];
        visited = new boolean[N][M][2];
        // map의 정보를 받아 저장한다.
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        // 4. bfs를 통해 최단거리를 구해 출력한다.
        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Now{
        // 현재 위치, 벽을 부쉈는지 여부, 거리
        int y;
        int x;
        boolean crash;
        int count;

        public Now(int y, int x, boolean crash, int count) {
            this.y = y;
            this.x = x;
            this.crash = crash;
            this.count = count;
        }
    }

    static int bfs(){
        // 시작 위치 + 벽을 부쉈는지, 거리를 큐에 추가하고 방문처리
        queue.add(new Now(0, 0, false, 1));
        visited[0][0][0] = true;

        // 큐가 빌 때 까지 돌면서
        while(!queue.isEmpty()) {
            // 현재 위치를 꺼내서
            Now now = queue.poll();

            // 도착했을 경우 거리를 반환하고
            if(now.y == N - 1 && now.x == M - 1){
                return now.count;
            }

            // 그 외에는 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++) {
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];

                // 인접 위치가 맵의 범위 밖이라면 무시
                if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) continue;

                // 벽을 부순 적이 있다면
                if(now.crash){
                    // 다음 위치가 벽이 아니고, 벽을 부쉈던 경우에 방문한 적이 없다면
                    if(map[nextY][nextX] == 0 && !visited[nextY][nextX][1]){
                        // 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX][1] = true;
                        queue.add(new Now(nextY, nextX, true, now.count + 1));
                    }
                }else{
                    // 부순 적이 없을 경우 다음 위치가 벽이라면
                    if(map[nextY][nextX] == 1){
                        // 벽을 부수고 큐에 값을 추가한다.
                        visited[nextY][nextX][1] = true;
                        queue.add(new Now(nextY, nextX, true, now.count + 1));
                    }else if(map[nextY][nextX] == 0 && !visited[nextY][nextX][0]){
                        // 벽이 아니고 방문한 적이 없을 경우
                        // 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX][0] = true;
                        queue.add(new Now(nextY, nextX, false, now.count + 1));
                    }
                }
            }
        }
        // 도착하지 못했을 경우 -1을 반환한다.
        return -1;
    }
}
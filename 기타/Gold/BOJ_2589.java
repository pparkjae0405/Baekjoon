import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 지도의 세로 크기 N, 가로 크기 M,
    static int N, M;
    // 지도를 표현할 map, 방문 여부 visited,
    static char[][] map;
    static boolean[][] visited;
    // 나머지 육지와의 거리를 측정할 len,
    static int[][] len;
    // 이동 방향 dx, dy, bfs를 위한 큐, 두 보물간의 거리 max를 선언한다.
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. map의 크기를 설정하고
        map = new char[N][M];
        // 정보를 저장한다.
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = s.charAt(j);
            }
        }

        // 4. map을 돌면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 육지(L)을 만날 경우
                if(map[i][j] == 'L') {
                    // len과 visited의 크기를 설정하고
                    len = new int[N][M];
                    visited = new boolean[N][M];

                    // 현재 위치부터 bfs를 수행한다.
                    bfs(i, j);
                }
            }
        }

        // 5. 수행한 결과를 출력한다.
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x){
        // 시작 위치를 큐에 넣고 방문처리한다.
        queue.add(new int[]{y, x});
        visited[y][x] = true;

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

                // 해당 위치가 map 안에 있고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    // 방문하지 않은 육지일 경우
                    if(!visited[nextY][nextX] && map[nextY][nextX] == 'L'){
                        // 해당 위치를 방문처리하고
                        visited[nextY][nextX] = true;
                        // 거리를 추가하여 저장한 뒤 max값을 갱신하고
                        len[nextY][nextX] = len[nowY][nowX] + 1;
                        if(len[nextY][nextX] > max) max = len[nextY][nextX];
                        // 큐에 추가한다.
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
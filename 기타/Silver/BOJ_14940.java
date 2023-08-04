import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 지도의 세로 크기 n, 가로 크기 m,
    static int n, m;
    // 지도 map, 방문 여부 visited,
    static int[][] map;
    static boolean[][] visited;
    // 이동 방향 dx, dy, bfs를 위한 큐 선언
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. n과 m이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 3. map과 visited의 크기를 설정한다.
        map = new int[n][m];
        visited = new boolean[n][m];

        // 4. 지도의 크기만큼 정보를 입력받고 map에 저장하는데
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;

                // 값이 2라면 해당 위치를 큐에 추가한다. (목표 지점)
                if(value == 2) queue.add(new int[]{i, j});

            }
        }

        // 5. bfs를 호출하여 지도를 설정하고 출력한다.
        bfs();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(map[i][j] == 0){
                    bw.write(0 + " ");
                }else if(map[i][j] == 1){
                    bw.write(-1 + " ");
                }else {
                    bw.write(map[i][j] - 2 + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        // 큐가 빌 때까지 반복하여
        while(!queue.isEmpty()){
            // 위치를 큐에서 빼내고 방문처리하고
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            visited[nowY][nowX] = true;

            // 인접 위치를 확인하여
            for(int i = 0 ; i < 4 ; i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // (nextY, nextX)가 map 범위 안에 있고
                if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m){
                    // 해당 위치가 1이고 방문하지 않았다면
                    if(map[nextY][nextX] == 1 && !visited[nextY][nextX]){
                        // 큐에 넣고 거리를 추가하여 저장한 뒤 방문처리한다.
                        queue.add(new int[]{nextY, nextX});
                        map[nextY][nextX] = map[nowY][nowX] + 1;
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }
    }
}
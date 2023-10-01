import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 지도의 너비 w, 높이 h,
    static int w, h;
    // 지도를 표현할 map, 방문 여부 visited,
    static int[][] map;
    static boolean[][] visited;
    // 이동 방향 dx, dy,
    static int[] dx = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dy = {0, 0, -1, 1, -1, -1, 1, 1};
    // bfs를 위한 큐, 섬의 개수 count를 선언한다.
    static Queue<int[]> queue = new LinkedList<>();
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. (w, h)가 0, 0이 주어질 때 까지 반복하여 입력받고
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            if(w == 0 && h == 0) break;

            // 3. map, visited의 크기를 설정한 뒤
            map = new int[h][w];
            visited = new boolean[h][w];
            // map의 정보를 저장하고
            for(int i = 0 ; i < h ; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < w ; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 4. count를 0으로 선언하고
            count = 0;
            // map을 돌면서 방문하지 않은 섬이 있을 경우
            for(int i = 0 ; i < h ; i++){
                for(int j = 0 ; j < w ; j++){
                    if(!visited[i][j] && map[i][j] == 1){
                        // 현재 위치를 방문처리하고 큐에 추가한 뒤
                        visited[i][j] = true;
                        queue.add(new int[]{i, j});

                        // count를 증가시키고 bfs를 호출한다.
                        count++;
                        bfs();
                    }
                }
            }

            // 5. 탐색 종료 시의 섬의 개수를 출력한다.
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 8 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 map 범위 안이고
                if(nextY >= 0 && nextY < h && nextX >= 0 && nextX < w){
                    // 방문하지 않은 섬이라면
                    if(!visited[nextY][nextX] && map[nextY][nextX] == 1){
                        // 해당 위치를 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
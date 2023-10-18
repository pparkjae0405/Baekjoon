import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    // 1. 그림의 크기 N,
    static int N;
    // 그림 정보 paint, 방문 여부 visited,
    static String[][] paint;
    static boolean[][] visited;
    // 이동 방향 dx, dy, bfs를 위한 큐,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    // 구역의 개수 count를 선언한다.
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어지고 paint의 크기를 설정한 뒤
        N = Integer.parseInt(br.readLine());
        paint = new String[N][N];
        // paint 정보를 저장한다.
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                paint[i][j] = String.valueOf(str.charAt(j));
            }
        }

        // 3. count와 visited를 초기화하고 paint를 탐색하고,
        count = 0;
        visited = new boolean[N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(!visited[i][j]){
                    count++;
                    bfs(i, j);
                }
            }
        }
        bw.write(count + " ");

        // count와 visited를 초기화하고
        count = 0;
        visited = new boolean[N][N];
        // G를 R로 바꾼 뒤 paint를 탐색한다.
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(paint[i][j].equals("G")){
                    paint[i][j] = "R";
                }
            }
        }
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(!visited[i][j]){
                    count++;
                    bfs(i, j);
                }
            }
        }
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

            // 인접 위치를 탐색하여
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];
                // 그림 범위 내에 있고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N){
                    // 방문하지 않았고 현재 정보와 같을 경우
                    if(!visited[nextY][nextX] &&
                            paint[nowY][nowX].equals(paint[nextY][nextX])){
                        // 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
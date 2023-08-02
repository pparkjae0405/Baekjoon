import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 상자의 세로 칸의 수 N, 가로 칸의 수 M,
    static int N, M;
    // 상자 배열 box, 방문 여부 visited,
    static int[][] box;
    static boolean[][] visited;
    // 이동 방향 dx, dy, bfs를 위한 큐 queue를 선언한다.
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. M과 N이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        // 3. box와 visited의 크기를 지정한다.
        box = new int[N][M];
        visited = new boolean[N][M];

        // 4. 상자에 저장된 토마토들의 정보 N*M가 주어지고 저장하는데
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                box[i][j] = Integer.parseInt(st.nextToken());

                // 1이면 큐에 해당 위치를 추가한 뒤
                if(box[i][j] == 1) queue.add(new int[]{i, j});
            }
        }

        // 5. 그래프 탐색을 수행한 결과를 출력한다.
        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 파악한 토마토 위치를 꺼내서 방문처리하고
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            visited[nowY][nowX] = true;

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // (nextY, nextX) 좌표가 상자 범위 안에 존재하고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                    // 해당 위치에 안익은 토마토가 존재하고 방문하지 않았을경우
                    if (box[nextY][nextX] == 0 && !visited[nextY][nextX]) {
                        // 해당 위치를 큐에 추가하고 날짜를 추가하여 box에 저장한 뒤 방문처리한다.
                        queue.add(new int[]{nextY, nextX});
                        box[nextY][nextX] = box[nowY][nowX] + 1;
                        visited[nextY][nextX] = true;
                    }
                }
            }
        }

        // 탐색을 끝냈는데 0이 있다면 -1 출력
        boolean isZero = false;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(box[i][j] == 0) {
                    isZero = true;
                }
            }
        }
        if(isZero){
            return -1;
        }else {
            // 이외에는 다 익는데 걸리는 날짜를 출력한다.
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(box[i][j] > max) max = box[i][j];
                }
            }
            return max - 1;
        }
    }
}
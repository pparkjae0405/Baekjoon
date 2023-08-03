import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 상자의 세로 크기 N, 가로 크기 M, 상자가 쌓인 개수 H
    static int N, M, H;
    // 3차원 상자 배열 box, 방문 여부 visited,
    static int[][][] box;
    static boolean[][][] visited;
    // 이동방향 dx, dy, dz, bfs를 위한 큐 선언
    static int[] dx = {-1, 1, 0, 0, 0, 0};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {0, 0, 0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. M, N, H가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        // 3. box와 visited의 크기를 설정
        box = new int[H][N][M];
        visited = new boolean[H][N][M];

        // 4. 상자에 저장된 토마토들의 정보 H*N*M가 주어지고 저장하는데
        for(int i = 0 ; i < H ; i++){
            for(int j = 0 ; j < N ; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 0 ; k < M ; k++){
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    // 1이면 큐에 해당 위치를 추가한 뒤
                    if(box[i][j][k] == 1) queue.add(new int[]{i, j, k});
                }
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
            int nowZ = now[0];
            int nowY = now[1];
            int nowX = now[2];
            visited[nowZ][nowY][nowX] = true;

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 6 ; i++){
                int nextZ = nowZ + dz[i];
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // (nextZ, nextY, nextX) 좌표가 상자 범위 안에 존재하고
                if(nextZ >= 0 && nextZ < H && nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    // 해당 위치에 안익은 토마토가 존재하고 방문하지 않았을 경우
                    if(box[nextZ][nextY][nextX] == 0 && !visited[nextZ][nextY][nextX]){
                        // 해당 위치를 큐에 추가하고 날짜를 추가하여 box에 저장한 뒤 방문처리한다.
                        queue.add(new int[]{nextZ, nextY, nextX});
                        box[nextZ][nextY][nextX] = box[nowZ][nowY][nowX] + 1;
                        visited[nextZ][nextY][nextX] = true;
                    }
                }
            }
        }

        // 탐색을 끝냈는데 0이 있다면 -1 출력
        boolean isZero = false;
        for(int i = 0 ; i < H ; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        isZero = true;
                    }
                }
            }
        }

        if(isZero){
            return -1;
        }else{
            // 이외에는 다 익는데 걸리는 날짜를 출력한다.
            int max = Integer.MIN_VALUE;
            for(int i = 0 ; i < H ; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (box[i][j][k] > max) {
                            max = box[i][j][k];
                        }
                    }
                }
            }

            return max - 1;
        }
    }
}
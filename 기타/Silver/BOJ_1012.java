import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 배추밭의 가로길이 M, 세로길이 N, 배추 위치 크기 K,
    static int M, N, K;
    // 배추밭 field, 방문여부 visited, 이동방향 dx, dy를 선언한다.
    static int[][] field;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 3. 테스트 케이스 개수만큼 반복하여
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++){
            // M, N, K를 입력받고
            st = new StringTokenizer(br.readLine(), " ");
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // field와 visited의 크기를 N*M만큼 설정한 뒤
            field = new int[N][M];
            visited = new boolean[N][M];

            // 4. K의 개수만큼 배추 위치를 입력받아
            for(int j = 0 ; j < K ; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                // 심어진 배추를 설정한다.
                field[y][x] = 1;
            }

            // 5. 배추밭을 돌면서
            int count = 0;
            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < M ; k++){
                    // 방문하지 않은 배추를 찾고
                    if(field[j][k] == 1 && !visited[j][k]){
                        // 배추밭 내의 연결된 배추 그룹의 수를 그래프 탐색을 통해 찾아
                        dfs(j, k);
                        count++;
                    }
                }
            }

            // 결과를 출력한다.
            bw.write(count + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int x, int y) {
        // 찾은 위치를 방문처리하고
        visited[x][y] = true;

        // 인접 위치를 탐색하여
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            // (nextX, nextY) 좌표가 밭 범위 안에 존재하고
            if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                // 해당 위치가 1이고 방문하지 않았을경우
                if (field[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    // 해당 위치로 이동시킨다.
                    dfs(nextX, nextY);
                }
            }
        }
    }
}
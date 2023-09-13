import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 방의 크기 N, 방을 표현할 room을 선언한다.
    static int N;
    static int[][] room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어진다.
        N = Integer.parseInt(br.readLine());

        // 3. room의 크기를 설정하고
        room = new int[N][N];
        // 방의 정보를 저장한다.
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. 경우의 수 배열 dp를 선언하고 초기값을 설정한다.
        long[][][] dp = new long[N + 1][N + 1][3];
        dp[0][1][0] = 1;

        // 5. 가로, 세로, 대각선의 경우를 설정한다.
        for(int i = 0 ; i < N ; i++){
            for(int j = 2 ; j < N ; j++){
                // 가로(0)는 가로 + 대각선,
                if(j - 1 >= 0 && room[i][j] == 0) {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                }

                // 세로(1)는 세로 + 대각선,
                if(i - 1 >= 0 && room[i][j] == 0) {
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                }

                // 대각선(2)은 가로 + 세로 + 대각선
                if(j - 1 >= 0 && i - 1 >= 0 &&
                        room[i][j] == 0 && room[i - 1][j] == 0 && room[i][j - 1] == 0) {
                    dp[i][j][2] = dp[i - 1][j - 1][0]
                            + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }

        // 6. 탐색 종료 후 경우의 수의 합을 출력한다.
        bw.write(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
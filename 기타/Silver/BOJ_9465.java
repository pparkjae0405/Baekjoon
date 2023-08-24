import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 케이스가 주어지는데
        for(int i = 0 ; i < T ; i++){
            // n이 주어지고 스티커 점수 배열 sticker과 점수 배열 dp를 선언하고
            int n = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            // 스티커 점수를 sticker에 저장한다.
            StringTokenizer st;
            for(int j = 0 ; j < 2 ; j++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int k = 1 ; k <= n ; k++){
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            // 초기값을 설정하고
            dp[0][1] = sticker[0][1];
            dp[1][1] = sticker[1][1];

            // 점화식에 따라 dp배열을 설정하여
            for(int j = 2 ; j <= n ; j++){
                dp[0][j] = Math.max(dp[1][j - 1], dp[1][j - 2]) + sticker[0][j];
                dp[1][j] = Math.max(dp[0][j - 1], dp[0][j - 2]) + sticker[1][j];
            }

            // 최댓값을 출력한다.
            bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
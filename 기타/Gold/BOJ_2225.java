import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N, K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2. 0 ~ N까지의 정수 중 K개를 선택하여 N을 만드는 경우의 수 dp를 선언하고
        int[][] dp = new int[N + 1][K + 1];
        // 초기값을 설정한 뒤
        for(int i = 1 ; i <= N ; i++){
            dp[i][1] = 1;
        }
        for(int i = 1 ; i <= K ; i++){
            dp[1][i] = i;
        }

        // 3. 범위를 돌면서 점화식에 따라 저장하고 10억으로 나눈 나머지를 출력한다.
        // dp[N][K] = dp[N - 1][K] + dp[N][K - 1]
        for(int i = 2 ; i <= N ; i++){
            for(int j = 2 ; j <= K ; j++){
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000000;
            }
        }
        bw.write(dp[N][K]+ "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
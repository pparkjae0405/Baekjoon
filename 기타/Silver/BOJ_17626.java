import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 자연수 n이 주어진다.
        int n = Integer.parseInt(br.readLine());

        // 2. n 범위까지의 제곱근 합의 최소 개수 dp 선언 및 초기값 설정
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // 3. 점화식에 따라 dp 설정
        for(int i = 2 ; i <= n ; i++){
            int min = Integer.MAX_VALUE;

            for (int j = 1 ; j * j <= i ; j++) {
                min = Math.min(min, dp[i - j * j]);
            }

            dp[i] = min + 1;
        }

        // 4. 몇 개의 제곱수들로 표현되는지 출력한다.
        bw.write(dp[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n이 주어지고 n만큼 dp배열을 선언한다.
        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];

        // 2. 초기값을 설정하고 n까지 돌면서 피보나치 수를 저장하고
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        // n번째 피보나치 수를 출력한다.
        bw.write(dp[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n이 주어진다.
        int n = Integer.parseInt(br.readLine());

        // 2. 1 ~ n까지의 피보나치 수 dp를 선언하고 초기값을 저장한다.
        BigInteger[] dp = new BigInteger[n + 1];
        dp[0] = new BigInteger("0");
        if(n >= 1) {
            dp[1] = new BigInteger("1");
        }

        // 3. 2 이상일 경우 n까지의 값을 저장하고 출력한다.
        if(n >= 2) {
            for (int i = 2; i <= n; i++) {
                dp[i] = dp[i - 1].add(dp[i - 2]);
            }
        }
        bw.write(dp[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n이 주어진다.
        int n = Integer.parseInt(br.readLine());

        // 2. 45까지의 피보나치 배열 dp를 선언하고 초기값을 설정한 뒤
        int[] dp = new int[46];
        dp[0] = 0;
        dp[1] = 1;

        // 3. 2 ~ n까지 돌면서 피보나치 수를 설정하고
        for(int i = 2 ; i <= n ; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // 3. n번째 피보나치 수를 출력한다.
        bw.write(dp[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
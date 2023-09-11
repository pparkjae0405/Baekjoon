import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. dp를 선언한 뒤 초기값을 설정하고
        int[] dp = new int[N + 1];
        dp[0] = 1;

        // 3. 점화식에 따라 dp를 설정한 뒤
        for(int i = 2 ; i <= N ; i += 2){
            dp[i] = dp[i - 2] * 3;
            for(int j = i - 4 ; j >= 0 ; j -= 2){
                dp[i] += dp[j] * 2;
            }
        }

        // 4. N의 경우의 수를 출력한다.
        bw.write(dp[N] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
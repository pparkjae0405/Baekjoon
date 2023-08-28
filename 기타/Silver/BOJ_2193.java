import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N까지의 이친수의 개수 배열 dp를 선언한다.
        long[] dp = new long[N + 1];

        // 3. 1, 2일 경우 1 출력,
        if(N < 3){
            bw.write(1 + "\n");
        }else{
            // 3 이상일 경우 초기값을 설정하고
            dp[1] = 1;
            dp[2] = 1;
            // 점화식을 통해 N까지의 개수를 지정한 뒤 결과를 출력한다.
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            bw.write(dp[N] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
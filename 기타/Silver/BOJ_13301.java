import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 타일의 개수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N까지의 타일의 값을 저장한 뒤
        long[] dp = new long[N + 1];
        if(N == 1){
            bw.write(4 + "\n");
        }else{
            // 초기값을 설정하고 점화식에 따라 값을 저장한다.
            dp[1] = 4;
            dp[2] = 6;
            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }

            // 3. 직사각형의 둘레를 출력한다.
            bw.write(dp[N] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
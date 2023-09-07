import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n이 주어진다.
        int n = Integer.parseInt(br.readLine());

        // 2. dp 배열을 선언하고 초기값을 설정한다.
        int[] dp = new int[100001];
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        // 3. 5 이하면 해당하는 dp값을,
        if(n <= 5){
            bw.write(dp[n] + "\n");
        }else{
            // 이외에는 6 ~ n까지 돌면서 dp를 설정한다.
            for(int i = 6 ; i <= n ; i++){
                if(dp[i - 2] == - 1 && dp[i - 5] == -1){
                    dp[i] = -1;
                }else if(dp[i - 2] == -1){
                    dp[i] = dp[i - 5] + 1;
                }else if(dp[i - 5] == -1){
                    dp[i] = dp[i - 2] + 1;
                }else{
                    dp[i] = Math.min(dp[i - 5], dp[i - 2]) + 1;
                }
            }
            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
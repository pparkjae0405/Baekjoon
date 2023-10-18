import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n, k가 주어진다
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 2. dp 배열을 선언하고 초기값을 저장한다.
        int[][] dp = new int[31][31];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;

        // 3. n행k열 까지의 값을 저장하고 출력한다.
        for(int i = 3 ; i <= n ; i++){
            for(int j = 1 ; j <= i ; j++){
                if(j == 1 || j == i) dp[i][j] = 1;
                else  dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
        bw.write(dp[n][k] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
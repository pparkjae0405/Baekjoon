import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 자연수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. dp 배열을 선언한 뒤
        int[] dp = new int[N + 1];
        // 1 ~ N까지 돌면서 개수를 저장하고
        for(int i = 1 ; i <= N ; i++){
            dp[i] = i;
            for(int j = 1 ; j * j <= i ; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        // 결과를 출력한다.
        bw.write(dp[N] + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
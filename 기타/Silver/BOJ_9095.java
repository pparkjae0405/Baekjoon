import java.io.*;

public class Main{
    // 1. 11까지의 경우의 수 배열 dp를 선언한다.
    static int[] dp = new int[11];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 테스트 케이스 개수 T가 주어지고 dp의 초기값을 설정한다.
        int T = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        // 3. 나머지 결과값을 계산하여 dp에 저장한다.
        for(int i = 4 ; i < 11 ; i++){
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }

        // 4. T만큼 정수 n이 주어지고, 결과를 출력한다.
        for(int i = 0 ; i < T ; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
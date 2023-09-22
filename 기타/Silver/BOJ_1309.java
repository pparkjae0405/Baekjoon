import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 우리의 세로 크기 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 현재 칸에 배치할 수 있는 경우 dp를 선언하고 초기값을 저장한다.
        long[][] dp = new long[N + 1][3];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        // 3. 2 ~ N번째 줄까지 돌면서
        for(int i = 2 ; i <= N ; i++){
            // dp[i][0] : i번째 줄에 한 마리도 배치하지 않는 경우
            // 아무 영향도 주지 않으므로 그대로 저장,
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            // dp[i][1] : i번째 줄 1번째 칸에 배치하는 경우
            // 위, 오른쪽엔 동물이 들어올 수 없으므로 해당 칸을 제외하고 저장,
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            // dp[i][2] : i번째 줄 2번째 칸에 배치하는 경우
            // 위, 왼쪽엔 동물이 들어올 수 없으므로 해당 칸을 제외하고 저장한다.
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        // 4. N번째 줄에 해당하는 경우의 수를 출력한다.
        long result = (dp[N][0] + dp[N][1] + dp[N][2]) % 9901;
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
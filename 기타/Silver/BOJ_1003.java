import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. 2차원 배열을 선언하여 초기값(0과 1) 설정
        int[][] dp = new int[41][2];
        dp[0][0] = 1; dp[0][1] = 0;
        dp[1][0] = 0; dp[1][1] = 1;

        // N의 범위만큼 0과 1의 출력 횟수를 저장하고,
        for(int i = 2 ; i <= 40 ; i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        // 2. T만큼 N이 주어지고 N에 해당하는 횟수를 불러와 출력한다.
        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());
            bw.write(dp[N][0] + " " + dp[N][1] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
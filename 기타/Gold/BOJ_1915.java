import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. N*M 크기의 보드 dp를 선언하고 정보를 받아오면서
        int[][] dp = new int[N + 1][M + 1];
        long len = 0;
        for(int i = 1 ; i <= N ; i++){
            String str = br.readLine();
            for(int j = 1 ; j <= M ; j++){
                int value = str.charAt(j - 1) - '0';

                // 현재 값이 1일 경우에만
                if(value == 1) {
                    // 현재 위치에서 왼쪽, 위쪽, 왼쪽 대각선 중
                    // 가장 작은 값 + 1을 현재 위치로 설정하고
                    dp[i][j] = Math.min(dp[i - 1][j],
                            Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;

                    // len을 갱신한다.
                    len = Math.max(len, dp[i][j]);
                }
            }
        }

        // 3. len에 해당하는 사각형의 넓이를 출력한다.
        bw.write(len * len + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
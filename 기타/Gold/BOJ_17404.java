import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 집의 수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 각 집을 빨, 초, 파로 칠하는 비용을 저장한다.
        int[][] color = new int[N + 1][3];
        StringTokenizer st;
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 3 ; j++){
                color[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 각 집의 칠하는 비용 dp를 선언하고
        int[][] dp = new int[N + 1][3];
        // 첫 집을 빨, 초, 파로 칠하는 경우
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                // 해당하는 색을 칠하는 비용을 저장하고
                if(j == i) dp[1][j] = color[1][j];
                // 이외의 색은 최댓값으로 저장한다.
                else dp[1][j] = 1000000;
            }

            // 2 ~ N까지 돌면서 최솟값을 설정한다.
            for(int j = 2 ; j <= N ; j++){
                dp[j][0] = Math.min(dp[j - 1][1], dp[j - 1][2]) + color[j][0];
                dp[j][1] = Math.min(dp[j - 1][0], dp[j - 1][2]) + color[j][1];
                dp[j][2] = Math.min(dp[j - 1][0], dp[j - 1][1]) + color[j][2];
            }

            // 탐색이 끝났을 경우
            for(int j = 0 ; j < 3 ; j++){
                // 마지막 집의 색이 첫 집과 다른 경우의 최솟값을 찾아 min을 갱신한다.
                if(i != j) min = Math.min(min, dp[N][j]);
            }
        }

        // 4. min을 출력한다.
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 삼각형의 크기 n이 주어진다.
        int n = Integer.parseInt(br.readLine());

        // 2. 삼각형 정보 arr과 dp 배열을 선언한다.
        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        // 3. arr의 정보를 저장한다.
        StringTokenizer st;
        for(int i = 1 ; i <= n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= i ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. 점화식에 따라 dp를 저장한다.
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                // 해당 위치는 왼쪽 위 값과 오른쪽 위의 값 중 큰 값 + 본인 값
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }

        // 5. 마지막 층의 최댓값을 구해 출력한다.
        int answer = 0;
        for(int i = 1 ; i <= n ; i++){
            if(answer < dp[n][i]) answer =  dp[n][i];
        }
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}
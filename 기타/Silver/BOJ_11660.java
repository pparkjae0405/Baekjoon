import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 표의 크기 N과 합을 구해야 하는 횟수 M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. dp 배열을 선언하고 줄 별 누적합을 저장한 뒤
        int[][] dp = new int[N + 1][N + 1];
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++){
                dp[i][j] = dp[i][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        // 3. M개의 줄에 네 개의 정수 x1, y1, x2, y2가 주어지면
        for(int i = 0 ; i < M ; i++) {
            // (x1, y1)부터 (x2, y2)의 합을 출력한다.
            int sum = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int j = x1 ; j <= x2 ; j++){
                sum += (dp[j][y2] - dp[j][y1 - 1]);
            }
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
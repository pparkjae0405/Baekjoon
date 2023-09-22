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

        // 2. N*M 크기의 미로 maze를 선언하고 정보를 저장한다.
        int[][] maze = new int[N + 1][M + 1];
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= M ; j++){
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 최대 사탕의 개수 dp를 선언하고
        int[][] dp = new int[N + 1][M + 1];
        // (1, 1) ~ (N, M)까지 돌면서 최댓값을 갱신한다.
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= M ; j++){
                // 현재 위치의 최댓값 = 왼쪽, 위, 왼쪽 대각선위 값 중 최댓값 + 현재값
                dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + maze[i][j];
            }
        }

        // 4. (N, M) 까지의 사탕 최대 개수를 출력한다.
        bw.write(dp[N][M] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
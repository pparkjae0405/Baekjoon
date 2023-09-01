import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n, k가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 2. 1 ~ k까지의 경우의 수 dp를 선언하고 초기값을 설정한다.
        int[] dp = new int[k + 1];
        dp[0] = 1;

        // 3. 동전의 가치 coin의 크기를 설정하고
        int[] coin = new int[n + 1];
        // n만큼 동전의 가치가 주어지면
        for(int i = 1 ; i <= n ; i++){
            coin[i] = Integer.parseInt(br.readLine());

            // 동전의 가치 ~ k까지 돌면서 동전의 가치로 만들 수 있는 경우의 수를 저장한다.
            for(int j = coin[i] ; j <= k ; j++){
                dp[j] += dp[j - coin[i]];
            }
        }

        // 4. k의 경우의 수를 출력한다.
        bw.write(dp[k] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
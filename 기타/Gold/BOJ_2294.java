import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n, k가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // 2. n가지 동전의 종류 coin를 선언하고
        int[] coin = new int[n];
        // 동전 종류를 저장한다.
        for(int i = 0 ; i < n ; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        // 3. 1 ~ k의 동전을 만드는 최소 개수 dp를 선언하고
        int[] dp = new int[k + 1];
        // 동전의 최대개수 + 1인 100001로 초기화하고 초기값을 설정한다.
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        // 4. 동전의 종류를 돌면서
        for(int i = 0 ; i < n ; i++) {
            // 동전의 가치 ~ k까지
            for(int j = coin[i] ; j <= k ; j++){
                // 만들수 있는 동전의 최소 개수를 갱신한다.
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        // 5. dp[k]가 100001이면 만들 수 없으므로 -1,
        if(dp[k] == 100001){
            bw.write(-1 + "\n");
        }else {
            // 이외에는 해당 값을 출력한다.
            bw.write(dp[k] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
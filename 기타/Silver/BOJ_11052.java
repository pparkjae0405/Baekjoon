import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 카드 개수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 1 ~ N까지의 카드가 든 카드팩의 가격이 주어지고
        int[] card = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        // 3. dp 배열을 선언하고
        int[] dp = new int[N + 1];
        // 1 ~ N까지의 카드를 가지기 위해
        for(int i = 1 ; i <= N ; i++){
            // 현재 값, j - i의 최댓값 + i개짜리 카드팩 중 더 큰 것으로 갱신하여
            for(int j = 1 ; j <= i ; j++){
                dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
            }
        }
        // 결과를 출력한다.
        bw.write(dp[N] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
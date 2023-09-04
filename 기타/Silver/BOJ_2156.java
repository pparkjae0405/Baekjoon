import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 포도주 잔의 개수 n이 주어진다.
        int n = Integer.parseInt(br.readLine());

        // 2. n만큼 포도주 양을 저장하고,
        int[] drink = new int[n + 1];
        for(int i = 1 ; i <= n ; i++){
            drink[i] = Integer.parseInt(br.readLine());
        }

        // 3. dp 배열을 선언한 뒤 초기값을 설정하고
        int[] dp = new int[n + 1];
        if(n == 1) {
            dp[1] = drink[1];
        }else {
            dp[1] = drink[1];
            dp[2] = drink[1] + drink[2];
        }

        // 4. 1, 2일 경우는 dp[1], dp[2]를,
        if(n == 1){
            bw.write(dp[1] + "\n");
        }else if(n == 2){
            bw.write(dp[2] + "\n");
        }else{
            // 이외에는 포도주를 돌면서
            for(int i = 3 ; i <= n ; i++){
                // 이전값 vs 먹고 패스하고 1잔 vs 먹고 패스하고 2잔 중 최대값을 저장하고
                dp[i] = Math.max(dp[i - 1],
                        Math.max(dp[i - 2] + drink[i], dp[i - 3] + drink[i - 1] + drink[i]));
            }
            // 최대 양을 출력한다.
            bw.write(dp[n] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
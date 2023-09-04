import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N, 나머지를 구할 remain이 주어진다.
        int N = Integer.parseInt(br.readLine());
        int remain = 1000000000;

        // 2. 계단수의 개수 dp를 선언하고
        long[][] dp = new long[N + 1][10];
        // 초기값을 설정한다.(1번째 자리수에 1 ~ 9가 올 때)
        for(int i = 1 ; i < 10 ; i++){
            dp[1][i] = 1;
        }

        // 3. 2번째 자리수 ~ N번째 자리수에
        for(int i = 2 ; i <= N ; i++){
            // 0 ~ 9가 올 경우를 dp에 저장하는데
            for(int j = 0 ; j < 10 ; j++){
                // 0일 경우 이전 자리수는 1만 올 수 있음
                if(j == 0){
                    dp[i][j] = dp[i - 1][1] % remain;
                }else if(j == 9){
                    // 9일 경우 이전 자리수는 8만 올 수 있음
                    dp[i][j] = dp[i - 1][8] % remain;
                }else {
                    // 그 외에는 -1, +1이 올 수 있음
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % remain;
                }
            }
        }

        // 4. 원하는 자리수에 해당하는 계단 수의 합을 찾아
        long sum = 0;
        for(int i = 0 ; i < 10 ; i++){
            sum += dp[N][i];
        }
        // remain으로 나눈 나머지를 출력한다.
        bw.write(sum % remain + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
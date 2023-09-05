import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. dp 배열을 선언하고 초기값을 설정한다.
        int[][] dp = new int[N][10];
        for(int i = 0 ; i < 10 ; i ++){
            dp[0][i] = 1;
        }

        // 3. N이 1이면 0번째 줄의 개수,
        if(N == 1){
            int count = 0;
            for(int i = 0 ; i < 10 ; i++){
                count += dp[0][i];
            }
            bw.write(count + "\n");
        }else{
            // 이외에는 N까지 돌면서
            for(int i = 1 ; i < N; i++){
                for(int j = 0 ; j < 10 ; j++){
                    // 0 ~ 8까지는 그 전줄의 j ~ 9까지의 합
                    if(j != 9){
                        // 나머지는 그전 줄의 j ~ 9까지의 합
                        int sum = 0;
                        for(int k = j ; k < 10 ; k++){
                            sum += dp[i - 1][k];
                        }
                        dp[i][j] = sum % 10007;
                    }else{
                        // j가 9면 위의 값으로 저장
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }

            // 해당하는 개수를 출력한다.
            int sum = 0;
            for(int i = 0 ; i < 10 ; i++){
                sum += dp[N - 1][i];
            }
            bw.write(sum % 10007 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 물품의 수 N, 가방 무게의 최대치 K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2. 가방에 넣을 수 있는 최대 가치 dp, 물품 정보 item 배열을 선언하고
        int[][] dp = new int[N + 1][K + 1];
        int[][] item = new int[N + 1][2];
        // N만큼 무게 W와 가치 V가 주어진 뒤 item에 저장한다.
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            item[i][0] = W;
            item[i][1] = V;
        }

        // 3. dp의 물품 별로 배낭 크기를 돌면서
        for(int i = 1 ; i <= N ; i++){
            for(int j = 1 ; j <= K ; j++){
                // 물품이 가방에 넣을 수 있는 무게라면
                if(item[i][0] <= j){
                    // 이전 물품과 같이 넣을 수 있는 경우 > 이전 경우 라면
                    if(item[i][1] + dp[i - 1][j - item[i][0]] > dp[i - 1][j]){
                        // 이전 값을 빼고 이전 물품과 같이 넣고
                        dp[i][j] = item[i][1] + dp[i - 1][j - item[i][0]];
                    }else{
                        // 이외에는 이전 값을 그대로 사용
                        dp[i][j] = dp[i - 1][j];
                    }
                }else{
                    // 가방에 넣을 수 없는 무게라면 이전 값을 그대로 사용
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // 4. dp를 돌고 난 최대 가치를 출력한다.
        bw.write(dp[N][K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
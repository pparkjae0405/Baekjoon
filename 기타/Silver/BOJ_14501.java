import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 날짜 별 상담시간, 금액 배열 cal을 선언하고
        int[][] cal = new int[N + 1][N + 1];
        // N만큼 상담시간, 금액을 저장한다.
        StringTokenizer st;
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int time = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            cal[i][0] = time;
            cal[i][1] = price;
        }

        // 3. 퇴사일까지 버는 돈 dp를 선언하고
        int[] dp = new int[N + 2];
        // 퇴사 전일부터 1일까지 돌면서
        for(int i = N ; i > 0 ; i--){
            // 현재 날짜의 상담을 수행했을 경우에 끝나는 날짜를 계산해
            int end = i + cal[i][0];

            // 퇴사일을 넘어가는 경우
            if(end > N + 1){
                // 일을 하지 못하므로 이전값으로 설정하고
                dp[i] = dp[i + 1];
            }else{
                // 일을 할 수 있을 경우
                // 일을 하지 않았을때와 일했을 때 벌 수 있는 금액 중 더 큰 값을 설정한다.
                dp[i] = Math.max(dp[i + 1], cal[i][1] + dp[end]);
            }
        }

        // 4. 끝까지 돌았을 때 최대로 벌 수 있는 금액을 출력한다.
        bw.write(dp[1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
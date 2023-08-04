import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 계단의 개수가 주어진다.
        int n = Integer.parseInt(br.readLine());

        // 2. 계단의 개수만큼 배열을 선언하고,
        int[] stair = new int[n + 1];

        // 3. 계단의 개수만큼 점수를 입력받는다.
        for(int i = 1 ; i <= n ; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        // 4. 계단 별 최댓값 배열을 선언하고 초기값을 설정
        int[] dp = new int[n + 1];
        dp[1] = stair[1];

        // 5. 점화식을 통해 계단 별 최댓값을 계산하는데
        for(int i = 2 ; i <= n ; i++){
            if(i == 2){
                // i가 2면 첫 번째 계단 + 두 번째 계단
                dp[2] = stair[1] + stair[2];
            }else if(i == 3){
                // i가 3이면 첫 번째와 두 번째 계단 중 더 높은 곳 + 세 번째 계단
                dp[3] = Math.max(stair[1], stair[2]) + stair[3];
            }else{
                // 이외에는
                // i까지 가기 위한 경우의 수로
                // i-3까지의 최댓값 + 2칸과 i-2까지의 최댓값 중 더 높은 점수 + 1칸으로 계산
                dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i-2]) + stair[i];
            }
        }

        // 5. 총 점수의 최댓값을 출력한다.
        bw.write(dp[n] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
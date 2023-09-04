import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수열 A의 크기 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N만큼 수열이 주어지고 A에 저장한다.
        int[] A = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 감소하는 수열의 길이 dp를 선언하고
        int[] dp = new int[N + 1];
        // 1 ~ N까지 돌면서
        int max = 0;
        for(int i = 1 ; i <= N ; i++){
            // 현재 위치값을 선택했으므로 1
            dp[i] = 1;

            // 선택한 위치의 앞쪽 값들과 비교하여
            for(int j = 1 ; j < i ; j++){
                // 비교값 > 현재값 일 경우 감소하는 배열이므로
                if(A[j] > A[i]){
                    // 현재값과 이전값 + 1을 비교하여 더 큰 값을 저장한다.
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            // 최댓값을 갱신한다.
            max = Math.max(max, dp[i]);
        }
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
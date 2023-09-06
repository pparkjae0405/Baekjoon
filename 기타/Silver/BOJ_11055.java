import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수열 A의 크기 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 수열 A의 정보를 저장한다.
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 증가하는 수열의 최댓값 dp를 선언하고 초기값을 설정한 뒤
        int[] dp = new int[N];
        dp[0] = A[0];

        // 4. 1 ~ N까지 돌면서
        int max = dp[0];
        for(int i = 1 ; i < N ; i++){
            // 값을 선택하고
            dp[i] = A[i];

            // 0 ~ i까지 돌면서 증가하는 부분수열의 합을 저장한 뒤
            for(int j = 0 ; j < i ; j++){
                if(A[i] > A[j]){
                    // i번째까지 증가하는 부분수열의 최댓값과
                    // i번째 값 + j번째까지 증가하는 부분수열의 최댓값 중 큰 것을 저장한다.
                    dp[i] = Math.max(dp[i], A[i] + dp[j]);
                }
            }
            // 최댓값을 갱신하여
            if(dp[i] > max) max = dp[i];
        }
        // 결과를 출력한다.
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
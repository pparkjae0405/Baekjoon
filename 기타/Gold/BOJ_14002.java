import java.io.*;
import java.util.Stack;
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

        // 3. 증가하는 수열의 최대 개수 dp를 선언하고 초기값을 설정한 뒤
        int[] dp = new int[N];
        dp[0] = 1;
        // 최대 길이 max를 선언하고 1 ~ N-1까지 돌면서
        int max = 1;
        for(int i = 1 ; i < N ; i++){
            // 수열의 길이를 설정하고
            dp[i] = 1;

            // 0 ~ i - 1까지 돌면서
            for(int j = 0 ; j < i ; j++){
                // 증가하는 부분수열이면
                if(A[i] > A[j]){
                    // 현재 길이와 이전 위치까지의 길이 + 1 중 큰 것으로 설정하고
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    // max값을 갱신하여
                    max = Math.max(max, dp[i]);
                }
            }
        }
        // 결과를 출력한다.
        bw.write(max + "\n");

        // 4. 수열을 출력하기 위한 arr를 선언하고
        int[] arr = new int[max];
        // N - 1부터 0까지 돌면서
        for(int i = N - 1 ; i >= 0 ; i--){
            // 해당 위치까지의 길이가 max값이라면
            if(dp[i] == max) {
                // 값을 저장하고 max값을 1 감소시킨다.
                arr[max - 1] = A[i];
                max--;
            }
        }
        // 0 ~ arr의 크기까지 돌면서 값을 출력한다.
        for(int i = 0 ; i < arr.length ; i++){
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
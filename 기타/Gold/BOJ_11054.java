import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수열 A의 크기 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N만큼의 수를 A에 저장한다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] A = new int[N];
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 고르는 수 기준 왼쪽 바이토닉 수열의 개수 left_dp를 선언하고
        int[] left_dp = new int[N];
        for(int i = 0 ; i < N ; i++){
            // 수를 고른 뒤
            left_dp[i] = 1;
            for(int j = 0 ; j < i ; j++){
                // 맨 앞 ~ i - 1까지 돌면서 A[i] > A[j]일 경우
                if(A[i] > A[j]){
                    // dp를 갱신하고
                    left_dp[i] = Math.max(left_dp[j] + 1, left_dp[i]);
                }
            }
        }

        // 고르는 수 기준 오른쪽 바이토닉 수열의 개수 right_dp를 선언하고
        int[] right_dp = new int[N];
        for(int i = N - 1 ; i >= 0 ; i--){
            // 수를 고른 뒤
            right_dp[i] = 1;
            for(int j = N - 1 ; j > i ; j--){
                // 맨 뒤 ~ i + 1까지 돌면서 A[i] > A[j]일 경우
                if(A[i] > A[j]){
                    // dp를 갱신하여
                    right_dp[i] = Math.max(right_dp[j] + 1, right_dp[i]);
                }
            }
        }

        // 4. 인덱스 별 바이토닉의 개수의 합의 최댓값을 찾은 뒤
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            max = Math.max(max, left_dp[i] + right_dp[i]);
        }
        // 겹치는 수를 빼서 출력한다.
        bw.write(max - 1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
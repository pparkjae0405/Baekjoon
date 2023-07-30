import java.io.*;

public class Main{
    // 1. DP를 저장할 배열을 선언한다.
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 정수 N이 주어지고, dp의 크기와 초기값(0, 1)을 설정한다.
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        dp[0] = 0;
        dp[1] = 0;

        // 3. 함수를 호출하여 최솟값을 출력한다.
        bw.write(recur(N) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    // 4. 재귀를 통해 최솟값을 찾는데
    static int recur(int N){
        if(dp[N] == null){
            if(N % 6 == 0){
                // 6으로 나누어 떨어지는 경우에는
                // 3으로 나누었을 때, 2로 나누었을 때, 1을 뺐을때의 경우 중 최솟값을 저장,
                dp[N] = Math.min(recur(N / 3), Math.min(recur(N / 2), recur(N - 1))) + 1;
            }else if(N % 3 == 0){
                // 3으로만 나누어 떨어지는 경우에는
                // 3으로 나누었을 때, 1을 뺐을때의 경우 중 최솟값을 저장,
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            }else if(N % 2 == 0){
                // 2으로 나누어 떨어지는 경우에는
                // 2로 나누었을 때, 1을 뺐을 떄의 경우 중 최솟값을 저장,
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            }else{
                // 이외의 경우에는 1을 빼는 경우만 호출
                dp[N] = recur(N - 1) + 1;
            }
        }
        // 결과로 나온 최솟값을 리턴
        return dp[N];
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수열 A의 크기 N가 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N만큼 수열이 주어지고 저장한다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 수열의 길이 dp를 선언하고 초기값을 설정한 뒤
        int[] dp = new int[N];
        dp[0] = 1;
        // 1 ~ N-1까지 돌면서
        for(int i = 1 ; i < N ; i++){
            // 수열의 길이를 선언하고
            dp[i] = 1;
            // 0 ~ i-1까지 수열 중
            for(int j = 0 ; j < i ; j++){
                // 값이 더 작고 수열의 크기가 더 큰 곳이 있다면
                if(arr[j] < arr[i] && dp[i] <= dp[j]){
                    // 해당 위치를 이전 위치 + 1 하여 추가
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // 4. 수열 A의 가장 긴 증가하는 부분 수열의 길이를 출력한다.
        int max = -1;
        for(int i = 0 ; i < N ; i++){
            if(dp[i] > max) max = dp[i];
        }
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
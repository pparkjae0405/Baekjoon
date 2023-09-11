import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 두 전봇대 사이의 전깃줄의 개수 N이 주어지고
        int N = Integer.parseInt(br.readLine());
        // a와 b 전봇대의 연결 정보를 저장할 pole를 선언한다.
        int[][] pole = new int[N][2];

        // 2. N만큼 A와 B 전봇대가 연결되는 위치 번호가 주어진다.
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pole[i][0] = a;
            pole[i][1] = b;
        }

        // 3. A 전봇대를 기준으로 pole을 정렬한다.
        Arrays.sort(pole, (int[] o1, int[] o2) -> o1[0] - o2[0]);

        // 4. dp 배열을 선언한 뒤
        int[] dp = new int[N];
        // 겹치지 않게 설치하는 최댓값을 찾아
        for(int i = 0 ; i < N ; i++){
            // 현재 개수를 설정하고
            dp[i] = 1;

            // 현재 위치보다 작은 위치를 탐색하여
            for(int j = 0 ; j < i ; j++){
                // 현재 도착 위치 > 이전 도착 위치일 경우
                if(pole[i][1] > pole[j][1]){
                    // 겹치지 않으므로 현재위치, 이전위치 + 1 중 큰 것을 저장한다.
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // 5. 최댓값 max를 선언하고 dp를 탐색하여 저장한 뒤
        int max = 0;
        for(int i = 0 ; i < N ; i++){
            if(dp[i] > max) max = dp[i];
        }
        // 개수 - max를 출력한다.
        bw.write(N - max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
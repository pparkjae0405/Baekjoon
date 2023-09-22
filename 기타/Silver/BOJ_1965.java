import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 상자 정보 box를 저장한다.
        int[] box = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++){
            box[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 박스 별 최대 상자 개수 dp를 선언하고
        int[] dp = new int[N + 1];
        // 첫 번째 값을 저장한 뒤
        dp[1] = 1;

        // 4. 2 ~ N번째 상자까지 돌면서
        for(int i = 2 ; i <= N ; i++){
            int max = 0;
            // 해당 박스와 이전 박스들을 비교하여
            for(int j = 1 ; j < i ; j++){
                // 현재 박스가 더 큰 경우의 최대 상자 개수를 찾아
                if(box[i] > box[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            // max + 1 하여 dp를 설정한다.
            dp[i] = max + 1;
        }

        // 5. 1 ~ N까지의 상자 중 최대 개수를 찾아 출력한다.
        int max = 0;
        for(int i = 1 ; i <= N ; i++){
            max = Math.max(max, dp[i]);
        }
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
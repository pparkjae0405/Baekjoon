import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 이동하려고 하는 채널 N, 고장난 버튼의 개수 M이 주어진다.
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 2. 0 ~ 9까지의 버튼 고장 여부 numError를 선언해 고장 여부를 설정한다.
        boolean[] numError = new boolean[10];
        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < M; i++) {
                int error = Integer.parseInt(st.nextToken());
                numError[error] = true;
            }
        }

        // 3. 원하는 채널 ans를 찾는데
        // 초기값은 N까지 +, -로만 갈 경우 필요한 버튼입력 횟수를 지정해놓고
        int ans = Math.abs(N - 100);

        // N의 범위가 500,000까지이므로 0 ~ 999,999까지 전체탐색하여
        for(int i = 0 ; i < 1000000 ; i++){
            // 해당 채널 channel을 선언하여
            String channel = String.valueOf(i);

            // channel의 길이만큼 반복하는데
            boolean isError = false;
            for(int j = 0 ; j < channel.length() ; j++) {
                // 고장난 버튼을 눌러야하면 isError를 true로 바꾸고 탈출시켜
                if(numError[channel.charAt(j) - '0']) {
                    isError = true;
                    break;
                }
            }

            // 해당 채널을 누를 때 고장난 버튼을 누르지 않았다면
            if(!isError) {
                // 채널을 가기 위해 누른 버튼 수 + 채널에서 N까지 +, -로만 갈 경우 필요한 버튼 수를 설정하여
                int min = channel.length() + Math.abs(N - i);
                // ans와 비교하여 최솟값을 찾는다.
                ans = Math.min(min, ans);
            }
        }

        // 4. answer를 출력한다.
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
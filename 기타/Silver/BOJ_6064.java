import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 데이터 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 M, N, x, y가 공백을 기준으로 주어지고,
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            // 결과값이 있는지 확인할 check를 선언하고
            // x부터 N*M까지 M씩 증가하면서
            boolean check = false;
            for (int j = x; j < (N * M); j += M) {
                // j%N이 y가 된다면 check를 true로 설정하고 해당하는 j+1를 출력,
                if (j % N == y) {
                    check = true;
                    bw.write(j+1 + "\n");
                    break;
                }
            }

            // check가 false라면 -1를 출력한다.
            if (!check) {
                bw.write(-1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
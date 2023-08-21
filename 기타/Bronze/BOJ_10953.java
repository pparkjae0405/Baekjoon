import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. 각 케이스마다 "A,B" 가 주어지고 A+B를 출력한다.
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine(), ",");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            bw.write(A+B + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
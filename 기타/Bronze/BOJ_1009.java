import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. 각 케이스에 대해 a, b가 주어지고,
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 마지막 데이터가 처리될 번호를 구해 출력한다.
            if(a % 10 == 0){
                bw.write(10 + "\n");
                continue;
            }
            int num = a % 10;
            for(int j = 1 ; j < b ; j++){
                num = (num * a) % 10;
            }
            bw.write(num + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
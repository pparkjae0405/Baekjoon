import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 검증수 result를 선언한다.
        int result = 0;

        // 2. 고유번호 5개가 주어지고 제곱의 합을 result에 추가한다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 5 ; i++){
            int a = Integer.parseInt(st.nextToken());
            result += a*a;
        }

        // 3. 제곱의 합을 10으로 나눈 나머지를 출력한다.
        bw.write(result%10 + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 밑, 지수, 나머지 값 A, B, C가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long A = Integer.parseInt(st.nextToken());
        long B = Integer.parseInt(st.nextToken());
        long C = Integer.parseInt(st.nextToken());

        // 2. 재귀함수를 호출하여 결과를 출력한다.
        bw.write(cal(A, B, C) % C + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 3. 재귀함수를 구현하여
    public static long cal(long a, long b, long c){
        // 지수가 0이면 a^0 = 1 리턴
        if(b == 0){
            return 1;
        }else if(b == 1){
            // 1이면 a^1 = a 리턴
            return a;
        }else if(b % 2 == 0){
            // 짝수면 (a^(b/2))^2
            long temp = cal(a, b / 2, c) % c;
            return (temp * temp) % c;
        }else{
            // 홀수면 (a^(b/2))^2 * a로 분할한다.
            long temp = cal(a, b / 2, c) % c;
            return (temp * temp % c) * a % c;
        }
    }
}
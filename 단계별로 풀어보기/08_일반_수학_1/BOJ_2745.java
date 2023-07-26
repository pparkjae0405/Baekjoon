import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. B진법 숫자 N이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        // 2. 변환값 result, B진법의 승 square, 각 자리수 계산값 digit 선언
        long result = 0;
        int square = 0;
        int digit = 0;

        // 3. B진법 숫자 N을 10진법으로 바꾸는데
        for(int i = N.length()-1 ; i >= 0 ; i--){
            char ch = N.charAt(i);
            if(ch >= '0' && ch <= '9'){
                // 0 ~ 9는 그대로
                digit = ch - '0';
            }else{
                // A ~ Z는 숫자로 변경
                digit = ch - 55;
            }

            // 해당값을 10진수로 바꿔 result에 추가한다.
            result += digit * Math.pow(B, square++);
        }

        // 4. 결과를 리턴한다.
        bw.write(result + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
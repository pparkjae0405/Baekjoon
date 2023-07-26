import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 10진법 숫자 N, 변환할 진법 B가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 2. 10진법 숫자 N을 B진법으로 바꾼다.
        String result = "";
        while(N > 0){
            // N을 B로 나눈 나머지가 10 미만이라면 그 수를,
            if(N % B < 10){
                result += (char)(N % B + '0');
            }else{
                // 10 이상이라면 해당 숫자에 해당하는 값으로 변경하여 추가
                result += (char)(N % B + 55);
            }
            N /= B;
        }

        // 3. 결과값을 반대로 출력한다.
        for(int i = result.length()-1 ; i >= 0 ; i--){
            bw.write(result.charAt(i) + "");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
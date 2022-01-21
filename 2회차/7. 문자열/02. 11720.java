import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 합계 sum을 선언하고 숫자의 개수 N을 입력받음
        int sum = 0;
        int N = Integer.parseInt(br.readLine());
        // 2. 문자열을 이용하여 공백없는 숫자를 입력받음
        String s = br.readLine();
        // 3. 문자열 하나씩을 sum에 더하여 출력
        for(int i = 0 ; i < N ; i++){
            sum = sum + Integer.parseInt(String.valueOf(s.charAt(i)));
        }
        System.out.println(sum);
    }
}
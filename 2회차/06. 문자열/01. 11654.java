import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 값을 입력받음
        int N = br.read();
        // 2. 입력한 문자열의 아스키코드값을 출력
        System.out.println(N);
    }
}
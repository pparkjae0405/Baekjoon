import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 문자열 a 입력
        String a = br.readLine();
        // 2. 입력받은 문자열 뒤에 ??!를 붙여 출력
        System.out.println(a + "??!");
    }
}
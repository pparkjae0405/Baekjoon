import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 불기연도 입력
        int a = Integer.parseInt(br.readLine());
        // 2. 서기연도로 바꾼 후 출력
        System.out.println(a-543);
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 문자열을 입력받고,
        String a = br.readLine();
        // 2. index값에 따라 출력
        for(int i = 97 ; i <= 122 ; i++){
            System.out.print(a.indexOf(i) + " ");
        }
    }
}
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 문자열을 입력받고, null이 아니라면 이를 출력한다.
        String str;
        while((str = br.readLine()) != null){
            System.out.println(str);
        }

        br.close();
    }
}
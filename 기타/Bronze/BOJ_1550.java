import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 16진수 수가 주어진다.
        String str = br.readLine();

        // 2. 10진수로 변경한 값을 출력한다.
        bw.write(Integer.parseInt(str, 16) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
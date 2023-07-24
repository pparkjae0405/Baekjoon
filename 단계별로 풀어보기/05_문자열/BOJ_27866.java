import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 단어 S와 정수 i가 주어진다.
        String S = br.readLine();
        int i = Integer.parseInt(br.readLine());

        // 2. S의 i번째 글자를 출력한다.
        bw.write(S.charAt(i-1) + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
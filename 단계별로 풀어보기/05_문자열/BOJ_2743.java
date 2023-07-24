import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 단어를 입력받는다.
        String word = br.readLine();

        // 2. 입력받은 단어의 길이를 출력한다.
        bw.write(word.length() + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 첫 줄에 자신이 맞은 문제의 수, 둘째 줄에 아이디를 출력한다.
        bw.write("215" + "\n");
        bw.write("pparkjae0405" + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
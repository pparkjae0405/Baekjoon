import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 첫째 줄에 “고려대학교”를 출력
        bw.write("고려대학교" + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
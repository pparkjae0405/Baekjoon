import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. R1과 S가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int R1 = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // 2. R2를 구해 출력한다.
        bw.write((S * 2) - R1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
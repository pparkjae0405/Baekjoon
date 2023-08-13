import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. A, B가 주어진다.
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());

        // 2. A+B를 출력한다.
        bw.write(A+B + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
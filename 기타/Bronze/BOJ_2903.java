import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N번 거친 후의 점 개수를 출력한다.
        bw.write((int)Math.pow(Math.pow(2, N) + 1, 2) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
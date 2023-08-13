import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 마이크로소프트 로고를 출력한다.
        bw.write("       _.-;;-._" + "\n");
        bw.write("'-..-'|   ||   |" + "\n");
        bw.write("'-..-'|_.-;;-._|" + "\n");
        bw.write("'-..-'|   ||   |" + "\n");
        bw.write("'-..-'|_.-''-._|" + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
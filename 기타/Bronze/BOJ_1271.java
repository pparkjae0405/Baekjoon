import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 가진 돈 n과 받으러 온 수 m이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger n = new BigInteger(st.nextToken());
        BigInteger m = new BigInteger(st.nextToken());

        // 2. 한 사람 당 돌아가는 돈의 수와 남는 돈을 출력한다.
        bw.write(n.divide(m) + "\n");
        bw.write(n.remainder(m) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
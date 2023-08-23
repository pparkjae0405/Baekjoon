import java.io.*;
import java.math.BigInteger;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 2진수가 주어진다.
        String str = br.readLine();

        // 2. 2진수 -> 10진수 -> 8진수로 바꿔 출력한다.
        BigInteger ten = new BigInteger(str, 2);
        String eight = ten.toString(8);
        bw.write(eight + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
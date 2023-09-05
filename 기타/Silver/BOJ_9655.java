import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N에 따라 이기는 사람을 출력한다.
        if(N % 2 == 0){
            bw.write("CY" + "\n");
        }else{
            bw.write("SK" + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
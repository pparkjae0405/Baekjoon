import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 입력받는 그대로 출력한다.
        String s;
        while((s = br.readLine()) != null){
            System.out.println(s);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 단어가 주어진다
        String str = br.readLine();

        // 2. 한 줄에 10글자씩 끊어서 출력한다.
        for(int i = 1 ; i <= str.length() ; i++){
            bw.write(str.charAt(i - 1));
            if(i % 10 == 0){
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
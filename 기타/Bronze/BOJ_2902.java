import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 긴 형태의 문자열이 주어진다.
        String str = br.readLine();

        // 2. 첫 번째 글자를 출력하고
        bw.write(str.charAt(0) + "");

        // 3. 2 ~ 문자열 길이까지 돌면서
        for(int i = 1 ; i < str.length() - 1 ; i++){
            // - 뒤의 글자를 출력한다.
            if(str.charAt(i) == '-'){
                bw.write(str.charAt(i + 1) + "");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
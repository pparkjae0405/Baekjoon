import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. a ~ z까지의 배열을 선언한다.
        int[] alphabet = new int[26];

        // 2. S가 주어지고, 알파벳을 분석해 출력한다.
        String S = br.readLine();
        for(int i = 0 ; i < S.length() ; i++){
            alphabet[S.charAt(i) - 97]++;
        }
        for(int i = 0 ; i < alphabet.length ; i++){
            bw.write(alphabet[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
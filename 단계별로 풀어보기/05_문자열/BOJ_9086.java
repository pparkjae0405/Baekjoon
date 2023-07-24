import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테이스 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 문자열을 입력받고
        for(int i = 0 ; i < T ; i++){
            // 해당 문자열의 첫 글자와 마지막 글자를 출력한다.
            String word = br.readLine();
            bw.write(word.charAt(0) + "" + word.charAt(word.length()-1) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
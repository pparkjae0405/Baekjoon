import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 문자열이 주어진다.
        String str = br.readLine();

        // 2. 문자열을 한글자씩 돌면서
        for (int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);

            // 소문자이고 13을 더한 값이 z를 넘지 않는다면
            if ('a' <= c && c <= 'z' - 13) {
                // 그 값으로 저장,
                c = (char) (c + 13);
            } else if ('z' - 13 <= c && c <= 'z') {
                // 넘는다면 13을 빼서 저장
                c = (char) (c - 13);

            } else if ('A' <= c && c <= 'Z' - 13) {
                // 대문자이고 13을 더한 값이 Z를 넘지않는다면
                // 그 값으로 저장,
                c = (char) (c + 13);

            } else if ('Z' - 13 <= c && c <= 'Z') {
                // 넘는다면 13을 빼서 저장한 뒤
                c = (char) (c - 13);
            }

            // 해당 값을 출력한다.
            bw.write(c + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
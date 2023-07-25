import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 문자열의 길이 L이 주어진다.
        int L = Integer.parseInt(br.readLine());

        // 2. 문자열을 받고 길이만큼 주어진 조건을 result에 추가한다.
        String word = br.readLine();
        long result = 0;
        long pow = 1;
        for(int i = 0 ; i < L ; i++){
            result += (word.charAt(i) - 96) * pow;
            pow = (pow * 31) % 1234567891;
        }

        // 3. 결과를 출력한다.
        bw.write(result % 1234567891 + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
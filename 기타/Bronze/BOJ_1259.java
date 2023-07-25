import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            // 1. 0이 나올때까지 수를 입력받는다.
            String palindrome = br.readLine();
            if(palindrome.equals("0")) break;

            // 2. 입력받은 수를 비교하여 팰린드롬수인지 확인한다.
            int a = 0;
            int b = palindrome.length() - 1;
            String result = "yes";
            while(a < b){
                if(palindrome.charAt(a) != palindrome.charAt(b)) result = "no";
                a++;
                b--;
            }

            // 3. 결과를 출력한다.
            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
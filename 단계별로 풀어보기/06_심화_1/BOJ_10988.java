import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 단어가 주어진다.
        String word = br.readLine();

        // 2. 팰린드롬인지 확인할 result, 비교할 두 글자 a, b를 선언하고
        int result = 1;
        int a = 0;
        int b = word.length()-1;

        // 3. 앞뒤 글자가 같은지 확인하여 결과를 출력한다.
        while(a < b){
            if(word.charAt(a) != word.charAt(b)){
                result = 0;
                break;
            }
            a++;
            b--;
        }

        bw.write(result + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
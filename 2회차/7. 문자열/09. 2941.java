import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 문자열 입력, 알파벳 개수 count 선언
        String a = br.readLine();
        int count = 0;
        // 2. 입력된 문자를 비교하여
        for(int i=0;i<a.length();i++) {
            if (i < a.length()-1 && a.charAt(i) == 'c') {
                if (a.charAt(i + 1) == '=' || a.charAt(i + 1) == '-')
                    i++;
            }
            else if (i < a.length()-1 && a.charAt(i) == 'd') {
                if (a.charAt(i + 1) == '-')
                    i++;
                else if (i < a.length()-2 && a.charAt(i + 1) == 'z')
                    if(a.charAt(i + 2) == '=')
                        i += 2;
            }
            else if (i < a.length()-1 && (a.charAt(i)== 'l' || a.charAt(i) == 'n')) {
                if (a.charAt(i + 1) == 'j')
                    i++;
            }
            else if (i < a.length()-1 && (a.charAt(i) == 's' || a.charAt(i) == 'z')) {
                if (a.charAt(i + 1) == '=')
                    i++;
            }
            count++;
        }
        // 3. 크로아티아 알파벳 개수를 인식하여 출력
        System.out.println(count);
    }
}
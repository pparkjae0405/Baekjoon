import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 입력
        String a = br.readLine();
        int count = 0; // 카운트 정수
        for(int i=0;i<a.length();i++) { // a 문자열 크기만큼 반복
            // i가 a크기-1보다 작고(인덱스 초과때문) c이고
            if (i < a.length()-1 && a.charAt(i) == 'c') {
                // i+1번째 문자가 =, -이면 i를 한 칸 건너뜀
                if (a.charAt(i + 1) == '=' || a.charAt(i + 1) == '-')
                    i++;
            }
            // i가 a크기-1보다 작고(인덱스 초과때문) d이고
            else if (i < a.length()-1 && a.charAt(i) == 'd') {
                // i+1번째 문자가 -이면 i를 한 칸 건너뛰고,
                if (a.charAt(i + 1) == '-')
                    i++;
                // i가 a크기-2보다 작고 i+1번째 문자가 z이면
                else if (i < a.length()-2 && a.charAt(i + 1) == 'z')
                    // i+2번째 문자가 =이면 i를 두 칸 건너뜀.
                    if(a.charAt(i + 2) == '=')
                        i += 2;
            }
            // i가 a크기-1보다 작고(인덱스 초과때문) l이나 n이고
            else if (i < a.length()-1 && (a.charAt(i)== 'l' || a.charAt(i) == 'n')) {
                // i+1번째 문자가 j이면 i를 한 칸 건너뜀
                if (a.charAt(i + 1) == 'j')
                    i++;
            }
            // i가 a크기-1보다 작고(인덱스 초과때문) s이나 z이고
            else if (i < a.length()-1 && (a.charAt(i) == 's' || a.charAt(i) == 'z')) {
                // i+1번째 문자가 =이면 i를 한 칸 건너뜀
                if (a.charAt(i + 1) == '=')
                    i++;
            }
            count++;
        }
        System.out.println(count);
    }
}
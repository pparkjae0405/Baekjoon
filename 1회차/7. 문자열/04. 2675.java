import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 맨처음 케이스 반복 횟수 a 지정
        int a = Integer.parseInt(br.readLine());
        // a만큼 반복하여
        // 그 다음 문자열을 " "로 구분하여 비교하여 반복출력b, 문자열c 지정
        for(int i=0;i<a;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int b = Integer.parseInt(st.nextToken());
            String c = st.nextToken();
            // 입력받은 문자열 크기만큼 p 문자열 배열 선언
            String[] p = new String[c.length()];
            int m = 0;
            // 입력받은 c 문자열 하나하나를 b만큼 반복하여 출력
            for (int j = 0; j < c.length(); j++) {
                for (int k = 0; k < b; k++) {
                    p[m] = String.valueOf(c.charAt(m));
                    System.out.print(p[m]);
                    //System.out.print(c.charAt(m));
                }
                m++;
            }
            System.out.println();
        }
    }
}

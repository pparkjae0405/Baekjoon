import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열을 입력받아서 띄어쓰기로 구분
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 첫 번째 숫자
        int a = Integer.parseInt(st.nextToken());
        // 두 번째 숫자
        int b = Integer.parseInt(st.nextToken());
        // a,b를 반대로
        int c = ((a%10)*100) + ((a/10)%10*10) + (a/100);
        int d = ((b%10)*100) + ((b/10)%10*10) + (b/100);
        //c,d 비교 및 출력
        if( c > d)
            System.out.println(c);
        else
            System.out.println(d);
    }
}
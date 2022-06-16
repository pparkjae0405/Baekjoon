import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 숫자 2개를 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();
        // 2. 입력받은 숫자를 반대로 돌려 비교한 뒤 큰 수를 출력
        int a1 = 0, b1 = 0;
        int j = 100;
        for(int i = 2 ; i >= 0 ; i--){
            a1 += Integer.parseInt(String.valueOf(a.charAt(i)))*j;
            b1 += Integer.parseInt(String.valueOf(b.charAt(i)))*j;
            j /= 10;
        }
        if(a1 > b1) {
            System.out.println(a1);
        }else{
            System.out.println(b1);
        }
    }
}
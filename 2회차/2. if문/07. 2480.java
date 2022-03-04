import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 3개의 눈 입력, 상금 sum, 가장 큰 눈 max 선언
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int sum = 0, max = a;
        // 2. 위 규칙에 따른 if문을 통해 상금 계산
        // 먼저 3개 중 가장 큰 값 계산
        if(b > max) max = b;
        if(c > max) max = c;

        // 같은 눈의 개수에 따른 상금값 계산
        if(a == b && b == c){
            sum = 10000 + (a*1000);
        }else if(a == b || a == c) {
            sum = 1000 + (a * 100);
        }else if(b == c) {
            sum = 1000 + (b * 100);
        }else{
            sum = max * 100;
        }
        // 3. 상금 출력
        System.out.println(sum);
    }
}
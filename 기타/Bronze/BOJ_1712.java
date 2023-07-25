import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 3개의 숫자 고정비용 a, 가변비용 b, 가격 c를 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        // 2. 수익과 지출을 비교하여 이익이 발생하는지 확인,
        // 발생한다면 판매량 출력, 발생하지 않는다면 -1 출력
        if(b>=c){
            System.out.println("-1");
        }else {
            System.out.println(a/(c-b)+1);
        }
    }
}
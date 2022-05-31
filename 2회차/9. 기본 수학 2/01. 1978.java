import java.io.*;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 테스트 케이스 N이 주어지고 공백을 기준으로 입력받음
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 2. 소수 개수 count 선언
        int count = 0;
        // 3. 값이 소수인지 판별하고 count값 증가
        for(int i = 0 ; i < N ; i++){
            // 소수 판별 isPrime, 입력값 num 선언
            boolean isPrime = true;
            int num = Integer.parseInt(st.nextToken());

            // num가 1이면 소수가 아니므로 다음 반복문으로
            if(num == 1) {
                continue;
            }
            for(int j = 2 ; j <= Math.sqrt(num) ; j++) {
                // 그 외 num이 j로 나누어 떨어지면 소수가 아니므로 break
                if (num%j == 0){
                    isPrime = false;
                    break;
                }
            }
            // num가 소수라면 count 증가
            if(isPrime == true) count++;
        }
        // 4. count값 출력
        System.out.println(count);
    }
}
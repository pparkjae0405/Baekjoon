import java.io.*;

public class Main {
    private static int hansu(int n) {
        // 2. count 선언, N이 100 미만이면 N의 크기만큼 출력
        int count = 0;
        if(n < 100){
            return n;
        }
        // 3. 이외에는 3자리수이므로 count값을 99 더하고 시작,
        // N이 1000이면 N을 999로 변환
        else{
          count = 99;
          if(n == 1000){
              n = 999;
          }
        }
        for(int i = 100 ; i <= n ; i++){
            // 4. N의 100의자리, 10의자리, 1의자리 수를 구함
            int h, t, o;
            h = i / 100;
            t = (i / 10) % 10;
            o = i % 10;
            // 5. 등차수열을 이룰 시 count값 증가
            if((h-t) == (t-o)) count++;
        }
        // 6. 한수의 개수 출력
        return count;
    }
    public static void main(String[] args) throws IOException {
        // 1. 자연수 N을 입력받음, 함수 호출
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(hansu(N));
    }
}
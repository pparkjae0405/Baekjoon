import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            // 1. 자연수 N, 소수 개수 count이 주어진다.
            int N = Integer.parseInt(br.readLine());
            int count = 0;
            // 2. N에 0이 들어올 때까지 반복,
            if(N == 0) break;
            // N이 1이면 1 전처리
            if (N == 1) {
                bw.write(1 + "\n");
            }
            else {
                // 3. N+1 ~ 2N 사이의 소수를 구하고, count를 증가시키는데
                for (int i = N+1; i <= 2*N; i++) {
                    // 소수를 판별할 boolean 선언하고
                    boolean sosu = true;
                    // N부터 2N까지 돌면서 2~2N의 제곱근 사이로 나눠지는 게 있다면
                    // 소수가 아니므로 sosu를 false로 바꿔주고 for문 탈출
                    for (int j = 2; j <= Math.sqrt(2*N); j++) {
                        if (i % j == 0) {
                            sosu = false;
                            break;
                        }
                    }
                    // for문을 돌고 나온 결과가 true이면 소수이므로 count 증가
                    if (sosu == true) count++;
                }
                // count 값 출력
                bw.write(count + "\n");
            }
        }
        // 4. 소수의 개수 출력
        bw.flush();
    }
}
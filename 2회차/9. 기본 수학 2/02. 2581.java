import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. M과 N을 입력받는다
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        // 2. 동적배열 A, 소수의 합 sum 선언
        ArrayList<Integer> A = new ArrayList<Integer>();
        int sum = 0;
        // 3. M~N까지 돌아가면서 소수를 찾는데
        for(int i = M ; i <= N; i++){
            // 소수 판별 isPrime을 선언하고
            boolean isPrime = true;
            // i가 1이면 소수가 아니므로 다음 반복문으로,
            if(i == 1) {
                continue;
            }
            for(int j = 2 ; j <= Math.sqrt(i) ; j++) {
                // 그 외 i가 j로 나누어 떨어지면 소수가 아니므로 break
                if (i%j == 0){
                    isPrime = false;
                    break;
                }
            }
            // 4. num가 소수라면 A 배열에 추가하고 sum에 i 덧셈한 뒤
            if(isPrime == true) {
                A.add(i);
                sum += i;
            }
        }
        // 5. for문을 빠져나오면 소수의 합과 최솟값을 출력한다.
        if(sum == 0){
            bw.write("-1" + "\n");
        }else {
            bw.write(sum + "\n");
            bw.write(A.get(0) + "\n");
        }
        bw.flush();
    }
}
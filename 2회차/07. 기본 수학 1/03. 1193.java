import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 숫자 N, 범위를 위한 a, 범위 중 몇 번째 cnt가 주어짐
        int N = Integer.parseInt(br.readLine());
        int a = 0;
        int cnt = 0;
        if(N == 1){
            System.out.println("1/1");
        }else {
            // 2. 어느 범위 안에 들어가는지 체크하고,
            while(cnt < N){
                a++;
                cnt = a * (a+1) / 2;
            }
            // a가 짝수라인이라면
            if(a % 2 == 0){
                System.out.println((a-(cnt-N)) + "/" + (1+(cnt-N)));
            }else {
                // a가 홀수라인이라면
                System.out.println((1+(cnt-N)) + "/" + (a-(cnt-N)));
            }
        }
    }
}
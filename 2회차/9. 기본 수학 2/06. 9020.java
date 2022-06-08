import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());
        // 2. T만큼 반복하여 숫자를 입력받는다.
        for(int i = 0 ; i < T ; i++){
            // 3. 주어진 숫자 n을 소수의 합으로 표현하는데
            int n = Integer.parseInt(br.readLine());
            // 우선 주어진 짝수를 반으로 나눈 값을 a, b에 저장하고
            int a = n/2;
            int b = n/2;
            // 하나는 1씩 줄여가며 소수 판단, 하나는 1씩 늘려가며 소수 판단
            while(true){
                // a, b소수 판별값 sosua, sosub를 선언
                boolean sosua = true;
                boolean sosub = true;
                // a 소수 판별
                for(int j = 2 ; j <= Math.sqrt(a) ; j++){
                    if(a%j == 0) {
                        sosua = false;
                        break;
                    }
                }
                // b 소수 판별
                for(int j = 2 ; j <= Math.sqrt(b) ; j++){
                    if(b%j == 0) {
                        sosub = false;
                        break;
                    }
                }
                // 두 개의 소수가 나왔을 때 출력
                if(sosua == true && sosub == true){
                    bw.write(a + " " + b + "\n");
                    break;
                }
                // a는 -1, b는 +1
                a--;
                b++;
            }
        }
        // 4. 저장한 값 출력
        bw.flush();
    }
}
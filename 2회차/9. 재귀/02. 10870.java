import java.io.*;
public class Main {
    // 2. 재귀함수 팩토리얼을 구현한다
    public static int fibo(int n){
        // n이 첫 번째 혹은 두 번째일 때 결과 리턴
        if(n == 0) return 0;
        if(n == 1) return 1;
        // 그 외에는 (n-1) + (n-2) ... 반복
        return fibo(n-1) + fibo(n-2);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 정수 n이 주어진다
        int N = Integer.parseInt(br.readLine());
        // 3. 함수를 호출하여 n번째 피보나치 수를 출력한다.
        bw.write(fibo(N) + "\n");
        bw.flush();
    }
}
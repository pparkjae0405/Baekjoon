import java.io.*;
public class Main {
    // 2. 재귀함수 팩토리얼을 구현한다
    public static int factorial(int a){
        // a가 1보다 작거나 같으면 결과 리턴
        if(a == 0) return 1;
        if(a <= 1) return a;
        // 그 외에는 a * a-1 * a-2 ... 반복
        else return factorial(a-1)*a;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 정수 N이 주어진다
        int N = Integer.parseInt(br.readLine());
        // 3. 함수를 호출하여 N!의 결과를 출력한다.
        bw.write(factorial(N) + "\n");
        bw.flush();
    }
}
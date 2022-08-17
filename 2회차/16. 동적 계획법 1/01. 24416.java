import java.io.*;

public class Main {
     // 1. n에 따른 배열 a, 재귀횟수 recCount, 동적횟수 dCount를 선언한다.
     public static int recCount;
     public static int dCount;
     public static int[] a;

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          // 2. n이 주어지고 a, recCount, dCount를 할당한다.
          int n = Integer.parseInt(br.readLine());
          a = new int[n];
          recCount = 0;
          dCount = 0;

          // 3. n에 따른 재귀호출과 동적 프로그래밍의 실행 횟수를 출력한다.
          fib(n);
          fibonacci(n);
          bw.write(recCount + " ");
          bw.write(dCount + "\n");
          bw.flush();
          bw.close();
          br.close();
     }

     public static int fib(int n){
          if(n == 1 || n == 2) {
               recCount++;
               return 1;
          }
          return (fib(n-1) + fib(n-2));
     }

     public static int fibonacci(int n){
          a[0] = 1;
          a[1] = 1;

          for(int i = 2 ; i < n ; i++){
               dCount++;
               a[i] = a[i-2] + a[i-1];
          }
          return a[n-1];
     }
}
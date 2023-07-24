import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. N과 K가 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int K = Integer.parseInt(st.nextToken());
          // 2. N! / K!(N-K)!를 계산하기 위한 result를 선언하고
          int result = factorial(N) / (factorial(K)*factorial(N-K));
          // 3. 출력한다.
          bw.write(result + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
     // factorial 함수를 구현하여
     public static int factorial(int n) {
          if (n == 0){
               return 1;
          }else {
               return n * factorial(n - 1);
          }
     }
}
import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 테스트 케이스 개수 T가 주어진다.
          int T = Integer.parseInt(br.readLine());
          // 2. 두 개의 자연수 A, B가 주어진다
          for(int i = 0 ; i < T ; i++) {
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               int A = Integer.parseInt(st.nextToken());
               int B = Integer.parseInt(st.nextToken());
               // 3. 두 수의 최소공배수 a를 출력한다.
               int a = (A*B)/cal(A, B);
               bw.write(a + "\n");
          }
          br.close();
          bw.flush();
          bw.close();
     }
     public static int cal(int a, int b){
          if(a % b == 0){
               return b;
          }
          return cal(b, a%b);
     }
}
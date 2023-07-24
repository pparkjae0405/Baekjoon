import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 두 개의 자연수 N, M이 주어진다
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());
          // 2. 두 수의 최대공약수 a와
          int a = cal(N, M);
          bw.write(a + "\n");
          // 3. 두 수의 최소공배수 b를 출력한다.
          int b = (N*M)/a;
          bw.write(b + "\n");
          br.close();
          bw.flush();
          bw.close();
     }
     public static int cal(int n, int m){
          if(n % m == 0){
               return m;
          }
          return cal(m, n%m);
     }
}
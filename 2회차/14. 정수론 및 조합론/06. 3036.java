import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 링의 개수 N이 주어진다.
          int N = Integer.parseInt(br.readLine());

          // 2. 링의 반지름이 주어지고 배열 a에 저장된다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int[] a = new int[N];
          for(int i = 0 ; i < N ; i++){
               a[i] = Integer.parseInt(st.nextToken());
          }

          // 3. 첫 번째 링을 제외한 나머지 링에 대해
          for(int i = 1 ; i < N; i++){
               // a[0]과 a[i]번째의 최대공약수를 찾고
               int b = cal(a[0], a[i]);
               // a[0]/최대공약수 / a[i]/최대공약수의 기약분수 형태(A/B)로 출력한다.
               bw.write(a[0]/b + "/" + a[i]/b + "\n");
          }
          bw.flush();
          bw.close();
          br.close();
     }
     public static int cal(int a, int b){
          if(a % b == 0){
               return b;
          }
          return cal(b, a%b);
     }
}
import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 종이에 적은 수의 개수 N이 주어진다.
          int N = Integer.parseInt(br.readLine());

          // 2. 배열 a를 선언하고 종이에 적은 수가 N개 주어진다.
          int[] a = new int[N];
          for (int i = 0; i < N; i++) {
               a[i] = Integer.parseInt(br.readLine());
          }

          // 3. 배열 a를 정렬하고
          Arrays.sort(a);

          // 4. a[1]과 a[0]의 차이인 b를 선언한 뒤
          int b = a[1] - a[0];
          // cal함수를 선언하여 2~N까지 비교하여
          for(int i = 2 ; i < N ; i++){
               b = cal(b, a[i]-a[i-1]);
          }

          // 5. 최대공약수의 약수들을 찾아
          for(int i = 2 ; i <= b ; i++){
               // 0이 된다면 출력한다.
               if(b % i == 0){
                    bw.write(i + " ");
               }
          }
          bw.flush();
          bw.close();
          br.close();
     }
     // 최대공약수를 찾은 뒤
     public static int cal(int a, int b){
          while(b != 0){
               int c = a%b;
               a = b;
               b = c;
          }
          return a;
     }
}
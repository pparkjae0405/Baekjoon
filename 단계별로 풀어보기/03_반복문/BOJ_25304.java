import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 총 금액 X가 주어진다
          int X = Integer.parseInt(br.readLine());

          // 2. 구매한 물건 종류의 수 N이 주어진다
          int N = Integer.parseInt(br.readLine());

          // 3. 각 물건의 가격 a와 개수 b가 N만큼 주어지고,
          int sum = 0;
          for(int i = 0 ; i < N ; i++){
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());
               // 그 가격만큼 sum에 추가된다
               sum += (a*b);
          }

          // 4. 계산금액 X와 영수증의 총 금액이 같은지 확인한다.
          if(X == sum){
               bw.write("Yes");
          }else{
               bw.write("No");
          }
          bw.flush();
          bw.close();
          br.close();
     }
}
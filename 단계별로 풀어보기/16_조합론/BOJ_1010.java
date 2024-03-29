import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 테스트 케이스 개수 T가 주어진다.
          int T = Integer.parseInt(br.readLine());
          // 2. 서쪽과 동쪽에 있는 N과 M의 개수가 T만큼 주어진다.
          for(int i = 0 ; i < T ; i++){
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               long N = Long.parseLong(st.nextToken());
               long M = Long.parseLong(st.nextToken());
               long result = 1;

               // 3. m개 중 n개 선택하는 mCn에 해당하는 경우의 수,
               // nCr = 5C3 = 5*(5-1)*(5-2) / 1*(1+1)*(1+2) 이므로
               // result에 M-j를 곱하고 j+1를 나누는 것을 N만큼 하여
               for(int j = 0 ; j < N ; j++){
                    result *= (M-j);
                    result /= (j+1);
               }

               // 4. 결과를 출력한다.
               bw.write(result + "\n");
          }
          bw.flush();
          bw.close();
          br.close();
     }
}
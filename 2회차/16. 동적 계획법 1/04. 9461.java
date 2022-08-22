import java.io.*;

public class Main {
     // 1. 동적 계획법을 위한 배열 a가 주어진다.
     public static long[] count = new long[101];

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          // 2. 테스트 케이스 T가 주어진다.
          int T = Integer.parseInt(br.readLine());

          // 3. count 배열을 초기화하고, 0~3까지의 값을 저장한 뒤
          for(int i = 0 ; i < 101 ; i++){
               count[i] = -1;
          }
          count[0] = 0;
          count[1] = 1;
          count[2] = 1;
          count[3] = 1;

          // 4. 각 테스트 케이스마다의 P(N)을 출력하는데
          for(int i = 0 ; i < T ; i++) {
               int N = Integer.parseInt(br.readLine());
               bw.write(cal(N) + "\n");
          }
          bw.flush();
          bw.close();
          br.close();
     }

     public static long cal(int n){
          // 5. 배열 값이 -1, 즉 탐색하지 않았다면 재귀를 호출하고
          if(count[n] == -1){
               count[n] = cal(n-2) + cal(n-3);
          }
          // count[n]을 리턴하여 값을 출력한다.
          return count[n];
     }
}
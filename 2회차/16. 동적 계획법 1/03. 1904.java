import java.io.*;

public class Main {
     // 1. 동적 계획법을 위한 count 배열이 주어진다.
     public static int[] count = new int[1000001];

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          // 2. 자연수 N이 주어진다.
          int N = Integer.parseInt(br.readLine());

          // 3. 모든 이진 수열의 개수를 15746으로 나눈 나머지를 출력하는데
          bw.write(cal(N) + "\n");
          bw.flush();
          bw.close();
          br.close();
     }

     public static int cal(int n){
          // 4. 배열 값이 0이 아니라면 그 값을 출력하고,
          if(count[n] != 0){
               return count[n];
          }

          // 1, 2이면 1, 2 반환
          if(n == 1){
               return 1;
          } else if(n == 2){
               return 2;
          } else if(n > 2){
               // 2보다 크다면 재귀호출로 값을 가져와 저장한 뒤 반환한다.
               count[n] = (cal(n-1) + cal(n-2))%15746;
               return count[n];
          }else {
               return n;
          }
     }
}
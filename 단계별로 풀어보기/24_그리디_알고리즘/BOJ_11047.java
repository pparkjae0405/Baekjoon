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

          // 2. 동전 종류가 N개만큼 주어진다.
          int[] a = new int[N];
          for(int i = 0 ; i < N ; i++){
               a[i] = Integer.parseInt(br.readLine());
          }

          // 3. K원을 만드는 데 필요한 동전 개수의 최솟값 찾기 위해
          int count = 0;
          // 제일 큰 종류의 돈부터 빼도록 a[N-1]부터 a[0]까지 내려가면서 찾는데
          for(int i = N-1 ; i >= 0 ; i--) {
               // a[i]가 K보다 작거나 같을 경우
               if (a[i] <= K) {
                    // a[i]로 뺄 수 있는 개수를 count에 증가해주고
                    count += (K / a[i]);
                    // K를 a[i]로 나눈 나머지로 저장하여
                    K = K % a[i];
               }
          }

          // 4. count 값을 출력한다.
          bw.write(count + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
}
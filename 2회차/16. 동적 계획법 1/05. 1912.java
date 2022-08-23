import java.io.*;
import java.util.StringTokenizer;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          // 1. 정수 n이 주어지고 그 크기만큼 a와 b를 선언한 뒤
          int n = Integer.parseInt(br.readLine());
          // 배열 a와 비교배열 b, 최댓값 max가 주어진다.
          int[] a = new int[n];
          int[] b = new int[n];
          int max;

          // 2. n개의 정수 수열을 a에 저장하고,
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < n ; i++){
               a[i] = Integer.parseInt(st.nextToken());
          }

          // 3. 배열 b와 max값을 a[0]값으로 초기화한 뒤
          b[0] = a[0];
          max = a[0];

          // 4. 수열을 탐색하여
          for(int i = 1 ; i < n ; i++){
               // b[i-1] + a[i]값과 a[i]값을 비교하여 더 큰값을 b[i]에 저장하고,
               b[i] = Math.max(b[i-1]+a[i], a[i]);
               // 그 값을 max에 저장하여
               max = Math.max(max, b[i]);
          }

          // 5. max값을 출력한다.
          bw.write(max + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
}
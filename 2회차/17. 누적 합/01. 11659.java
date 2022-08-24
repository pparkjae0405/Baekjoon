import java.io.*;
import java.util.StringTokenizer;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 수의 개수 N과 합을 구해야하는 횟수 M이 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());

          // 2. N+1개의 크기를 가진 배열 a를 선언하고,
          int[] a = new int[N+1];
          // a[0]값을 0으로 초기화하고
          a[0] = 0;
          // 누적합을 a[i]에 저장한다.
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 1 ; i <= N ; i++){
               a[i] = a[i-1] + Integer.parseInt(st.nextToken());
          }

          // 3. 합을 구해야하는 구간 x와 y가 M만큼 주어지고
          for(int i = 0 ; i < M ; i++){
               st = new StringTokenizer(br.readLine(), " ");
               int x = Integer.parseInt(st.nextToken());
               int y = Integer.parseInt(st.nextToken());

               // 구간 사이의 값을 출력한다.
               bw.write(a[y]-a[x-1] + "\n");
          }
          bw.flush();
          bw.close();
          br.close();
     }
}
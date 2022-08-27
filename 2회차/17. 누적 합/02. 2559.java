import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 입력 수열의 크기 N과 알아볼 구간의 크기 K가 주어지고,
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int K = Integer.parseInt(st.nextToken());

          // 2. 수열의 크기만큼의 배열 a를 선언하고
          int[] a = new int[N];

          // 3. N만큼 수열이 주어져 a에 저장한 뒤
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < N ; i++){
               a[i] = Integer.parseInt(st.nextToken());
          }

          // 4. integer값의 가장 작은 값 max를 선언하고
          int max = Integer.MIN_VALUE;
          for(int i = 0 ; i <= N-K ; i++){
               int sum = 0;
               for(int j = i ; j < i+K ; j++){
                    sum += a[j];
               }
               // 구간 별 합 중 최댓값을 max에 저장하여
               if(sum > max) max = sum;
          }

          // 출력한다.
          bw.write(max + "\n");

          bw.flush();
          bw.close();
          br.close();
     }
}
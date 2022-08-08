import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 응시자 수 N과 상을 받는 사람의 수 k가 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int k = Integer.parseInt(st.nextToken());

          // 2. 각 학생의 점수를 담은 배열x를 선언하고,
          int[] x = new int[N];
          // N만큼 주어져 저장된다.
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < N ; i++){
               x[i] = Integer.parseInt(st.nextToken());
          }

          // 3. x배열을 정렬하고,
          Arrays.sort(x);

          // 4. x[N-k]번째 점수를 출력한다.
          bw.write(x[N-k] + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
}
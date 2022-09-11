import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. N과 K, 큐 a가 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int K = Integer.parseInt(st.nextToken());
          Queue<Integer> a = new LinkedList<Integer>();

          // 2. 1~N만큼의 사람을 큐에 추가한 뒤
          for(int i = 1 ; i <= N ; i++){
               a.add(i);
          }

          bw.write("<");
          // 3. N번 반복하여
          for(int i = 0 ; i < N ; i++) {
               // 1~K-1번째 수를 맨 뒤로 옮기고
               for (int j = 1; j <= K - 1; j++) {
                    a.add(a.poll());
               }

               // K를 제거하여 출력한다.
               if(i == N-1){
                    bw.write(a.poll() + ">");
               }else{
                    bw.write(a.poll() + ", ");
               }
          }

          bw.flush();
          bw.close();
          br.close();
     }
}
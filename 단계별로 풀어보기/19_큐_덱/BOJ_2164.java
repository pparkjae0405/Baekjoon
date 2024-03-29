import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 정수 N이 주어지고, 큐를 선언한다.
          int N = Integer.parseInt(br.readLine());
          Queue<Integer> a = new LinkedList<Integer>();

          // 2. 1~N만큼의 카드를 큐에 삽입한 뒤
         for(int i = 1 ; i <= N ; i++){
               a.add(i);
          }

          // 3. N-1만큼 반복하여
          for(int i = 0 ; i < N-1 ; i++){
               // 맨 위 카드를 버리고
               a.remove();
               // 제일 위에 있는 카드를 맨 아래로 옮긴 뒤
               a.add(a.poll());
          }

          // 4. 남아있는 카드를 출력한다.
          bw.write(a.peek()+"\n");

          bw.flush();
          bw.close();
          br.close();
     }
}
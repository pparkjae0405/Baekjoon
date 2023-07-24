import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 정수 K가 주어지고, 스택 a를 선언한다.
          int K = Integer.parseInt(br.readLine());
          Stack<Integer> a = new Stack<>();

          // 2. K만큼 정수가 주어지는데
          for(int i = 0 ; i < K ; i++){
               // 정수가 0일 경우 가장 최근에 쓴 수를 지우고,
               int N = Integer.parseInt(br.readLine());
               if(N == 0){
                    a.pop();
               }else{
                    // 아닐 경우 해당 수를 추가한다.
                    a.push(N);
               }
          }

          // 3. a의 크기만큼 pop하여 sum에 더하여 출력한다.
          int sum = 0;
          for(int i : a){
               sum += i;
          }
          bw.write(sum + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
}
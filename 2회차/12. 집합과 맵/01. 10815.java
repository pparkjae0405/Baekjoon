import java.io.*;
import java.util.*;
public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 가지고 있는 카드 수 N이 주어진다.
          int N = Integer.parseInt(br.readLine());
          // 2. N에 해당하는 card 집합 cardN을 선언한다.
          Set<Integer> cardN = new HashSet<Integer>();

          // 3. 카드에 적혀있는 수가 N만큼 주어지고, cardN에 저장한다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < N ; i++){
               cardN.add(Integer.parseInt(st.nextToken()));
          }

          // 4. 확인할 횟수 M이 주어진다.
          int M = Integer.parseInt(br.readLine());
          // 5. M에 해당하는 card 배열 cardM을 선언한다.
          int[] cardM = new int[M];

          // 6. 확인할 카드에 적혀있는 수가 M만큼 주어지고, cardN에 대조하는데
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < M ; i++){
               int num = Integer.parseInt(st.nextToken());
               // num이 cardN 집합에 포함되는지 판단하여 출력한다.
               if(cardN.contains(num)){
                    bw.write(1 + " ");
               }else{
                    bw.write(0 + " ");
               }
          }
          br.close();
          bw.flush();
          bw.close();
     }
}
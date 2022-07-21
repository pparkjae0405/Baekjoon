import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 숫자 카드의 개수 N, 숫자 별 카드 개수 cardN를 선언한다.
          int N = Integer.parseInt(br.readLine());
          HashMap<Integer, Integer> cardN = new HashMap<Integer, Integer>();

          // 2. N개만큼의 정수가 주어지는데
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < N ; i++){
               // 해당하는 숫자 카드의 개수를 세기 위해
               int key = Integer.parseInt(st.nextToken());
               int count = 1;
               // cardN에 key값에 해당하는 값이 있다면
               // 숫자 카드 개수를 1개 늘린 후 저장하고,
               if(cardN.containsKey(key)){
                    count = cardN.get(key) + 1;
               }
               // 없다면 1개로 저장하고
               cardN.put(key, count);
          }

          // 3. 정수의 개수 M과 M만큼의 정수가 주어지는데
          int M = Integer.parseInt(br.readLine());
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < M ; i++){
               int a = Integer.parseInt(st.nextToken());
               // 4. 가져온 값이 null이라면 0을 출력하고,
               if(cardN.get(a) == null){
                    bw.write(0 + " ");
               }else {
                    // 아니라면 해당 값을 출력한다.
                    bw.write(cardN.get(a) + " ");
               }
          }
          br.close();
          bw.flush();
          bw.close();
     }
}
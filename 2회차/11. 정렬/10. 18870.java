import java.io.*;
import java.util.*;
public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 좌표 개수 N을 입력받는다.
          int N = Integer.parseInt(br.readLine());

          // 2. 입력받을 a배열과 정렬할 b배열, 해시맵 c를 선언하고,
          int[] a = new int[N];
          int[] b = new int[N];
          HashMap<Integer, Integer> c = new HashMap<Integer, Integer>();

          // 3. 좌표를 입력받아 배열에 저장하고
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < N ; i++){
               a[i] = b[i] = Integer.parseInt(st.nextToken());
          }

          // 4. b 배열을 정렬하고
          Arrays.sort(b);

          // 5. HashMap에 하나씩 추가하며 순위를 매기는데
          int count = 0;
          for(int i : b){
               // 중복되지 않은 값일 때 map에 순위를 넣고
               if(!c.containsKey(i)){
                    c.put(i, count);
                    count++;
               }
          }

          // 6. 원본 배열을 순회하며 HashMap에 있는 value값을 가져와 출력한다.
          for(int i : a){
               int j = c.get(i);
               bw.write(j + " ");
          }
          br.close();
          bw.flush();
          bw.close();
     }
}
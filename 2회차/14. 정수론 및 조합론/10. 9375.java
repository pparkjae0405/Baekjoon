import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 테스트 케이스 개수 T가 주어진다.
          int T = Integer.parseInt(br.readLine());

          for(int i = 0 ; i < T ; i++){
               // 2. 종류/개수로 이루어진 해시맵 clothes를 선언한다.
               HashMap<String, Integer> clothes = new HashMap<String, Integer>();

               // 3. 각 테스트케이스 마다 가진 의상의 수 n이 주어지고,
               int n = Integer.parseInt(br.readLine());
               for(int j = 0 ; j < n ; j++){
                    // 공백으로 주어진 옷의 이름과 타입 a, b가 n만큼 주어지는데
                    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                    String name = st.nextToken();
                    String type = st.nextToken();
                    // type값이 clothes에 있을 경우 개수+1,
                    if(clothes.containsKey(type)){
                         clothes.put(type, clothes.get(type)+1);
                    }else{
                         // 없을 경우 type값을 clothes에 저장한다.
                         clothes.put(type, 1);
                    }
               }

               // 4. type 중 개수 n개를 선택하는 경우의 수는
               // 각각의 type에 대해 nC1 이므로
               int result = 1;
               for(int k : clothes.values()){
                    // 안입는 경우를 대비해 type마다 +1을 해서 계산한 뒤
                    result *= (k+1);
               }

               // 5. 알몸이 되는 경우를 제외하기 위해 1을 빼서 결과를 출력한다.
               bw.write(result-1 + "\n");
          }
          bw.flush();
          bw.close();
          br.close();
     }
}
import java.io.*;
import java.util.*;
public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 좌표 개수 N을 입력받는다.
          int N = Integer.parseInt(br.readLine());
          // 2. N개만큼의 2차원배열 a를 선언하고
          int[][] a = new int[N][2];
          // 3. N만큼 반복하여 좌표를 입력받아
          for(int i = 0 ; i < N ; i++){
               // a배열에 저장한 뒤
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               a[i][1] = Integer.parseInt(st.nextToken());
               a[i][0] = Integer.parseInt(st.nextToken());
          }
          // 4. a배열을 정렬하고
          Arrays.sort(a, (x, y) -> {
               if(x[0] == y[0]){
                    return x[1] - y[1];
               }else{
                    return x[0] - y[0];
               }
          });
          // 5. 출력한다.
          for(int i = 0 ; i < N ; i++){
               bw.write(a[i][1] + " " + a[i][0] + "\n");
          }
          br.close();
          bw.flush();
          bw.close();
     }
}
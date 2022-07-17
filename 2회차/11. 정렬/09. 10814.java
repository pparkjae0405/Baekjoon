import java.io.*;
import java.util.*;
public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 회원 수 N을 입력받는다.
          int N = Integer.parseInt(br.readLine());
          // 2. N만큼의 2차원 배열 a를 선언한다.
          String[][] a = new String[N][2];
          // 3. N만큼 회원나이와 이름을 입력받는다.
          for(int i = 0 ; i < N ; i++){
               // 공백을 기준으로 입력받고 a에 저장한다.
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               a[i][0] = st.nextToken();
               a[i][1] = st.nextToken();
          }

          // 4. a 배열을 정렬하는데
          Arrays.sort(a, new Comparator<String[]>() {
               @Override
               // 나이끼리 비교하여 다를 경우 바꿔준 뒤
               public int compare(String[] o1, String[] o2) {
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
               }
          });

          // 6. a배열을 출력한다.
          for(int i = 0 ; i < N ; i++){
               bw.write(a[i][0] + " " + a[i][1] + "\n");
          }
          br.close();
          bw.flush();
          bw.close();
     }
}
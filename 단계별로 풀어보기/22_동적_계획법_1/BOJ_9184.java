import java.io.*;
import java.util.*;

public class Main {
     // 1. 동적 계획법을 위한 memory 배열을 선언하고
     public static int[][][] memory = new int[21][21][21];

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          // 2. 모두가 -1이 주어질때까지 입력받아 함수를 호출하는데
          while(true){
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());
               int c = Integer.parseInt(st.nextToken());
               if(a == -1 && b == -1 && c == -1) break;
               bw.write("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c) + "\n");
          }
          bw.flush();
          bw.close();
          br.close();
     }

     public static int w(int a, int b, int c){
          // 3. a, b, c가 범위안에 있고 memory[a][b][c]가 비어있지 않다면
          // 이미 계산이 완료된 것이므로 재귀를 수행하지 않도록 반환해주고,
          if(a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20 && memory[a][b][c] != 0){
               return memory[a][b][c];
          }

          // 4. 셋 중 하나가 0보다 작거나 같을 경우 1 반환
          if(a <= 0 || b <= 0 || c <= 0){
               return 1;
          }

          // 셋 중 하나가 20보다 클 경우
          // memory[20][20][20] 에 주어진 조건을 저장 후 반환,
          if(a > 20 || b > 20 || c > 20){
               memory[20][20][20] = w(20, 20, 20);
               return memory[20][20][20];
          }

          // a가 b보다 작고 b가 c보다 작을 경우
          // memory[a][b][c]에 주어진 조건을 저장 후 반환,
          if(a < b && b < c){
               memory[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
               return memory[a][b][c];
          }

          // 그 외라면 주어진 조건을 저장 후 반환하도록 한다.
          memory[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
          return memory[a][b][c];
     }
}
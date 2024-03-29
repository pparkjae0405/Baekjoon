import java.io.*;
import java.util.StringTokenizer;

public class Main {
     // 1. 각각의 집을 칠하는 비용 price 배열,
     public static int[][] price;
     // 경우의 수에 따른 각각의 최솟값을 구할 min배열을 선언한다.
     public static int[][] min;

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          // 2. 집의 수 N이 주어지고 price와 min배열의 크기를 지정한다.
          int N = Integer.parseInt(br.readLine());
          price = new int[N][3];
          min = new int[N][3];

          // 3. 각각의 집을 칠하는 비용이 주어진다.
          StringTokenizer st;
          for(int i = 0 ; i < N ; i++){
               st = new StringTokenizer(br.readLine(), " ");

               price[i][0] = Integer.parseInt(st.nextToken());
               price[i][1] = Integer.parseInt(st.nextToken());
               price[i][2] = Integer.parseInt(st.nextToken());
          }

          // 4. min배열의 첫번째 값을 입력받은 price값으로 초기화하고,
          min[0][0] = price[0][0];
          min[0][1] = price[0][1];
          min[0][2] = price[0][2];
          // 빨, 초를 비교한 값과 초, 파를 비교한 값을 비교하여
          int compareRed_Green = Math.min(cal(N-1, 0), cal(N-1, 1));
          int compareGreen_Blue = Math.min(cal(N-1, 1), cal(N-1, 2));
          // 그 중 최솟값을 result에 저장한 뒤 출력한다.
          int result = Math.min(compareRed_Green, compareGreen_Blue);
          bw.write(result + "\n");

          bw.flush();
          bw.close();
          br.close();
     }
     public static int cal(int N, int c){
          if(min[N][c] == 0){
               if(c == 0){
                    min[N][0] = Math.min(cal(N-1, 1), cal(N-1, 2)) + price[N][0];
               }else if(c == 1){
                    min[N][1] = Math.min(cal(N-1, 0), cal(N-1, 2)) + price[N][1];
               }else{
                    min[N][2] = Math.min(cal(N-1, 0), cal(N-1, 1)) + price[N][2];
               }
          }

          return min[N][c];
     }
}
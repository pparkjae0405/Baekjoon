import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. N과 K가 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int K = Integer.parseInt(st.nextToken());

          // 2. 파스칼의 삼각형을 이용하여 2차원 배열 a를 선언하고
          int[][] a = new int[N+1][N+1];

          // 3. 해당하는 값을 찾는데
          for(int i = 0 ; i < a.length ; i++){
               for(int j = 0 ; j <= i ; j++){
                    // i와 j가 같거나 j가 0이면 a[i][j]번째를 1로,
                    if(i == j || j == 0){
                         a[i][j] = 1;
                    }else{
                         // 아니라면 a[i-1][j-1]+a[i-1][j]값을 10007로 나눈 나머지값을 저장하고
                         a[i][j] = (a[i-1][j-1] + a[i-1][j]) % 10007;
                    }
               }
          }

          // 4. a[N][K]의 값을 출력한다.
          bw.write(a[N][K] + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
}
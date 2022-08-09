import java.io.*;
import java.util.*;

public class Main {
     // 1. 수열을 담을 배열 a, 1~N만큼의 깊이를 확인할 boolean 배열 b를 선언하고
     public static int[] a;
     public static boolean[] b;

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          // 2. 자연수 N과 M를 입력받아 a와 b의 크기를 할당한 뒤
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());
          a = new int[M];
          b = new boolean[N];

          // 3. 재귀함수를 이용하여 check가 M과 같아질때까지 반복하여
          cal(N, M, 0);
          bw.flush();
          bw.close();
          br.close();
     }
     public static void cal(int N, int M, int check){
          // 4. check와 M이 같다면 a값들을 출력하고,
          if(check == M){
               for(int i : a){
                    System.out.print(i + " ");
               }
               System.out.print("\n");
               return;
          }

          // 그 외에는 N만큼 돌면서
          for(int i = 0 ; i < N ; i++){
               // 깊이값이 false라면
               if(b[i] == false){
                    // 그 값을 true로 바꾼 후
                    b[i] = true;
                    // a[check]에 i+1만큼 값을 입력하고
                    a[check] = i+1;
                    // 재귀로 check+1번째로 이동한 뒤
                    cal(N, M, check+1);
                    // 해당 번째를 false로 바꾼다.
                    b[i] = false;
               }
          }
     }
}
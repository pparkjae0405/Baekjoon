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
          cal(N, M, 1, 0);
          bw.flush();
          bw.close();
          br.close();
     }
     public static void cal(int N, int M, int asc, int check){
          // 4. check와 M이 같다면 a값들을 출력하고,
          if(check == M){
               for(int i : a){
                    System.out.print(i + " ");
               }
               System.out.print("\n");
               return;
          }

          // 그 외에는 asc ~ N만큼 돌면서
          for(int i = asc ; i <= N ; i++){
               // a[check]에 i값을 넣은 뒤
               a[check] = i;
               // asc값+1을 해주어 오름차순 값을 찾아낸다.
               cal(N, M, i+1, check+1);
          }
     }
}
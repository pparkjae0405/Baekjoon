import java.io.*;
import java.util.*;

public class Main {
     // 1. 수열을 담을 배열 a, 입력받을 N과 M
     public static int[] a;
     public static int N;
     public static int M;
     // 출력을 위한 StingBuilder를 선언하고
     public static StringBuilder sb = new StringBuilder();

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

          // 2. 자연수 N과 M를 입력받아 a의 크기를 할당한 뒤
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          N = Integer.parseInt(st.nextToken());
          M = Integer.parseInt(st.nextToken());
          a = new int[M];

          // 3. 재귀함수를 이용하여 시작지점 start와 깊이체크 check를 넘겨주고
          cal(1, 0);

          // 5. sb값을 출력하고 br을 종료한다.
          System.out.println(sb);
          br.close();
     }
     public static void cal(int start, int check){
          // 4. check와 M이 같다면 a값들을 출력하고,
          if(check == M){
               for(int i = 0 ; i < M ; i++){
                    sb.append(a[i]).append(" ");
               }
               sb.append("\n");
               return;
          }

          // 그 외에는 start ~ N만큼 돌면서
          for(int i = start ; i <= N ; i++){
               // a[check]에 i값을 넣은 뒤
               a[check] = i;
               // i와 check+1을 재귀함수로 호출하여
               cal(i, check+1);
          }
     }
}
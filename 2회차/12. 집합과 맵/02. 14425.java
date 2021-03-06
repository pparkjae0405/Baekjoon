import java.io.*;
import java.util.*;
public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 문자열 개수 N과 M이 주어지고, 집합 S를 선언한다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());
          Set<String> S = new HashSet<String>();
          // 2. 집합 S에 포함되어있는 문자열들이 N개만큼 주어진다
          for(int i = 0 ; i < N ; i++){
               S.add(br.readLine());
          }
          // 3. M개만큼 검사해야하는 문자열들이 주어지고,
          int count = 0;
          for(int i = 0 ; i < M ; i++){
               // 4. 문자열이 집합 S에 포함되어있으면 count를 증가시키고
               if(S.contains(br.readLine())){
                    count++;
               }
          }
          // 5. for문을 탈출하였을 때의 count값을 출력한다.
          bw.write(count + "\n");
          br.close();
          bw.flush();
          bw.close();
     }
}
import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 집합 A와 B를 선언한다.
          HashSet<Integer> setA = new HashSet<Integer>();
          HashSet<Integer> setB = new HashSet<Integer>();

          // 2. A와 B집합 원소의 개수 N과 M이 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());

          // 3. N만큼 값이 주어져 A에 저장되고,
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < N ; i ++){
               setA.add(Integer.parseInt(st.nextToken()));
          }

          // 4. M만큼 값이 주어져 B에 저장된다.
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < M ; i++){
               setB.add(Integer.parseInt(st.nextToken()));
          }

          // 5. A, B집합의 합집합을 구해 setC에 저장하고,
          HashSet<Integer> setC = new HashSet<Integer>(setA);
          setC.addAll(setB);
          // A, B집합의 교집합을 구해 setD에 저장한 뒤
          HashSet<Integer> setD = new HashSet<Integer>(setA);
          setD.retainAll(setB);

          // 6. setC와 setD의 차집합을 구하여
          setC.removeAll(setD);

          // 7. setC의 길이를 출력한다.
          bw.write(setC.size() + "");

          br.close();
          bw.flush();
          bw.close();
     }
}
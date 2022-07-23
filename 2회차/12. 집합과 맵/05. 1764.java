import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 듣도 못한 사람의 수 N과 보도 못한 사람의 수 M이 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());
          // 듣도 못한 집합 setN과 보도 못한 집합 setM이 주어지고,
          HashSet<String> setN = new HashSet<String>();
          HashSet<String> setM = new HashSet<String>();

          // 2. N만큼 듣도 못한 사람의 이름이 setN에,
          for(int i = 0 ; i < N ; i++){
               setN.add(br.readLine());
          }
          // M만큼 보도 못한 사람의 이름이 setM에 저장된 후
          for(int i = 0 ; i < M ; i++){
               setM.add(br.readLine());
          }

          // 3. 두 집합의 교집합을 알아내어
          setN.retainAll(setM);

          // 4. 교집합의 크기만큼의 배열 a를 선언하고 값을 저장한 뒤
          String[] a = new String[setN.size()];
          Iterator<String> iterSet = setN.iterator();
          for(int i = 0 ; i < setN.size() ; i++){
               a[i] = iterSet.next();
          }

          // 5. a를 정렬하여 a배열의 크기와 그 내용을 출력한다.
          Arrays.sort(a);
          bw.write(a.length + "\n");
          for(int i = 0 ; i < a.length ; i++){
               bw.write(a[i] + "\n");
          }
          br.close();
          bw.flush();
          bw.close();
     }
}
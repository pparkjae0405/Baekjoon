import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. N의 진짜 약수의 개수 count, count만큼의 배열 a를 선언한다.
          int count = Integer.parseInt(br.readLine());
          int[] a = new int[count];
          // 2. N의 진짜 약수가 주어진다
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < count ; i++){
               a[i] = Integer.parseInt(st.nextToken());
          }
          // 3. a를 정렬하고, 첫번째와 마지막의 곱을 구해
          Arrays.sort(a);
          int N = a[0]*a[a.length-1];
          // 4. N을 출력한다.
          bw.write(N + "\n");
          br.close();
          bw.flush();
          bw.close();
     }
}
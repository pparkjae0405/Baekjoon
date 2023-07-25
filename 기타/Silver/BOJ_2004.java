import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. n, m이 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          long n = Long.parseLong(st.nextToken());
          long m = Long.parseLong(st.nextToken());

          // 2. 각각의 승수를 구하기 위한 count2, count5가 주어지고
          long count2 = cal2(n) - cal2(m) - cal2(n-m);
          long count5 = cal5(n) - cal5(m) - cal5(n-m);

          // 3. count2와 count5 중 작은 값을 출력한다.
          bw.write(Math.min(count2, count5) + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
     // n!과 m!, (n-m)!에 해당하는 각각을 계산하는 cal2, cal5를 구현한 뒤
     public static long cal2(long n){
          int count = 0;

          while(n >= 2){
               count += n/2;
               n /= 2;
          }
          return count;
     }
     public static long cal5(long n) {
          int count = 0;

          while (n >= 5) {
               count += n / 5;
               n /= 5;
          }
          return count;
     }
}
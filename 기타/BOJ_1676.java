import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. N이 주어진다
          int N = Integer.parseInt(br.readLine());
          // 2. 0의 개수는 5^n승으로 나누어지는 개수이므로
          int count = 0;

          // 3. N이 5보다 작아질 때까지 반복하여
          while(N >= 5){
               // 5로 나눌때마다 1씩 증가시킨 뒤
               count += N/5;
               N /= 5;
          }
          // 4. while문을 탈출했을때의 count값을 출력한다.
          bw.write(count + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
}
import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 두 수 N, M이 0일때까지 반복하여 입력받고
          while(true) {
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               int N = Integer.parseInt(st.nextToken());
               int M = Integer.parseInt(st.nextToken());
               if(N == 0 && M == 0) break;

               // 2. 두 수를 비교하여
               if (M % N == 0) {
                    // N이 M의 약수면 factor
                    bw.write("factor" + "\n");
               } else if (N % M == 0) {
                    // N이 M의 배수면 multiple
                    bw.write("multiple" + "\n");
               } else {
                    // 둘 다 아니면 neither 출력
                    bw.write("neither" + "\n");
               }
          }
          br.close();
          bw.flush();
          bw.close();
     }
}
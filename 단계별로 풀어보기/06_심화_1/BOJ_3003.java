import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 킹, 퀸, 룩, 비숍, 나이트, 폰의 개수가 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          // 2. 1, 1, 2, 2, 2, 8에 맞는 개수만큼 출력한다.
          bw.write(1-Integer.parseInt(st.nextToken()) + " ");
          bw.write(1-Integer.parseInt(st.nextToken()) + " ");
          bw.write(2-Integer.parseInt(st.nextToken()) + " ");
          bw.write(2-Integer.parseInt(st.nextToken()) + " ");
          bw.write(2-Integer.parseInt(st.nextToken()) + " ");
          bw.write(8-Integer.parseInt(st.nextToken()) + " ");
          bw.flush();
          bw.close();
          br.close();
     }
}
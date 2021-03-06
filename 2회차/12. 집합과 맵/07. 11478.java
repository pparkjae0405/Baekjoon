import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 문자열 S와 집합 a가 주어지고
          String S = br.readLine();
          HashSet<String> a = new HashSet<String>();

          // 2. S의 길이만큼 문자열을 쪼개 a에 저장한 뒤
          for(int i = 0 ; i < S.length(); i ++){
               String b = "";
               for(int j = i ; j < S.length() ; j++){
                    b += S.substring(j,j+1);
                    a.add(b);
               }
          }
          // 3. a의 크기를 출력한다.
          bw.write(a.size() + "");
          br.close();
          bw.flush();
          bw.close();
     }
}
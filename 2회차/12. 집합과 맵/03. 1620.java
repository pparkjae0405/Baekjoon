import java.io.*;
import java.util.*;
import java.util.Map.*;

public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 도감 개수 N과 문제 개수 M,
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());

          // key값이 숫자인 pokemon_int, 문자열인 pokemon_str이 주어진다
          HashMap<Integer, String> pokemon_int = new HashMap<Integer, String>();
          HashMap<String, Integer> pokemon_str = new HashMap<String, Integer>();

          // 2. N개의 줄에 1~N에 해당하는 포켓몬이 주어진다
          for(int i = 1 ; i <= N ; i++){
               String a = br.readLine();
               pokemon_int.put(i, a);
               pokemon_str.put(a, i);
          }

          // 3. M개의 문제가 주어지는데
          for(int i = 0 ; i < M ; i++) {
               String a = br.readLine();
               // 5. 정수가 들어오면 pokemon_int의 value값을,
               if(isNum(a)) {
                    bw.write(pokemon_int.get(Integer.parseInt(a)) + "\n");
               }else{
                    // 문자열이 들어오면 pokemon_str의 value값을 출력한다.
                    bw.write(pokemon_str.get(a) + "\n");
               }
          }
          br.close();
          bw.flush();
          bw.close();
     }
     // 4. 정수인지 문자열인지 판단하기 위한 isNum 함수를 작성하고,
     public static boolean isNum(String str) {
          for (int i = 0; i < str.length(); i++) {
               if (!Character.isDigit(str.charAt(i))) {
                    return false;
               }
          }
          return true;
     }
}
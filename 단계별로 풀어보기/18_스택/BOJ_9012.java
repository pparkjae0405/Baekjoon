import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 테스트 데이터 T를 입력받는다.
          int T = Integer.parseInt(br.readLine());

          // 2. T만큼 데이터를 입력받아 계산하는데
          for(int i = 0 ; i < T ; i++){
               bw.write(cal(br.readLine()) + "\n");
          }

          bw.flush();
          bw.close();
          br.close();
     }
     public static String cal(String b){
          // 3. 스택 a를 선언하고,
          Stack<Character> a = new Stack<>();
          // 전달받은 문자열 b를 하나씩 떼서
          for(int j = 0 ; j < b.length() ; j++){
               char c = b.charAt(j);
               // ( 일 경우 스택에 추가하고
               if(c == '('){
                    a.push(c);
               }else if(a.empty()){
                    // ) 일 때 스택이 비어있다면 NO를 반환하고
                    return "NO";
               }else{
                    // 아니라면 스택에서 제거한다.
                    a.pop();
               }
          }
          // 4. 다 돌았을 때 스택이 비어있다면 YES를 반환하고,
          if(a.empty()){
               return "YES";
          }else{
               // 아니라면 NO를 반환한다.
               return "NO";
          }
     }
}
import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 문자열이 "." 하나만 들어올 때까지 반복하여 입력받는데
          while(true){
               String a = br.readLine();
               if(a.equals(".")){
                    break;
               }

               // 2. 문자열을 순회하여 소괄호와 대괄호를 인식할 스택,
               Stack<Character> b = new Stack<Character>();
               // 조건에 맞는지 체크할 isError를 선언하고
               boolean isError = false;
               for(int i = 0 ; i < a.length() ; i++){
                    // 3. 순회하며 (이나 [가 나오면 스택에 추가하고,
                    if(a.charAt(i) == '(' || a.charAt(i) == '['){
                         b.push(a.charAt(i));
                    }else if(a.charAt(i) == ')'){
                         // )가 나왔을 때 b가 비어있거나 [가 있을 경우
                         if(b.isEmpty() == true || b.peek() != '('){
                              // isError를 true로 변환하고 no를 출력한 뒤 탈출,
                              isError = true;
                              bw.write("no" + "\n");
                              break;
                         }else {
                              // 아니라면 small의 맨 위 값 하나를 제거,
                              b.pop();
                         }
                    }else if(a.charAt(i) == ']'){
                         // ]가 나왔을 때 b가 비어있거나 (가 있을 경우
                         if(b.isEmpty() == true || b.peek() != '['){
                              // isError를 true로 변환하고 no를 출력한 뒤 탈출,
                              isError = true;
                              bw.write("no" + "\n");
                              break;
                         }else {
                              // 아니라면 small의 맨 위 값 하나를 제거,
                              b.pop();
                         }
                    }
               }

               // 4. 순회가 끝났을 때 에러가 없고 스택이 비어있다면
               if(isError == false) {
                    if (b.isEmpty() == true) {
                         // yes를 출력하고,
                         bw.write("yes" + "\n");
                    }else{
                         // 차있다면 no를 출력한다.
                         bw.write("no" + "\n");
                    }
               }
          }
          bw.flush();
          bw.close();
          br.close();
     }
}
import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringBuilder sb = new StringBuilder();
          // 1. 첫 줄에 n이 주어진다.
          int n = Integer.parseInt(br.readLine());

          // 2. 목표 수열을 n번 입력받아 배열에 저장하고
          int[] temp_arr = new int[n];
          for(int i = 0 ; i < n ; i++){
               temp_arr[i] = Integer.parseInt(br.readLine());
          }

          // 3. 스택 a를 선언하여 배열의 뒤부터 앞까지 입력한 뒤
          Stack<Integer> a = new Stack<Integer>();
          for(int i = 0 ; i < n ; i++){
               a.push(temp_arr[(n-1)-i]);
          }

          // 4. 스택 b를 선언하여 1~n까지 입력받는데
          Stack<Integer> b = new Stack<Integer>();
          // 입력받은 횟수 count를 선언하고
          int count = 0;
          for(int i = 1 ; i <= n ; i++){
               // count를 증가시킨 뒤 a의 맨 위 값과 비교하여
               count++;
               if(a.peek() != i) {
                    // 틀리면 + 출력 후 b에 저장,
                    sb.append("+" + "\n");
                    b.push(i);
               }else {
                    // 같으면 + 출력 후 b에 저장한 뒤
                    sb.append("+" + "\n");
                    b.push(i);

                    // 현재 count값 temp_count를 선언하고 그만큼 a와 b의 맨 위 값을 비교하는데
                    int temp_count = count;
                    for(int j = 0 ; j < temp_count ; j++){
                         // (객체 값을 비교할때는 .equals()를 사용하도록 하자)
                         if(a.peek().equals(b.peek())){
                              // 같으면 - 출력 후 a와 b의 맨 위 값을 삭제하고 count를 1 감소시키고,
                              sb.append("-" + "\n");
                              a.pop();
                              b.pop();
                              count--;
                         }else{
                              // 틀리면 탈출하여 다음으로 넘어간다.
                              break;
                         }
                    }
               }
          }

          // 5. 4번을 탈출한 뒤 두 스택이 전부 비어있다면 sb를 출력하고,
          if(a.isEmpty() == true && b.isEmpty() == true){
               System.out.println(sb);
          }else{
               // 아니라면 NO를 출력한다.
               System.out.println("NO");
          }

          br.close();
     }
}
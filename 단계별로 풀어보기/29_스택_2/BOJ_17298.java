import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          StringBuilder sb = new StringBuilder();
          // 1. 수열의 크기 N을 입력받는다.
          int N = Integer.parseInt(br.readLine());

          // 2. N만큼의 배열 a를 선언하고 수열을 입력받아 저장한다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int[] a = new int[N];
          for(int i = 0 ; i < N ; i++){
               a[i] = Integer.parseInt(st.nextToken());
          }

          // 3. 스택 b를 선언하고 수열의 값들을 순회하는데
          Stack<Integer> b = new Stack<Integer>();
          for(int i = 0 ; i < N ; i++){

               // 스택이 비어있지 않고
               // a[i] > a[스택의 맨 위(인덱스)]라면 오큰수이므로
               while(!b.isEmpty() && a[i] > a[b.peek()]){
                    // 스택의 원소를 pop하여
                    // b가 비어있거나 a[i] < a[b.peek()]일 때 까지
                    // a[스택의 맨 위(인덱스)]를 a[i]로 바꾸고,
                    a[b.pop()] = a[i];
               }

               // i(다음 수의 인덱스)를 스택에 저장한다.
               b.push(i);
          }

          // 4. 3번이 끝나면 스택에 있는 요소들을 pop하며 -1로 바꾼 뒤
          while(!b.isEmpty()){
               a[b.pop()] = -1;
          }

          // 5. a의 값들을 출력한다.
          for(int i = 0 ; i < N ; i++){
               bw.write(a[i] + " ");
          }

          bw.flush();
          bw.close();
          br.close();
     }
}
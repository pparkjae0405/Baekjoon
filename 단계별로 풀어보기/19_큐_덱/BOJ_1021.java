import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 큐의 크기 N과 뽑으려 하는 수의 개수 M이 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());

          // 2. 덱 a를 선언하고, 1~N까지의 수를 덱에 추가한다.
          LinkedList<Integer> a = new LinkedList<Integer>();
          for(int i = 1 ; i <= N ; i++){
               a.offer(i);
          }

          // 3. 뽑으려는 수 M개를 저장할 배열 b를 선언하여 저장한다.
          int[] b = new int[M];
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < M ; i++){
               b[i] = Integer.parseInt(st.nextToken());
          }

          // 4. M개를 뽑는데 2, 3번연산 횟수 count를 선언하고
          int count = 0;
          for(int i = 0 ; i < M ; i++){
               // 5. 뽑으려는 숫자의 위치 targetIndexOfa와
               int targetIndexOfa = a.indexOf(b[i]);
               // 덱의 크기의 절반값 halfIndexOfa를 선언하여
               int halfIndexOfa;
               // a의 크기가 짝수이면 a.size()/2-1,
               if(a.size() % 2 == 0){
                    halfIndexOfa = a.size()/2 - 1;
               }else{
                    // 홀수이면 a.size()/2 하여 덱 크기의 절반값을 찾은 뒤
                    halfIndexOfa = a.size()/2;
               }

               // 6. 뽑으려는 값이 중간보다 앞에 있을 경우
               if(targetIndexOfa <= halfIndexOfa){
                    // 2번 연산을 targetIndexOfa만큼 수행하며 count를 증가하고,
                    for(int j = 0 ; j < targetIndexOfa ; j++){
                         a.offerLast(a.pollFirst());
                         count++;
                    }
               }else{
                    // 뽑으려는 값이 중간보다 뒤에 있을 경우
                    // 3번 연산을 a.size()-targetIndexOfa만큼 수행하며 count를 증가시켜
                    for(int j = 0 ; j < a.size()-targetIndexOfa; j++){
                         a.offerFirst(a.pollLast());
                         count++;
                    }
               }
               // 7. 원하는 값이 제일 처음에 있도록 하여 맨 앞 원소를 삭제하고
               a.pollFirst();
          }
          // 8. M번 돌았을 때의 count값을 출력한다.
          bw.write(count + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
}
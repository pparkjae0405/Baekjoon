import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 테스트케이스 T가 주어지고,
          int T = Integer.parseInt(br.readLine());

          // 2. 테스트 케이스 수만큼 반복하여
          for(int i = 0 ; i < T ; i++){
               // 문서의 번호와 중요도를 저장할 큐 a를 선언한 뒤
               Queue<int[]> a = new LinkedList<>();

               // 3. 첫 번째 줄의 값으로 문서의 개수 N과
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               int N = Integer.parseInt(st.nextToken());
               // 알아낼 문서가 큐의 몇 번째에 있는지 나타내는 M이 주어지고
               int M = Integer.parseInt(st.nextToken());

               // 4. 두 번째 줄의 값으로 N만큼의 중요도를 받아와
               st = new StringTokenizer(br.readLine(), " ");
               for(int j = 0 ; j < N ; j++){
                    // 문서의 번호와 중요도를 a에 저장한 뒤
                    a.add(new int[] {j, Integer.parseInt(st.nextToken())} );
               }

               // 5. M이 몇 번째로 인쇄되는지 출력하기 위해
               int count = 0;
               while(true){
                    // 현재 맨 위의 a값(번호, 중요도)을 front에 저장하고
                    int front[] = a.remove();
                    // 가장 높은 중요도 판단값 max를 true로 저장한 다음
                    boolean max = true;

                    // 6. a[]값을 가져오는데
                    for(int c[] : a){
                         // 중요도가 front값보다 크다면
                         if(c[1] > front[1]){
                              // false로 바꾸고 for문을 탈출하고
                              max = false;
                              break;
                         }
                    }
                    // 7. falg값이 true면
                    if(max){
                         // count값을 증가시키고
                         count++;
                         // front의 번호가 M과 같다면 while문을 탈출하여 count값을 출력하고,
                         if(front[0] == M) break;
                    }else{
                         // false라면 맨 앞 값을 맨 뒤로 보낸다.
                         a.add(front);
                    }
               }

               bw.write(count + "\n");
          }
          bw.flush();
          bw.close();
          br.close();
     }
}
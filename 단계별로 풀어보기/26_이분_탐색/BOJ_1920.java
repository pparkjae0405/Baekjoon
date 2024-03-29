import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 자연수 N이 주어진다
          int N = Integer.parseInt(br.readLine());

          // 2. 배열 a를 선언하고 N개의 정수를 저장한 뒤 a를 정렬한다.
          int[] a = new int[N];
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < N ; i++) {
               a[i] = Integer.parseInt(st.nextToken());
          }
          Arrays.sort(a);

          // 3. M이 주어진다
          int M = Integer.parseInt(br.readLine());

          // 4. M개의 수들이 주어지는데,
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < M ; i++) {
               // 7. 함수를 호출한 결과를 출력한다.
               bw.write(search(a, Integer.parseInt(st.nextToken()), 0, N-1) + "\n");
          }
          bw.flush();
          bw.close();
          br.close();
     }

     // 5. a배열과 key, start, end값을 통해 이분탐색으로
     // A안에 수가 존재하는지 알아내기 위한 함수 search를 선언하고
     public static int search(int[] a, int key, int start, int end){
          // 6. 원소가 하나가 될 때까지 반복하여 key값과 비교하는데
          while(start <= end) {
               // a[start] ~ a[end]의 중간값 half를 구한 뒤
               int half = (start+end)/2;

               // key == a[half]라면 1을 리턴,
               if(key == a[half]) {
                    return 1;
               }else if(key > a[half]){
                    // key > half라면 start를 half+1로 바꿔 왼쪽 반을 버리고
                    start = half + 1;
               }else{
                    // key < half라면 end를 half-1로 바꿔 오른쪽 반을 버리고,
                    end = half - 1;
               }
          }
          // while문이 끝났다면 존재하지않는 것이므로 0을 리턴한다.
          return 0;
     }
}
import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          // 1. 나무의 수 N과 필요한 나무의 길이 M이 주어진다.
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int N = Integer.parseInt(st.nextToken());
          int M = Integer.parseInt(st.nextToken());

          // 2. 배열 a를 선언하여 N개만큼 입력받아 저장하는데
          int[] a = new int[N];
          long max = 0;
          st = new StringTokenizer(br.readLine(), " ");
          for(int i = 0 ; i < N ; i++){
               a[i] = Integer.parseInt(st.nextToken());
               // 그 중 최댓값을 max에 저장하고
               if(a[i] > max) max = a[i];
          }

          // 상한방식을 통해 key값이 나오지 않는 시점의 값을 찾게 되므로
          // max에 1을 더해주고
          max++;

          // 3. 최솟값과 중간값을 선언하고 높이의 최댓값을 찾는데
          long min = 0;
          long half = 0;
          while(min < max){
               // 중간 길이를 구해
               half = (min+max)/2;

               // 중간길이로 나무를 자른 결과 length를 선언하고
               long length = 0;
               for(int i = 0 ; i < a.length ; i++){
                    // half로 a[i]를 잘랐을 때 나오는 길이 cut를 선언하여
                    long cut = a[i] - half;
                    // 양수일 경우만 더하여
                    if(cut > 0) {
                         length += cut;
                    }
               }

               // 그 결과가 M보다 적다면 길이를 더 줄여서 잘라야 한다는 뜻이므로
               if(length < M){
                    // 최대 길이를 줄이고,
                    max = half;
               }else{
                    // 그 외에는 최솟값을 올려서
                    min = half + 1;
               }
          }

          // 4. 필요한 길이 M을 초과하는 시점의 절단기의 높이값이 min이므로
          // min - 1으로 출력한다.
          bw.write(min-1 + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
}
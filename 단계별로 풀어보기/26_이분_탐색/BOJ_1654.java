import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

          // 1. 랜선 K개와 만들 랜선 개수 N개를 입력받고,
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");
          int K = Integer.parseInt(st.nextToken());
          int N = Integer.parseInt(st.nextToken());

          // 2. 배열 a를 선언하여 K개만큼 입력받아 저장하는데
          int[] a = new int[K];
          long max = 0;
          for(int i = 0 ; i < K ; i++){
               a[i] = Integer.parseInt(br.readLine());
               // 가장 긴 랜선을 max에 저장하고
               if(a[i] > max) max = a[i];
          }

          // 상한방식을 통해 key값이 나오지 않는 시점의 값을 찾게 되므로
          // max에 1을 더해주고
          max++;

          // 3. 최솟값과 중간값을 선언하고 최대 길이를 찾는데
          long min = 0;
          long half = 0;
          while(min < max){
               // 중간 길이를 구해
               half = (min+max)/2;

               // 중간길이로 랜선들을 잘라본 개수 count를 선언하고
               long count = 0;
               for(int i = 0 ; i < a.length ; i++){
                    // a[i]값마다 중간길이로 자른 개수를 더해
                    count = count + (a[i] / half);
               }

               // 그 결과가 N개보다 적다면 길이를 더 줄여서 잘라야 한다는 뜻이므로
               if(count < N){
                    // 최대 길이를 줄이고,
                    max = half;
               }else{
                    // 그 외에는 최솟값을 올려서
                    min = half + 1;
               }
          }

          // 4. N개가 더이상 안나오는 시점의 크기가 min이므로
          // min - 1으로 출력한다.
          bw.write(min-1 + "\n");
          bw.flush();
          bw.close();
          br.close();
     }
}
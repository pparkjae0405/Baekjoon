import java.io.*;
import java.util.*;
public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 홀수인 수의 개수 N을 입력받는다.
          int N = Integer.parseInt(br.readLine());

          // 2. 크기 N만큼의 배열 a를 선언한다.
          int[] a = new int[N];

          // 3. 수들의 합 sum을 선언하고 N개만큼 수를 입력받은 뒤
          double sum = 0;
          for(int i = 0 ; i < N ; i++){
               // 배열에 저장하고 sum에 더한다.
               a[i] = Integer.parseInt(br.readLine());
               sum += a[i];
          }

          // 4. 배열을 정렬하고 주어진 값들을 구하는데
          Arrays.sort(a);

          // 5. 수들의 합을 N으로 나눈 뒤 반올림한 산술평균을 구하고,
          bw.write(Math.round(sum/N) + "\n");

          // 6. a의 (N-1)/2번째 값으로 중앙값을 구하고,
          bw.write(a[(N-1)/2] + "\n");

          // 7. 같은 값의 수를 세는 count,
          // count와 비교하여 가장 많이 나온 수를 알아낼 max(개수는 0부터 시작이므로 -1),
          // 주어진 최빈값을 알아낼 most(수의 개수가 1개면 맨 처음값이 최빈값이므로 a[0]),
          // 최빈값이 같은 수가 여러개일 경우 첫번째, 두번째를 판단할 check를 선언
          int count = 0;
          int max = -1;
          int most = a[0];
          boolean check = false;
          // 0부터 N-1까지 돌면서
          for(int i = 0 ; i < N-1 ; i++){
               // 앞뒤가 같으면 count++, 다르면 0으로 만들어주고
               if(a[i] == a[i+1]){
                    count++;
               }else{
                    count = 0;
               }
               // count가 max보다 크다면 같은 수가 존재한다는 의미이므로
               if(count > max){
                    // max를 count로,
                    max = count;
                    // 그때의 a[i]값을 최빈값 most로,
                    most = a[i];
                    // 1번째 최빈값임을 check를 true로 저장하고,
                    check = true;
                    // 만약 count가 max와 같고(같은 수를 가진 수가 더 있고)
                    // check가 true라면(이미 1번째 최빈값이 있다면)
               }else if(max == count && check == true){
                    // 그때의 a[i]값을 최빈값 most로,
                    most = a[i];
                    // 2번째 최빈값임을 check를 false로 저장하고
                    check = false;
               }
          }
          // 위 반복문을 통해 최빈값을 구하고,
          bw.write(most + "\n");

          // 8. a[n-1] - a[0]으로 범위를 구해 출력한다.
          bw.write(a[N-1] - a[0] + "\n");
          bw.flush();
     }
}
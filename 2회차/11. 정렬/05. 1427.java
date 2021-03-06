import java.io.*;
import java.util.*;
public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. N을 입력받는다.
          String N = br.readLine();
          // 2. N의 문자열 길이만큼의 배열 b를 선언하고,
          int[] b = new int[N.length()];
          // 하나씩 떼어 정수로 저장한다.
          for(int i = 0 ; i < N.length() ; i++){
               b[i] = N.charAt(i) - '0';
          }
          // 3. 배열 b를 오름차순으로 정렬한다.
          Arrays.sort(b);

          // 4. 답 answer과 입력받은 N의 자릿수 digit를 선언한다.
          int answer = 0;
          int digit = (int)Math.pow(10,N.length()-1);
          // 5. 뒤에서부터 돌면서 내림차순으로 자릿수 별 숫자를 구해 출력한다.
          for(int i = N.length()-1; i > -1 ; i--){
               answer += b[i]*digit;
               digit /= 10;
          }
          bw.write(answer + "\n");
          bw.flush();
     }
}
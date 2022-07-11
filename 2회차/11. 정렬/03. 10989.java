import java.io.*;
import java.util.*;
public class Main {
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 입력받을 횟수 N을 입력받는다.
        int N = Integer.parseInt(br.readLine());
        // 2. 크기가 N인 배열 a를 선언하고
        int[] a = new int[N];
        // N만큼 숫자를 입력받아 배열에 저장한 뒤
        for(int i = 0 ; i < N ; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        // a배열을 정렬하고
        Arrays.sort(a);
        // 3. 배열을 출력한다.
        for(int i = 0 ; i < N ; i++){
            bw.write(a[i] + "\n");
        }
        bw.flush();
   }
}
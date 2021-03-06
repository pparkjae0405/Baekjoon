import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 들어온 숫자를 저장할 a배열, 정렬할 b배열 선언,
        int[] a = new int[9];
        int[] b = new int[9];
        int count = 1;
        // 2. 9개의 자연수를 입력받아 a배열에 저장
        for(int i = 0; i < 9; i++){
            a[i] = Integer.parseInt(br.readLine());
            b[i] = a[i];
        }
        // 3. b배열 오름차순 정렬
        Arrays.sort(b);
        // 4. 최댓값 출력, 위치 체크하여 출력
        System.out.println(b[8]);
        for(int i = 0; i < 9; i++){
            if(a[i] == b[8])
                System.out.println(count);
            count++;
        }
    }
}
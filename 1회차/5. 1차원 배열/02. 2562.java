import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] b = new int[9]; //배열 선언
        int[] b1 = new int[9]; //정렬할 복사본
        int count = 1; // 최댓값이 어디 있는지 확인할 변수
        for(int i=0;i<9;i++) {
            b[i] = Integer.parseInt(br.readLine()); // 값 저장
            b1[i] = b[i]; // 값 복사
        }
        Arrays.sort(b1); // 복사본 정렬
        System.out.println(b1[8]); //최댓값 확인
        for(int i=0;i<9;i++){ //최댓값 위치 확인
            if(b[i] == b1[8])
                System.out.println(count);
            count++;
        }
        br.close();
    }
}
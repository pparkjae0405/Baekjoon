import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력받을 버퍼리더
        int a = Integer.parseInt(br.readLine()); // 점수 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 점수 구분
        float[] b = new float[a]; // 점수 배열 크기 지정
        float score = 0; //바뀐 점수 합계
        for(int i=0;i<a;i++){  // 점수 입력
            b[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(b); // 배열 정렬
        for(int j=0;j<a;j++){ // 원하는 점수로 변환 후 합계 도출
            b[j] = (b[j]/b[a-1])*100;
            score = score+b[j];
        }
        float result = score/a; // 점수 평균 도출
        System.out.println(result); // 평균 출력
    }
}
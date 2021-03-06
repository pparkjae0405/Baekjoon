import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine()); //테스트케이스 개수
        float[] d = new float[a]; //비율 배열
        for(int i=0;i<a;i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int b = Integer.parseInt(st.nextToken()); // 테스트케이스의 학생 수 판별
            float score = 0; float average = 0; float count = 0; float percent = 0; //총합,평균,평균초과수,비율
            int[] c = new int[b];
            for (int j = 0; j < b; j++) { //학생수만큼 총합 구하기
                c[j] = Integer.parseInt(st.nextToken());
                score = score + c[j];
            }
            average = score / b; //학생수만큼 평균값 구하기
            for (int k = 0; k < b; k++) { // 평균초과한 학생수 구하기
                if (c[k] > average) {
                    count++;
                }
            }
            percent = (count / b) * 100; //비율 구하기
            d[i] = percent; //비율 배열에 추가
        }
        for(int n=0;n<a;n++){ // 비율 배열 출력
            System.out.println(String.format("%.3f", d[n])+ "%");
        }

    }
}
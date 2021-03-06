import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 입력받을 테스트 케이스개수 C 선언
        int c = Integer.parseInt(br.readLine());
        // 2. C의 개수만큼 반복하여
        for(int i = 0 ; i < c ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // 학생 수 N, N명의 점수를 입력받을 배열, 평균값을 구하기 위한 sum 선언
            int N = Integer.parseInt(st.nextToken());
            int[] score = new int[N];
            int sum = 0;
            // N명의 점수를 저장
            for(int j = 0 ; j < N ; j++){
                score[j] = Integer.parseInt(st.nextToken());
                sum = sum + score[j];
            }
            // 3. N명의 점수 평균을 구하는 avg 선언
            int avg = sum/N;
            // 4. 평균을 넘는 학생 수 카운트를 위한 count 선언 후 계산
            int count = 0;
            for(int k = 0; k < N ; k++){
                if(score[k] > avg)
                    count++;
            }
            // 5. 평균을 넘는 학생수 result 선언 및 계산, 소수점 셋째 자리까지 구하여 저장
            float result = (float)(count*100)/N;
            bw.write(String.format("%.3f", result)+ "%\n");
        }
        // 6. 저장한 값을 출력
        bw.flush();
    }
}
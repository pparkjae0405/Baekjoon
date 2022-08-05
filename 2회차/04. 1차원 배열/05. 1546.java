import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 과목의 갯수 N을 입력받음, N만큼의 배열 선언, 점수의 합 sum 선언
        int N = Integer.parseInt(br.readLine());
        float[] a = new float[N];
        float sum = 0;
        // 2. N 갯수만큼의 점수를 받고, 배열에 저장한다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            a[i] = Float.parseFloat(st.nextToken());
        }
        // 3. 배열의 최댓값 M을 찾는다
        Arrays.sort(a);
        float M = a[N-1];
        // 4. 모든 점수를 점수/M*100으로 고치고, sum값에 추가
        for(int i = 0 ; i < N ; i++){
            a[i] = a[i]/M*100;
            sum = sum + a[i];
        }
        // 5. 평균을 구하여 출력
        System.out.println(sum/N);
    }
}
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 배열의 크기를 정할 n 입력
        int n = Integer.parseInt(br.readLine());
        // n의 크기만큼 배열 a 선언
        int[] a = new int[n];
        // 배열에 들어갈 값을 공백을 기준으로 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 입력받은 값에 따른 nextToken 값을 배열에 저장
        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        // 배열 오름차순 정렬
        Arrays.sort(a);
        // 배열의 최솟값과 최댓값 출력
        System.out.println(a[0] + " " + a[n-1]);
    }
}
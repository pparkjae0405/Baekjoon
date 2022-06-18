import java.io.*;
import java.util.*;

public class Main {
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 카드 개수 N과 주어진 숫자 M을 입력받는다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 2. 카드에 쓰여질 숫자 N개를 입력받고 배열 a에 저장한다.
        st = new StringTokenizer(br.readLine(), " ");
        int[] a = new int[N];
        for(int i = 0 ; i < N ; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        // 3. 가장 가까운 값 max를 선언하고 a배열을 정렬한 뒤
        int max = 0;
        Arrays.sort(a);
        // 4. 배열 중 3개를 정해 모든 경우의 수를 탐색하여
        for(int i = 0 ; i < N-2 ; i++){
            for(int j = i+1 ; j < N-1 ; j++){
                for(int k = j+1 ; k < N ; k++){
                    int sum = a[i]+a[j]+a[k];
                    // sum값이 max보다 크고 M보다 작거나 같다면 그 값을 max값에 대입하고
                    if (max < sum && sum <= M) {
                        max = sum;
                    }
                }
            }
        }
        // 5. 탐색이 끝났을 시 max값을 출력한다.
        bw.write(max + "\n");
        bw.flush();
    }
}
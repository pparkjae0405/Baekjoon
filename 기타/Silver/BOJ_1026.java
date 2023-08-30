import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 배열 A와 B가 주어진다.
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        int[] B = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 3. A, B를 정렬하고
        Arrays.sort(A);
        Arrays.sort(B);
        int min = 0;
        // A는 처음부터, B는 마지막부터 선택해 그 곱을 min에 추가하여
        for(int i = 0 ; i < N ; i++){
            min += (A[i] * B[(N - 1) - i]);
        }
        // 출력한다.
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
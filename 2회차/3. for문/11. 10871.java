import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N과 X가 주어짐
        st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 정수 N개로 이루어진 수열 A가 주어짐
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 수열 A에서 정수 X보다 작은 수를 모두 출력
        for(int i = 0; i < N; i++){
            if( A[i] < X )
                bw.write(A[i] + " ");
        }
        bw.flush();
    }
}
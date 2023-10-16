import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N, M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        // 행렬 A를 선언하고 N만큼 원소 M개가 주어진다.
        int[][] A = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. M, K가 주어지고
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        // 행렬 B를 선언하고 M만큼 원소 K개가 주어진다.
        int[][] B = new int[M][K];
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < K ; j++){
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 행렬을 계산하여 출력한다.
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < K ; j++){
                int sum = 0;
                for(int k = 0 ; k < M ; k++){
                    sum += A[i][k] * B[k][j];
                }
                bw.write(sum + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
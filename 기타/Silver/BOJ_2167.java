import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 배열의 크기 N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. N*M 크기의 배열 정보를 저장한다.
        int[][] arr = new int[N + 1][M + 1];
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= M ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 합을 구할 부분의 개수 K가 주어지고 K만큼 돌면서
        int K = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < K ; i++){
            // 시작 (y, x)와 도착 (y, x)를 가져와
            st = new StringTokenizer(br.readLine(), " ");
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            // 해당 위치의 누적합을 구해 출력한다.
            int sum = 0;
            for(int a = startY ; a <= endY ; a++){
                for(int b = startX ; b <= endX ; b++){
                    sum += arr[a][b];
                }
            }
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
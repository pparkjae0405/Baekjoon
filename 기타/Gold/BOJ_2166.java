import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 점의 개수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 점의 (x, y) 좌표를 저장할 arr 배열을 선언하고 정보를 저장한다.
        int[][] arr = new int[N + 1][2];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 3. 도형 둘레의 합 sum을 선언하여
        double sum = 0;
        for(int i = 0 ; i < N ; i++){
            // 값을 추가하고
            sum += (double) arr[i][0] * arr[(i + 1) % N][1];
            sum -= (double) arr[i][1] * arr[(i + 1) % N][0];
        }
        // 절대값을 출력 형식에 맞춰 출력한다.
        System.out.printf("%.1f", Math.abs(sum / 2));

        bw.flush();
        bw.close();
        br.close();
    }
}
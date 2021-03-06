import java.io.*;
import java.util.*;
public class Main {
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 가로세로 N과 M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. NxM에 맞는 배열 a를 선언하고
        boolean[][] a = new boolean[N][M];
        for(int i = 0 ; i < N ; i++) {
            // 라인을 입력받은 뒤
            String line = br.readLine();
            for(int j = 0 ; j < M ; j++){
                // W나 B에 따라 배열에 true, false값을 저장한다.
                if(line.charAt(j) == 'W'){
                    a[i][j] = true;
                }else{
                    a[i][j] = false;
                }
            }
        }

        // 3. 최솟값 min을 선언하고
        // 8x8의 형태로 분석하게 되므로 (N-7 * M-7)번 반복하여
        int min = 64;
        for(int i = 0 ; i < N-7 ; i++) {
            for(int j = 0 ; j < M-7 ; j++) {
                // 색칠 횟수 count와 첫 번째 값을 저장할 first를 선언하고
                int count = 0;
                boolean first = a[i][j];

                // i와 j에 따라 8*8보드를 비교하는데
                for (int k = i; k < i + 8; k++) {
                    for (int l = j ; l < j + 8 ; l++) {
                        // a[k][l]번째가 first값과 같지 않다면 count++를 한 뒤
                        if (a[k][l] != first) {
                            count++;
                        }
                        // l(가로)값이 계속 번갈아 나와야 하므로 !first를 해주고,
                        first = !first;
                    }
                    // k(세로)값도 계속 번갈아 나와야 하므로 !first를 해준다.
                    first = !first;
                }
                // count값은 색칠한 값과 색칠하지 않은 값 중 최솟값을 비교하여 대입하고,
                count = Math.min(count, 64 - count);
                // min값은 min값과 위에서 선언한 count값 중 최솟값을 비교하여 대입한 뒤
                min = Math.min(min, count);
            }
        }
        // 4. 최솟값을 출력한다.
        bw.write(min + "\n");
        bw.flush();
    }
}
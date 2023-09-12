import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 사람의 수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 각 사람 별 카드 정보 card를 선언하고
        int[][] card = new int[N][5];
        // 카드 정보를 저장한다.
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 5 ; j++){
                card[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. 5개 중 3개를 고른 합의 1의자리를 찾아
        int[] max = new int[N];
        for(int i = 0 ; i < N ; i++) {
            for (int a = 0 ; a < 3 ; a++) {
                for (int b = a + 1 ; b < 4; b++) {
                    for (int c = b + 1 ; c < 5 ; c++) {
                        max[i] = Math.max(max[i],
                                (card[i][a] + card[i][b] + card[i][c]) % 10);
                    }
                }
            }
        }

        // 4. max 중 최댓값의 위치를 찾아 출력한다.
        int idx = -1;
        int result = -1;
        for(int i = 0 ; i < N ; i++){
            if(result <= max[i]){
                result = max[i];
                idx = i + 1;
            }
        }
        bw.write(idx + "\n");


        bw.flush();
        bw.close();
        br.close();
    }
}
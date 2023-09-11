import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 반의 수 K가 주어진다.
        int K = Integer.parseInt(br.readLine());

        // 2. 각 반의 학생 수 N, 수학 성적이 주어진다.
        for(int i = 0 ; i < K ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[] score = new int[N];
            for (int j = 0; j < N; j++) {
                score[j] = Integer.parseInt(st.nextToken());
            }
            // score를 정렬한 뒤
            Arrays.sort(score);

            // 반의 번호를 출력하고
            bw.write("Class " + (i + 1) + "\n");
            // 최댓값, 최솟값, 점수 차이를 출력한다.
            bw.write("Max " + score[N - 1] + ", ");
            bw.write("Min " + score[0] + ", ");
            int diff = 0;
            for(int j = 0 ; j < N - 1 ; j++){
                if(score[j + 1] - score[j] > diff) diff = score[j + 1] - score[j];
            }
            bw.write("Largest gap " + diff + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
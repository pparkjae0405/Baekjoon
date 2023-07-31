import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 사람의 수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 돈을 인출하는데 걸리는 시간 P가 N만큼 주어진다.
        int[] P = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 배열 정렬
        Arrays.sort(P);

        // 4. 돈을 인출하는데 필요한 시간 합을 구하여 출력한다.
        int prev = 0;
        int sum = 0;
        for(int i = 0 ; i < N ; i++){
            sum += prev + P[i];

            prev += P[i];
        }
        bw.write(sum + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
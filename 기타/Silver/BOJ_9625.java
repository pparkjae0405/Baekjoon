import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. K가 주어진다.
        int K = Integer.parseInt(br.readLine());

        // 2. A의 개수 dpA, B의 개수 dpB를 선언하고 초기값을 저장한다.
        int[] dpA = new int[K + 1];
        int[] dpB = new int[K + 1];
        dpA[1] = 0;
        dpB[1] = 1;

        // 3. 2 ~ K까지 돌면서 dp값을 저장한다.
        for(int i = 2 ; i <= K ; i++){
            dpA[i] = dpB[i - 1];
            dpB[i] = dpA[i - 1] + dpB[i - 1];
        }

        // 3. K번 눌렀을 때 A와 B의 개수를 출력한다.
        bw.write(dpA[K] + " " + dpB[K]);

        bw.flush();
        bw.close();
        br.close();
    }
}
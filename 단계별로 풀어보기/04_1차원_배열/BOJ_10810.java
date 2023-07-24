import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 바구니의 개수 N과 공을 넣을 횟수 M을 받는다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 바구니 배열을 선언하고,
        int[] arr = new int[N];

        // 3. 조건에 맞게 공을 M번 넣는다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            // a ~ b번째 바구니에 k 공을 넣는다.
            for(int j = a-1 ; j < b ; j++){
                arr[j] = k;
            }
        }

        // 4. 공을 다 넣고난 뒤 바구니에 들어있는 공을 출력한다.
        for(int i = 0 ; i < N ; i++){
            bw.write(arr[i] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
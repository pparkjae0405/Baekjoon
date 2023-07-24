import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 바구니의 개수 N과 공을 바꿀 횟수 M을 받는다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 바구니 배열을 선언하고, 같은 번호의 공을 넣는다.
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = i+1;
        }

        // 3. 조건에 맞게 공을 M번 바꾼다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a와 b 바구니의 공을 바꾼다.
            int temp = arr[a-1];
            arr[a-1] = arr[b-1];
            arr[b-1] = temp;
        }

        // 4. 공을 다 바꾼 뒤 바구니에 들어있는 공을 출력한다.
        for(int i = 0 ; i < N ; i++){
            bw.write(arr[i] + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
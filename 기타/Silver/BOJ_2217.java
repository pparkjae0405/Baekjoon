import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N만큼 로프의 정보가 주어지고 정렬한다.
        long[] rope = new long[N];
        for(int i = 0 ; i < N ; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(rope);

        // 3. 맨 뒤의 로프부터 실행하여
        long count = 1;
        long max = 0;
        for(int i = N - 1 ; i >= 0 ; i--){
            // max와 로프의 개수 * 현재 로프의 길이 중 큰 값을 저장하고
            max = Math.max(max, count * rope[i]);
            // count를 증가한다.
            count++;
        }

        // 4. max를 출력한다.
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
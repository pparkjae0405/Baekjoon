import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 배열 arr을 선언하고, 값을 저장한다.
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3. M이 되는 경우의 수 count를 구해 출력한다.
        int count = 0;
        int start = 0;
        int end = 0;
        int len = arr.length;
        int sum = 0;
        while(true){
            // sum >= M일 경우 앞의 포인터를 뒤로 이동,
            if(sum >= M) sum -= arr[start++];
            // end >= len일 경우 종료,
            else if(end >= len) break;
            // sum < M일 경우 뒤의 포인터를 뒤로 이동,
            else sum += arr[end++];

            // sum이 M일 경우 count를 증가시킨다.
            if(sum == M) count++;
        }
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
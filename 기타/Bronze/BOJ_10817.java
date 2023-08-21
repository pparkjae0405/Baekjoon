import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 세 정수 A, B, C가 주어지고 정렬한 뒤
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[3];
        for(int i = 0 ; i < 3 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 2. 두 번째로 큰 정수를 출력한다.
        bw.write(arr[1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
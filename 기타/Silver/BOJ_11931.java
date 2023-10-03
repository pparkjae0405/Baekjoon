import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수의 개수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N만큼 수가 주어지고, 정렬한 뒤 뒤에서부터 출력한다.
        int[] arr = new int[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i = N - 1 ; i >= 0 ; i--){
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
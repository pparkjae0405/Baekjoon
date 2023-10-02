import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N만큼의 수가 주어지고 정렬한다.
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 3. arr을 돌면서
        int before = arr[0];
        bw.write(before + " ");
        for(int i = 1 ; i < N ; i++){
            // 전 값과 같지 않다면
            if(before != arr[i]){
                // 해당 수를 출력하고 before을 현재 값으로 갱신한다.
                bw.write(arr[i] + " ");
                before = arr[i];
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
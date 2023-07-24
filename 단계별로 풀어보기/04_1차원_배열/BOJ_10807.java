import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 정수 개수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N개만큼의 정수가 주어지고, 1차원 배열 arr에 저장한다.
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 찾을 v가 주어지고, v의 개수 count를 선언한다.
        int v = Integer.parseInt(br.readLine());
        int count = 0;

        // 4. 배열을 확인하여 v의 개수를 출력한다.
        for(int i = 0 ; i < N ; i++){
            if(arr[i] == v) count++;
        }

        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
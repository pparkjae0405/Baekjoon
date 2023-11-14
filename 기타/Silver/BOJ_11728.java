import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 두 배열의 크기가 주어지면
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        // arr의 크기를 설정한다.
        int[] arr = new int[a + b];

        // 2. 정보를 입력받은 뒤 arr에 저장하고
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < a ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = a ; i < a + b ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 정렬하여 출력한다.
        Arrays.sort(arr);
        for(int i = 0 ; i < a + b ; i++){
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
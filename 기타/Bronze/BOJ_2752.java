import java.io.*;
        import java.util.Arrays;
        import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 정수 3개가 주어진다.
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 3 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 정렬하고 출력한다.
        Arrays.sort(arr);
        for(int i = 0 ; i < 3 ; i++) {
            bw.write(arr[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
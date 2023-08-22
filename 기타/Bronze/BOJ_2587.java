import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 자연수 5개가 주어진다.
        int[] arr = new int[5];
        for(int i = 0 ; i < 5 ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 2. 배열을 정렬한 뒤 중앙값과 평균을 구해 출력한다.
        Arrays.sort(arr);
        int mid = arr[2];
        int avg = 0;
        for(int i = 0 ; i < 5 ; i++){
            avg += arr[i];
        }
        avg /= 5;
        bw.write(avg + "\n" + mid);

        bw.flush();
        bw.close();
        br.close();
    }
}
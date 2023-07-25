import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 난이도 의견 개수 n이 주어진다.
        int n = Integer.parseInt(br.readLine());

        // 2. 난이도 의견 n개가 주어지고 배열에 추가한 뒤 정렬한다.
        int[] arr = new int[n];
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // 3. 절사평균을 계산해 문제의 난이도를 계산한다.
        int trimmed = (int)Math.round(n * 0.15);
        double difficulty = 0;
        for(int i = trimmed ; i < n-trimmed ; i++){
            difficulty += arr[i];
        }

        bw.write((int)Math.round(difficulty/(n-trimmed*2)) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
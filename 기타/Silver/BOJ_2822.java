import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 8개의 줄에 참가자의 점수가 주어지고
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 1 ; i <= 8 ; i++){
            arr.add(new int[]{i, Integer.parseInt(br.readLine())});
        }
        // 점수 기준 내림차순으로 정렬한다.
        Collections.sort(arr, (o1, o2) -> o2[1] - o1[1]);

        // 2. 0 ~ 5까지의 점수를 계산하면서 문제를 저장하고
        int sum = 0;
        int[] order = new int[5];
        for(int i = 0 ; i < 5 ; i++){
            sum += arr.get(i)[1];
            order[i] = arr.get(i)[0];
        }
        // sum을 출력한다.
        bw.write(sum + "\n");

        // 3. 문제를 정렬하고 출력한다.
        Arrays.sort(order);
        for(int i = 0 ; i < 5 ; i++){
            bw.write(order[i] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
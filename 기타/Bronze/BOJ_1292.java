import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. A, B를 입력받고 구간합 sum을 선언한 뒤
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int sum = 0;

        // 2. 구간에 해당하는 값을 추가하고
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < 1000 ; i++) {
            for(int j = 0 ; j <= i ; j++) {
                list.add(i + 1);
            }
        }

        // 3. 구간에 해당하는 값들을 더해 출력한다.
        for(int i = A - 1 ; i <= B - 1 ; i++) {
            sum += list.get(i);
        }
        bw.write(sum + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
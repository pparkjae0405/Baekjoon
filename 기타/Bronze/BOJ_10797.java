import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 날짜의 일의 자리 숫자가 주어진다.
        int day = Integer.parseInt(br.readLine());

        // 2. 5대의 자동차 번호가 주어지고, 위반한 자동차의 개수를 출력한다.
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 5 ; i++){
            int car = Integer.parseInt(st.nextToken());
            if(car == day) count++;
        }
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
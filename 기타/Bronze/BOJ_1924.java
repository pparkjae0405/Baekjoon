import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. week와 day를 선언한다.
        String[] week = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // 2. x, y가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 3. 해당 날짜까지 몇일이 지났는지 계산하여
        int sum = 0;
        for(int i = 0 ; i < x - 1 ; i++){
            sum += day[i];
        }
        sum += y - 1;
        // 요일을 출력한다.
        bw.write(week[sum % 7] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
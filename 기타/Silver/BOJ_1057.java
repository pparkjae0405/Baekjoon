import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 참가자 수 N과 1라운드의 김지민, 임한수의 번호가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 2. a와 b가 만나는 라운드 수 count를 선언하고
        // 라운드 수만큼 반복하면서
        int count = 0;
        while(a != b){
            // count를 증가시킨다.
            a = (a / 2) + (a % 2);
            b = (b / 2) + (b % 2);
            count++;
        }
        // count를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
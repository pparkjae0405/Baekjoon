import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 현재 시작이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 2. 요리하는 데 필요한 시간이 초단위로 주어진다.
        int time = Integer.parseInt(br.readLine());

        // 3. 초, 분, 시 추가
        B += time / 60;
        C += time % 60;
        B += C / 60;
        C = C % 60;
        A += B / 60;
        B = B % 60;
        A = A % 24;

        bw.write(A + " " + B + " " + C);

        bw.flush();
        bw.close();
        br.close();
    }
}
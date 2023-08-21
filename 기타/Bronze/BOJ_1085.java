import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. x, y, w, h가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        // 2. x와 y의 한계선까지 가는 최솟값을 구한 뒤
        int minX = Math.min(x - 0, w - x);
        int minY = Math.min(y - 0, h - y);
        // 두 값중 최솟값을 출력한다.
        bw.write(Math.min(minX, minY) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
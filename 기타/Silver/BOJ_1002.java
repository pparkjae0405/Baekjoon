import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 정보가 주어진다.
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            // 정보에 따라 값을 출력한다.
            double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
            if(d == 0 && r1 == r2){
                bw.write(-1 + "\n");
            }else if(d > Math.abs(r2 - r1) && d < r1 + r2){
                bw.write(2 + "\n");
            }else if(Math.abs(r2 - r1) == d || r2 + r1 == d){
                bw.write(1 + "\n");
            }else if(r1 + r2 < d || Math.abs(r2 - r1) > d || d == 0){
                bw.write(0 + "\n");
            }

        }

        bw.flush();
        bw.close();
        br.close();
    }
}
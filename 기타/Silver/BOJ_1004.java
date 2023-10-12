import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 x1, y1, x2, y2, n이 주어지고
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine());

            // 3. n만큼 정보를 받아
            int count = 0;
            for(int j = 0 ; j < n ; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int nextX = Integer.parseInt(st.nextToken());
                int nextY = Integer.parseInt(st.nextToken());
                int nextR = Integer.parseInt(st.nextToken());

                // 진입 이탈 횟수를 찾은 뒤
                boolean check1 = false;
                boolean check2 = false;
                if(Math.pow(x1 - nextX, 2) + Math.pow(y1 - nextY, 2) <= Math.pow(nextR, 2)){
                    check1 = true;
                    count++;
                }
                if(Math.pow(x2 - nextX, 2) + Math.pow(y2 - nextY, 2) <= Math.pow(nextR, 2)){
                    check2 = true;
                    count++;
                }

                if(check1 == true && check2 == true){
                    count -= 2;
                }
            }
            // count를 출력한다.
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
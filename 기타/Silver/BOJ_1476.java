import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 목표치 E, S, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] target = new int[3];
        for(int i = 0 ; i < 3 ; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 1년의 E, S, M을 선언하고
        int[] now = {1, 1, 1};
        // E S M이 같아질 때 까지 돌면서
        int count = 1;
        while(true){
            if(now[0] == target[0] &&
                    now[1] == target[1] &&
                        now[2] == target[2]){
                break;
            }

            // 같지 않을 경우 1년을 추가하고
            count++;
            now[0]++;
            if(now[0] > 15) now[0] = 1;
            now[1]++;
            if(now[1] > 28) now[1] = 1;
            now[2]++;
            if(now[2] > 19) now[2] = 1;
        }

        // 3. 종료 시의 count를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
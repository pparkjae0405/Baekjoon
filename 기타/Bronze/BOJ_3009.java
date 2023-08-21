import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 세 점의 좌표가 주어진다.
        int[] x = new int[3];
        int[] y = new int[3];
        StringTokenizer st;
        for(int i = 0 ; i < 3 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        // 2. x, y좌표 중 다른 값을 출력한다.
        int lastX = 0;
        int lastY = 0;
        if(x[0] == x[1]){
            lastX = x[2];
        }else if(x[0] == x[2]){
            lastX = x[1];
        }else{
            lastX = x[0];
        }
        if(y[0] == y[1]){
            lastY = y[2];
        }else if(y[0] == y[2]){
            lastY = y[1];
        }else{
            lastY = y[0];
        }
        bw.write(lastX + " " + lastY + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
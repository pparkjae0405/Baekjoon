import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 최댓값 max, 그때의 행과 열 번호 a, b를 선언한다.
        int max = -1;
        int a = 0;
        int b = 0;

        // 2. 9x9크기의 2차원 배열이 주어지고
        StringTokenizer st;
        for(int i = 0 ; i < 9 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < 9 ; j++){
                // 최댓값과 그때의 행과 열 번호를 저장하고
                int value = Integer.parseInt(st.nextToken());
                if(value > max) {
                    max = value;
                    a = i+1;
                    b = j+1;
                }
            }
        }

        // 3. 결과를 출력한다.
        bw.write(max + "\n");
        bw.write(a + " " + b);

        bw.flush();
        br.close();
        bw.close();
    }
}
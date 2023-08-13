import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 두 정수 A, B가 0, 0이 나올 때 까지 반복
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if(A == 0 && B == 0) break;

            // A > B이면 Yes, 아니면 No 출력
            if(A > B){
                bw.write("Yes" + "\n");
            }else{
                bw.write("No" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
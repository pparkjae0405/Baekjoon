import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 문제의 정수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 4바이트마다 long이 하나씩 늘어난다고 생각하기 때문에
        int count = N/4;
        // N을 4로 나눈 개수만큼 long을 추가하고
        for(int i = 0 ; i < count ; i++){
            bw.write("long ");
        }
        // 3. 마지막에 int를 추가하여 출력한다.
        bw.write("int");

        bw.flush();
        br.close();
        bw.close();
    }
}
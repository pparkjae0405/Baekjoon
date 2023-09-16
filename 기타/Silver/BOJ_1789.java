import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 자연수 S가 주어진다.
        long S = Long.parseLong(br.readLine());

        // 2. 자연수의 합 sum, 더할 자연수 num, 자연수의 개수 N을 선언하고
        long sum = 0;
        long num = 1;
        int count = 0;
        // sum이 S를 넘을때 까지 반복하여
        while(sum <= S){
            // 자연수를 더하고 자연수와 N을 증가시키고
            sum += num;
            num++;
            count++;
        }

        // 3. count - 1를 출력한다.
        bw.write(count - 1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
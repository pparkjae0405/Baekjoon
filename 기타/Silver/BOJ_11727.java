import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. n이 주어지고, 초기값을 설정한다.
        int n = Integer.parseInt(br.readLine());
        int[] result = new int[1001];
        result[1] = 1;
        result[2] = 3;

        // 2. 점화식을 통해 입력받은 n까지의 경우의 수를 설정하는데
        for(int i = 3 ; i <= n ; i++){
            result[i] = result[i-1] + (result[i-2] * 2);

            // 값이 10,007을 넘는다면 10,007로 나눈 나머지로 설정한다.
            if(result[i] > 10007) result[i] = result[i] % 10007;
        }

        // 3. n번째 경우의 수를 10007로 나눈 나머지를 출력한다.
        bw.write(result[n]  + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
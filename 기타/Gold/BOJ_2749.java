import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 주어지는 N을 반복주기로 나눈 나머지로 저장한다.
        int repeat = 1500000;
        long N = Long.parseLong(br.readLine()) % repeat;

        // 2. 반복주기까지의 arr 배열을 선언하고 초기값을 설정한다.
        long[] arr = new long[repeat + 1];
        arr[0] = 0;
        arr[1] = 1;

        // 3. 2 ~ 반복주기까지의 피보나치 수를 설정하고,
        for(int i = 2 ; i <= repeat ; i++){
            arr[i] = (arr[i - 1] + arr[i - 2]) % 1000000;
        }

        // 4. 원하는 번째의 피보나치 수를 출력한다.
        bw.write(arr[(int)N] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
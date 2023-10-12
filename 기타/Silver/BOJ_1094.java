import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. X가 주어지고 count, 막대 arr, 합 sum을 선언한다.
        int X = Integer.parseInt(br.readLine());
        int count = 0;
        int[] arr = {64, 32, 16, 8, 4, 2, 1};
        int sum = 0;

        // 2. arr만큼 돌면서
        for(int i = 0 ; i < arr.length ; i++){
            // X보다 작을 경우 sum에 추가하고 count를 증가한다.
            if(arr[i] <= X){
                sum += arr[i];
                count++;
            }

            // sum이 X보다 크면 다시 뺀다.
            if(sum > X) {
                sum -= arr[i];
                count--;
            }

            // 같을 시 종료한다.
            if(sum == X) break;
        }

        // 3. count를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
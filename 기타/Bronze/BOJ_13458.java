import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 시험장의 개수 N, 각 시험장의 응시자 수 arr, B, C가 주어진다.
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 2. 감독관 수 count를 선언하고 각 시험장을 돌면서
        long count = 0;
        for(int i = 0 ; i < N ; i++){
            // 총 감독관을 한명씩 배치하고
            arr[i] -= B;
            count++;
            if(arr[i] <= 0){
                continue;
            }

            // 남은 인원을 감시하기 위해 필요한 부감독관의 수를 추가한다.
            count += arr[i] / C;
            if(arr[i] % C != 0){
                count++;
            }
        }

        // 3. count를 출력한다.
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
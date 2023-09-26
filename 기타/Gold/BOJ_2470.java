import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 용액의 수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 용액 정보를 arr에 저장하고 정렬한다.
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 3. 시작 지점 start, 끝 지점 end,
        int start = 0;
        int end = N - 1;
        // 두 지점의 값 result, 0에 가장 가까운 두 부분의 합 min을 선언한다.
        long[] result = new long[2];
        long min = Long.MAX_VALUE;

        // 4. 탐색을 통해
        while(start < end){
            // 현재 위치의 두 값의 합 sum을 선언하고
            long sum = arr[start] + arr[end];

            // min > 두 값의 합의 절대값일 경우
            if(min > Math.abs(sum)){
                // min값을 갱신하고 result를 저장한다.
                min = Math.abs(sum);
                result[0] = arr[start];
                result[1] = arr[end];
            }

            // sum이 0 이상일 경우 end를 앞으로 한 칸,
            if(sum >= 0){
                end--;
            }else{
                // 미만일 경우 start를 뒤로 한 칸 옮긴다.
                start++;
            }
        }

        // 5. 가장 작은 두 값을 출력한다.
        bw.write(result[0] + " " + result[1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
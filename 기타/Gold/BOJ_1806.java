import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수열의 길이 N, 비교할 수 S가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        // 2. 수열의 정보 arr가 주어지고 저장한다.
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 시작지점 start, end, 두 부분까지의 누적합 sum,
        // S 이상이 되는 수열 중 최소 개수 min을 선언하고
        int start = 0;
        int end = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        // 전부 돌 때까지 반복하여
        while(start <= N && end <= N){
            // S 미만이면 end를 한 칸 옮겨 증가시키고
            if(sum < S){
                sum += arr[end++];
            }else{
                // S 이상이면 min을 갱신하고
                min = Math.min(min, end - start);
                // start를 한 칸 옮겨 감소시킨다.
                sum -= arr[start++];
            }
        }

        // 4. min이 INF면 0, 이외에는 해당 값을 출력한다.
        if(min == Integer.MAX_VALUE) bw.write(0 + "\n");
        else bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
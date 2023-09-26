import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어지고 최대 점수, 최소 점수 배열을 선언한다.
        int N = Integer.parseInt(br.readLine());
        int[] max = new int[3];
        int[] min = new int[3];

        // 2. N만큼 정보가 주어지는데
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");

            // 세 수 a, b, c가 주어지고
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // i가 0이면 초기값을 설정하고
            if(i == 0){
                max[0] = min[0] = a;
                max[1] = min[1] = b;
                max[2] = min[2] = c;
            }else{
                // 이외에는 최댓값을 구하고
                int first = max[0];
                int last = max[2];
                max[0] = Math.max(max[0], max[1]) + a;
                max[2] = Math.max(max[1], max[2]) + c;
                max[1] = Math.max(Math.max(first, max[1]), last) + b;

                // 최솟값을 구해
                first = min[0];
                last = min[2];
                min[0] = Math.min(min[0], min[1]) + a;
                min[2] = Math.min(min[1], min[2]) + c;
                min[1] = Math.min(Math.min(first, min[1]), last) + b;
            }
        }

        // 3. 결과를 출력한다.
        bw.write(Math.max(max[0], Math.max(max[1], max[2])) + " ");
        bw.write(Math.min(min[0], Math.min(min[1], min[2])) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
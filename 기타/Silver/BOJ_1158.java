import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N, K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2. 큐를 선언하고, 1 ~ N까지의 수를 저장한다.
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1 ; i <= N ; i++){
            queue.add(i);
        }

        // 3. N만큼 돌면서
        bw.write("<");
        for(int i = 0 ; i < N ; i++){
            // 큐에서 수를 K번 빼낸 뒤
            int value = 0;
            for(int j = 0 ; j < K ; j++){
                value = queue.poll();

                // K번째 수가 아닐 경우 뒤에 저장하고
                if(j != K - 1) {
                    queue.add(value);
                }
            }

            // K번째 수를 양식에 맞춰 출력한다.
            if(i == N - 1){
                bw.write(value + ">");
            }else{
                bw.write(value + ", ");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
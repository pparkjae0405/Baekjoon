import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 카드를 저장할 큐를 선언한다.
        Queue<Integer> queue = new LinkedList<>();

        // 2. N이 주어지고, 카드정보를 큐에 추가한다.
        int N = Integer.parseInt(br.readLine());
        for(int i = 1 ; i <= N ; i++){
            queue.add(i);
        }

        // 3. 주어진 행동을 수행한다.
        for(int i = 0 ; i < N - 1 ; i++){
            // 맨 위의 카드를 제거하고 출력한다.
            bw.write(queue.poll() + " ");

            // 제일 위에 있는 카드를 맨 밑으로 옮긴다.
            queue.add(queue.poll());
        }
        // 종료 시 남아있는 카드를 출력한다.
        bw.write(queue.poll() + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
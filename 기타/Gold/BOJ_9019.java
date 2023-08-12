import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스의 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 초기값 A, 최종값 B가 주어지고,
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            // 3. 정답 배열 answer, 방문여부 visited, bfs를 위한 큐를 선언하고
            String[] answer = new String[10000];
            boolean[] visited = new boolean[10000];
            Queue<Integer> queue = new LinkedList<>();

            // answer의 값을 공백으로 초기화한 뒤
            for(int j = 0 ; j < answer.length ; j++){
                answer[j] = "";
            }

            // 4. 초기값을 큐에 넣은 뒤 방문처리하고
            queue.add(A);
            visited[A] = true;

            // 최종값 B를 방문할때까지 반복하여
            while(!visited[B]){
                // 값을 큐에서 빼내
                int now = queue.poll();

                // D는 now에 2를 곱하고 10000으로 나눈 나머지,
                // S는 now가 0이라면 9999로 만들고 그외에는 now - 1,
                // L은 각 자리수를 왼쪽으로 한 칸씩 이동,
                // R은 각 자리수를 오른쪽으로 한 칸씩 이동,
                int D = (now * 2) % 10000;
                int S = (now == 0) ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                // 명령어 D, S, L, R를 수행한 결과가 방문하지 않았다면
                // 해당 값을 방문처리하고 큐에 추가한 뒤
                // 정답 배열값에 해당 명령어를 추가한다.
                if(!visited[D]){
                    visited[D] = true;
                    queue.add(D);
                    answer[D] = answer[now] + "D";
                }
                if(!visited[S]){
                    visited[S] = true;
                    queue.add(S);
                    answer[S] = answer[now] + "S";
                }
                if(!visited[L]){
                    visited[L] = true;
                    queue.add(L);
                    answer[L] = answer[now] + "L";
                }
                if(!visited[R]){
                    visited[R] = true;
                    queue.add(R);
                    answer[R] = answer[now] + "R";
                }
            }


            // D, S, L, R를 반복하여 A가 B가 될 때까지 수행한 최소한의 명령어를 출력한다.
            bw.write(answer[B] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 수빈이의 위치 N, 동생의 위치 K,
    static int N, K;
    // x축을 표현할 line, 이동 방향 dx,
    static int[] line;
    static int[] dx = {-1, 1, 2};
    // bfs를 위한 큐, 경우의 수 count를 선언한다.
    static Queue<Integer> queue = new LinkedList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 3. line의 크기를 설정하고
        line = new int[100001];

        // 4. bfs를 호출해 최소 시간과 경우의 수를 출력한다.
        bfs(N);
        bw.write(line[K] - 1 + "\n" + count);

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        // 시작 위치를 1로 설정하고 큐에 추가한다.
        line[start] = 1;
        queue.add(start);

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 위치를 가져와
            int now = queue.poll();
            // 동생을 만날 경우 count 증가,
            if(now == K) count++;

            // 이외에는 다음 위치를 탐색하는데
            for(int i = 0 ; i < 3 ; i++){
                int next = 0;
                if(i == 2) {
                    next = now * dx[i];
                }else {
                    next = now + dx[i];
                }

                // next가 x축 안에 있고
                if(next >= 0 && next <= 100000){
                    // 방문한 적이 있고 현재 위치에서 동작을 수행한 것 보다
                    // 더 적은 동작을 수행하여 해당 위치로 갈 수 있다면 무시하고
                    if(line[next] != 0 && line[next] < line[now] + 1) continue;

                    // 이외에는 해당 위치를 갱신하고 queue에 추가한다.
                    line[next] = line[now] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
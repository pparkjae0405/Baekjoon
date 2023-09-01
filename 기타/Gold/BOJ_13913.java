import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    // 1. 수빈이의 위치 N, 동생의 위치 K,
    static int N, K;
    // x축을 표현할 line, 방문 여부 visited, 이전 위치를 저장할 before, 이동 방향 dx,
    static int[] line;
    static boolean[] visited;
    static int[] before;
    static int[] dx = {-1, 1, 2};
    // bfs를 위한 큐, 경로를 출력할 스택을 선언한다.
    static Queue<Integer> queue = new LinkedList<>();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 3. line, visited, before의 크기를 설정하고
        line = new int[100001];
        visited = new boolean[100001];
        before = new int[100001];

        // 4. bfs를 호출해 최소 시간과 경로를 출력한다.
        bfs(N);
        bw.write(line[K] - 1 + "\n");
        while(!stack.isEmpty()){
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        // 시작 위치를 1로 설정하고 방문처리한 뒤 큐에 추가한다.
        line[start] = 1;
        visited[start] = true;
        queue.add(start);

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 위치를 가져와 다음 위치를 탐색하는데
            int now = queue.poll();

            for(int i = 0 ; i < 3 ; i++){
                int next = 0;
                if(i == 2) {
                    next = now * dx[i];
                }else {
                    next = now + dx[i];
                }

                // next가 x축 안에 있고
                if(next >= 0 && next <= 100000){
                    // 방문한 적이 없다면
                    if(!visited[next]){
                        // 방문처리, 거리를 추가하여 저장 및 큐에 추가하고
                        visited[next] = true;
                        line[next] = line[now] + 1;
                        queue.add(next);

                        // 이전 위치를 저장한다.
                        before[next] = now;
                    }
                }
            }

            // 동생의 위치에 도착했다면
            if(visited[K]){
                // 현재 인덱스를 K로 설정하고
                int idx = K;

                // 부모 노드를 따라가며 경로를 스택에 저장한다.
                while(idx != N){
                    stack.push(idx);
                    idx = before[idx];
                }
                // 마지막으로 시작 노드를 추가하고 종료한다.
                stack.push(idx);
                break;
            }
        }
    }
}
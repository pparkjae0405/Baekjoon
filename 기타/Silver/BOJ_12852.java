import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    // 1. 자연수 N,
    static int N;
    // 1 ~ N까지의 배열 arr, 방문 여부 visited,
    static int[] arr;
    static boolean[] visited;
    // bfs를 위한 큐, 이전 위치 before를 선언한다.
    static Queue<Integer> queue = new LinkedList<>();
    static int[] before;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어진다.
        N = Integer.parseInt(br.readLine());
        // N이 1이면 0, 1을 출력하고 종료한다.
        if(N == 1){
            bw.write(0 + "\n");
            bw.write(1 + "\n");
            bw.flush();
            bw.close();
            br.close();
            return;
        }

        // 3. arr, visited, before의 크기를 설정하고
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        before = new int[N + 1];
        // bfs를 호출해 최솟값을 출력한다.
        bfs(N);
        bw.write(arr[1] + "\n");

        // 4. N을 1로 만드는 방법을 구해 출력한다.
        Stack<Integer> stack = new Stack<>();
        stack.add(1);
        while(true){
            int pre = stack.peek();
            int next = before[pre];
            stack.add(next);
            if(next == N) break;
        }
        for(int i = 0 ; i <= arr[1] ; i++){
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        // 시작 위치를 방문처리하고 큐에 추가한다.
        visited[start] = true;
        queue.add(start);

        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 현재 정보를 가져와
            int now = queue.poll();
            // 현재 위치가 1일 경우 종료하고
            if(now == 1) return;

            // 이외에는 3가지 연산을 수행하는데
            if(now % 3 == 0) {
                // 3으로 나누어 떨어질 경우 3으로 나누고
                int temp = now / 3;
                // 방문하지 않았을 경우
                if(!visited[temp]) {
                    // 방문처리 + 횟수 저장 + 이전위치 저장 + 큐에 추가한다.
                    visited[temp] = true;
                    arr[temp] = arr[now] + 1;
                    before[temp] = now;
                    queue.add(temp);
                }
            }
            if(now % 2 == 0){
                // 2로 나누어 떨어질 경우 2로 나누고
                int temp = now / 2;
                // 방문하지 않았을 경우
                if(!visited[temp]) {
                    // 방문처리 + 횟수 저장 + 이전위치 저장 + 큐에 추가한다.
                    visited[temp] = true;
                    arr[temp] = arr[now] + 1;
                    before[temp] = now;
                    queue.add(temp);
                }
            }

            // 1로 뺀 곳이 방문하지 않았을 경우
            int temp = now - 1;
            if(!visited[temp]) {
                // 방문처리 + 횟수 저장 + 이전위치 저장 + 큐에 추가한다.
                visited[temp] = true;
                arr[temp] = arr[now] + 1;
                before[temp] = now;
                queue.add(temp);
            }
        }
    }
}
import java.io.*;
import java.util.*;

public class Main {
    // 1. 정점의 수 N, 간선의 수 M, 시작 정점 R,
    static int N, M, R;
    // 연결 정보 graph, 방문 여부 visited
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    // bfs를 위한 큐, 방문 순서 order를 선언한다.
    static Queue<Integer> queue = new LinkedList<>();
    static int[] order;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M, R이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        // graph, visited, order의 크기를 설정한다.
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        // 3. M만큼 연결정보를 저장하고 정렬한다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }
        for(int i = 1 ; i <= N ; i++){
            Collections.sort(graph[i]);
        }

        // 4. bfs를 호출한 결과를 출력한다.
        bfs(R);
        for(int i = 1 ; i <= N ; i++){
            bw.write(order[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        // 시작 위치를 방문처리하고 큐에 추가한다.
        visited[start] = true;
        queue.add(start);

        // 큐가 빌 때 까지
        int count = 1;
        while(!queue.isEmpty()){
            // 현재 정보를 가져와 방문 순서를 저장하고
            int now = queue.poll();
            order[now] = count++;

            // 연결된 값을 탐색하여
            for(int next : graph[now]){
                // 방문하지 않은 곳이 있다면
                if(!visited[next]){
                    // 방문처리하고 큐에 추가한다.
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    // 1. 노드 정보 리스트 graph, 노드 방문 여부 visited, 최단 거리 d 선언

    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        다익스트라 알고리즘
        특정한 하나의 정점에서 모든 정점으로의 최단경로를 구하는 알고리즘
        1. 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        2. 출발 노드를 우선순위 큐에 추가하고 d[출발 노드]를 0으로 초기화한다.
        3. pq의 제일 위에 있는 노드를 빼내 방문하지 않았을 경우 방문처리하고
        4. 해당 노드와 연결된 Node를 가져와 방문하지 않았고 최단거리 > 현재 노드를 경유하여 가는 경우일 경우 최단거리를 갱신하고 pq에 추가한다.
        5. 3~4를 pq가 빌 때 까지 반복한다.
        */

        // 2. 정점의 개수 V와 간선의 개수 E, 시작 정점의 번호 K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        // 3. graph, visited, d의 크기를 설정하고
        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        d = new int[V + 1];

        // graph를 초기화하고 d를 INF으로 저장한다.
        for(int i = 1 ; i <= V ; i++){
            graph[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }

        // 4. E개의 시작노드 u, 도착 노드 v, 가중치 w가 주어지고,
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            // graph에 저장한다.
            graph[u].add(new Node(v, w));
        }

        // 5. 다익스트라 알고리즘을 수행한 결과를 출력한다.
        dijkstra(K);
        for(int i = 1 ; i <= V ; i++){
            if(d[i] == Integer.MAX_VALUE) bw.write("INF" + "\n");
            else bw.write(d[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        // (연결된 간선 v, 간선까지의 거리 cost)
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void dijkstra(int start) {
        // 가중치 기준 오름차순으로 우선순위 큐를 선언하고
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // (시작 노드, 0)을 추가한 뒤 d[start]를 0으로 바꿔준 뒤
        pq.add(new Node(start, 0));
        d[start] = 0;

        // pq가 빌 때까지 반복하여
        while (!pq.isEmpty()) {
            // pq의 제일 위에 있는 노드를 빼내 방문하지 않았을 경우 방문처리하고
            Node now = pq.poll();
            if (!visited[now.v]) {
                visited[now.v] = true;
            }

            // 현재 노드와 연결된 (v, cost)를 next로 가져와
            for (Node next : graph[now.v]) {
                // next가 방문하지 않았고, 최단거리가 현재 노드를 경유하여 가는 경우가 더 짧을 경우
                if (!visited[next.v] && d[next.v] > now.cost + next.cost) {
                    // 최단거리를 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, d[next.v]));
                }
            }
        }
    }
}
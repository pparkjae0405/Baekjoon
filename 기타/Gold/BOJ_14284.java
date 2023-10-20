import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 정점의 개수 n, 간선 수 m,
    static int n, m;
    // 정점 연결 정보 graph, 정점 방문 여부 visited,
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    // 최단 거리 d를 선언한다.
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. n, m이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // 3. graph, visited, d의 크기를 설정하고
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        d = new int[n + 1];
        // graph를 초기화하면서 d를 INF로 저장한다.
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }

        // 4. m만큼 정보가 주어지고
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // graph에 저장한다.
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        // 5. s와 t가 주어지고
        st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        // 다익스트라 알고리즘을 호출해 s에서 t로 가는 최솟값을 출력한다.
        dijkstra(s);
        bw.write(d[t] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void dijkstra(int start){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 위치를 0으로 저장하고 pq에 추가한다.
        d[start] = 0;
        pq.add(new Node(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 정보를 가져와
            Node now = pq.poll();
            // 방문하지 않았을 경우 방문처리하고
            if(!visited[now.v]) visited[now.v] = true;

            // 연결된 노드를 가져와
            for(Node next : graph[now.v]){
                // 방문하지 않았고
                // 현재 최솟값 > 현재 가중치 + 다음 가중치라면
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // 최솟값을 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, d[next.v]));
                }
            }
        }
    }
}
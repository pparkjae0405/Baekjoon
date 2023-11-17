import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 정점의 개수 V, 간선의 개수 E,
    static int V, E;
    // 연결 정보 graph, 정점 방문 여부 visited,
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    // 최단 경로 d를 선언한다.
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. V, E가 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        // graph, visited, d의 크기를 설정한 뒤
        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        d = new int[V + 1];
        // graph를 초기화하면서 d를 INF로 저장한다.
        for(int i = 1 ; i <= V ; i++){
            graph[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }

        // 3. 시작 정점 K가 주어지고
        int K = Integer.parseInt(br.readLine());
        // E만큼의 방향그래프 정보를 graph에 저장한다.
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
        }

        // 4. 다익스트라 알고리즘을 호출한 결과를 출력한다.
        dijkstra(K);
        for(int i = 1 ; i <= V ; i++){
            if(d[i] == Integer.MAX_VALUE){
                bw.write("INF" + "\n");
            }else{
                bw.write(d[i] + "\n");
            }
        }

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

        // 시작 위치를 0으로 설정하고 pq에 추가한다.
        d[start] = 0;
        pq.add(new Node(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 정보를 가져와
            Node now = pq.poll();
            // 방문하지 않았을 경우 방문처리하고
            if(!visited[now.v]) visited[now.v] = true;

            // 연결 정보를 가져와
            for(Node next : graph[now.v]){
                // 방문하지 않았고
                // 다음 최단거리 > 현재 가중치 + 다음 가중치일 경우
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // 최단거리를 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, d[next.v]));
                }
            }
        }
    }
}
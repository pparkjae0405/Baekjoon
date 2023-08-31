import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    // 1. 정점의 개수 N, 간선의 개수 E,
    static int N, E;
    // 연결 정보를 저장할 graph, 정점 방문 여부 visited,
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    // 최단거리 d, 최대 길이 INF를 선언한다.
    static int[] d;
    static int INF = 200000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, E가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 3. graph의 크기를 설정하고 초기화한다.
        graph = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        // 4. 연결 정보(출발 정점, 도착 정점, 길이)가 주어지고
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            // 그래프에 저장한다.
            graph[start].add(new Node(end, len));
            graph[end].add(new Node(start, len));
        }

        // 5. 반드시 거쳐야 하는 정점 a, b가 주어지고
        st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        // 1 -> a -> b -> N으로 가는 경우와
        int case1 = 0;
        case1 += dijkstra(1, a);
        case1 += dijkstra(a, b);
        case1 += dijkstra(b, N);

        // 1 -> b -> a -> N으로 가는 경우를 탐색하여
        int case2 = 0;
        case2 += dijkstra(1, b);
        case2 += dijkstra(b, a);
        case2 += dijkstra(a, N);

        // 최단경로가 없으면 -1,
        if(case1 >= INF && case2 >= INF){
            bw.write(-1 + "\n");
        }else{
            // 존재하면 case1, case2 중 최솟값을 출력한다.
            bw.write(Math.min(case1, case2) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        // 연결된 노드, 가중치
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int dijkstra(int start, int end){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // visited와 d의 크기를 설정하고 d를 INF로 저장한다.
        visited = new boolean[N + 1];
        d = new int[N + 1];
        for(int i = 1 ; i <= N ; i++){
            d[i] = INF;
        }

        // 시작 노드를 pq에 추가하고 최단거리를 0으로 저장한다.
        pq.add(new Node(start, 0));
        d[start] = 0;

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 노드를 가져와
            Node now = pq.poll();
            // 방문하지 않았을 경우 방문처리하고
            if(!visited[now.v]) visited[now.v] = true;

            // 연결된 노드들을 가져와
            for(Node next : graph[now.v]){
                // 방문하지 않았고 연결된 노드끼리의 최단거리 > 현재 노드를 경유하여 가는 경우일 경우
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // 최단거리를 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, d[next.v]));
                }
            }
        }

        // 탐색이 종료되면 최단거리를 리턴한다.
        return d[end];
    }
}
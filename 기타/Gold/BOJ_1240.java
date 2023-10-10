import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 노드의 개수 N, 연결 정보 개수 M,
    static int N, M;
    // 노드 정보 graph, 노드 방문 여부 visited,
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    // 최단 거리 d를 선언한다.
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // graph를 초기화한다.
        graph = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        // 3. N - 1만큼 정보가 주어지고
        for(int i = 0 ; i < N - 1 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // graph에 저장한다.
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        // 4. M만큼 알고싶은 정보가 주어지고
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // visited, d의 크기를 설정 및 d를 INF로 저장한 뒤
            visited = new boolean[N + 1];
            d = new int[N + 1];
            for(int j = 1 ; j <= N ; j++){
                d[j] = Integer.MAX_VALUE;
            }

            // 다익스트라 알고리즘을 호출해
            dijkstra(start);
            // d[end]를 출력한다.
            bw.write(d[end] + "\n");
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
            // 현재 정보를 가져와 방문하지 않았을 경우 방문처리하고
            Node now = pq.poll();
            if(!visited[now.v]) visited[now.v] = true;

            // 연결된 노드를 탐색하면서
            for(Node next : graph[now.v]){
                // 방문하지 않았고
                // 다음 최솟값 > 현재값 + 다음값일 경우
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // d를 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, d[next.v]));
                }
            }
        }
    }
}
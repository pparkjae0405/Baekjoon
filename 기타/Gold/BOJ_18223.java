import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 정점의 개수 V, 간선의 개수 E, 건우의 위치 P,
    static int V, E, P;
    // 지도 정보 info, 정점 방문여부 visited,
    static ArrayList<Node>[] info;
    static boolean[] visited;
    // 최단 거리 d를 선언한다.
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. V, E, P가 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        // info, visited, d의 크기를 설정한 뒤
        info = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        d = new int[V + 1];
        // info를 초기화하면서 d를 INF로 저장한다.
        for(int i = 1 ; i <= V ; i++){
            info[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }

        // 3. 간선 정보가 주어지고, info에 저장한다.
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            info[start].add(new Node(end, cost));
            info[end].add(new Node(start, cost));
        }

        // 4. 다익스트라 알고리즘을 호출하여
        dijkstra(1);
        // 직행 거리와 건우까지의 거리를 찾고
        int standard = d[V];
        int layover = d[P];

        // visited와 d를 초기화한 뒤 다익스트라 알고리즘을 호출하여
        visited = new boolean[V + 1];
        d = new int[V + 1];
        for(int i = 1 ; i <= V ; i++){
            d[i] = Integer.MAX_VALUE;
        }
        dijkstra(P);

        // 건우위치부터 마산까지의 최단거리를 찾은 뒤
        layover += d[V];
        // 두 값을 비교하여 결과를 출력한다.
        if(standard == layover){
            bw.write("SAVE HIM" + "\n");
        }else{
            bw.write("GOOD BYE" + "\n");
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

            // 연결된 노드들을 탐색하여
            for(Node next : info[now.v]){
                // 방문하지 않았고
                // 다음 최단거리 > 현재 가중치 + 다음 가중치일 경우
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // 현재 최단거리를 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, d[next.v]));
                }
            }
        }
    }
}
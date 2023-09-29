import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    // 1. 정점의 개수 N, 간선의 개수 M,
    static int N, M;
    // 그래프를 표현할 graph, 노드 방문 여부 visited,
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    // 경로 저장 path, 최단 거리 d를 선언한다.
    static int[] path;
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. graph의 크기를 설정하고 초기화한다.
        graph = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        // 4. graph 정보(출발 정점 u, 도착 정점 v, 가중치 w)를 저장한다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
            graph[v].add(new Node(u, w));
        }

        // 5. 정점의 개수만큼 돌면서
        for(int i = 1 ; i <= N ; i++){
            // visited, path, d를 초기화하고 d를 INF로 저장한 뒤
            visited = new boolean[N + 1];
            path = new int[N + 1];
            d = new int[N + 1];
            Arrays.fill(d, Integer.MAX_VALUE);

            // 1 ~ N부터 다른 노드들까지의 최소 거리와 경로를 저장하고
            dijkstra(i);

            // 저장한 최단 경로를 출력한다.
            for(int j = 1 ; j <= N ; j++){
                if(i == j){
                    bw.write("-" + " ");
                }else{
                    bw.write(find(j, i) + " ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        // 연결된 간선, 간선까지의 거리
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

        // 시작 위치의 거리를 0으로 설정하고 pq에 추가한다.
        d[start] = 0;
        pq.add(new Node(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 노드를 가져와
            Node now = pq.poll();
            // 방문하지 않았을 경우 방문처리하고
            if(!visited[now.v]) visited[now.v] = true;

            // 현재 노드와 연결된 노드들을 가져와
            for(Node next : graph[now.v]){
                // 해당 노드가 방문하지 않았고
                // 최단거리 > 현재 노드 + 다음 노드 일 경우
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // 최단거리를 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    path[next.v] = now.v;
                    pq.add(new Node(next.v, d[next.v]));
                }
            }
        }
    }

    static int find(int j, int i){
        // 부모를 찾아 리턴한다.
        if(path[j] == i) return j;
        return find(path[j], i);
    }
}
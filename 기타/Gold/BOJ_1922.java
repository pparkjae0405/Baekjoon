import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 컴퓨터의 수 N, 선의 개수 M,
    static int N, M;
    // 컴퓨터 정보 graph, 방문 여부 visited,
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    // 최소 비용 price를 선언한다.
    static int price = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        // graph, visited의 크기를 설정한 뒤
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        // graph를 초기화한다.
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        // 3. graph 정보를 저장하고
        StringTokenizer st;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }
        // 프림 알고리즘을 호출한 결과를 출력한다.
        prim(1);
        bw.write(price + "\n");

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

    static void prim(int start){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 위치를 pq에 추가한다.
        pq.add(new Node(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 위치를 가져와
            Node now = pq.poll();
            // 방문했을 경우 무시,
            if(visited[now.v]) continue;

            // 방문하지 않았을 경우 방문처리하고
            // 현재 가중치를 추가한 뒤
            visited[now.v] = true;
            price += now.cost;
            // 연결된 노드를 탐색하여
            for(Node next : graph[now.v]){
                // 방문하지 않았을 경우 pq에 추가한다.
                if(!visited[next.v]) pq.add(next);
            }
        }
    }
}
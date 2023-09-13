import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    // 1. 컴퓨터의 수 N, 연결할 수 있는 선의 수 M,
    static int N, M;
    // 컴퓨터 정보를 저장할 graph, 컴퓨터 방문 여부 visited,
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    // 최소비용 price를 선언한다.
    static int price = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        최소 신장 트리(MST) - 프림 알고리즘
        노드를 하나씩 늘려가면서 MST를 완성한다.
        1. 우선순위 큐 pq를 선언하고 시작 위치와 가중치를 추가한다.
        2. 현재 위치를 가져와 방문한 적이 있을 경우 무시,
           방문한 적이 없을 경우 방문처리하고 현재 가중치를 추가한 뒤
           연결된 노드들을 가져와 방문하지 않았을 경우 pq에 추가한다.
        3. 2를 pq가 빌 때 까지 반복한다.
         */

        // 2. N, M이 주어진다.
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        // 3. graph, visited의 크기를 설정한 뒤
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        // graph를 초기화하고
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        // 4. 출발 노드, 도착 노드, 가중치 정보를
        StringTokenizer st;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 가중치 기준 오름차순으로 graph에 저장한다.
            graph[start].add(new Node(end, cost));
            graph[end].add(new Node(start, cost));
        }

        // 5. 프림 알고리즘을 수행한 결과를 출력한다.
        prim(1);
        bw.write(price + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node>{
        // 도착 노드, 노드까지의 거리
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static void prim(int start){
        // 우선순위 큐 pq를 선언하고 시작 위치와 가중치를 추가한다.
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 위치를 가져와 방문한 적이 있을 경우 무시,
            Node now = pq.poll();
            if(visited[now.v]) continue;

            // 방문한 적이 없을 경우 방문처리하고 현재 가중치를 추가한 뒤
            visited[now.v] = true;
            price += now.cost;
            // 연결된 노드들을 가져와
            for(Node next : graph[now.v]){
                // 방문하지 않았을 경우 pq에 추가한다.
                if(!visited[next.v]) pq.add(next);
            }
        }
    }
}
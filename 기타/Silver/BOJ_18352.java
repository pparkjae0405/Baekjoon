import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    // 1. 도시의 개수 N, 도로의 개수 M,
    static int N, M;
    // 도시 정보 city, 도시 방문 여부 visited,
    static ArrayList<Node>[] city;
    static boolean[] visited;
    // 최단 거리 d를 선언한다.
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M, 거리 정보 K, 출발 도시의 번호 X가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        // 3. city, visited, d의 크기를 설정하고
        city = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        d = new int[N + 1];
        // city를 초기화하면어 d를 INF로 설정한다.
        for(int i = 1 ; i <= N ; i++){
            city[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }

        // 4. M만큼 city 정보를 받아 저장한다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            city[start].add(new Node(end, 1));
        }

        // 5. X부터 다익스트라 알고리즘을 호출한 뒤
        dijkstra(X);

        // d가 K인 경우 출력하고
        int count = 0;
        for(int i = 1 ; i <= N ; i++){
            if(d[i] == K){
                bw.write(i + "\n");
                count++;
            }
        }
        if(count == 0) {
            // 다 돌았는데도 K가 없다면 -1을 출력한다.
            bw.write(-1 + "\n");
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
            for(Node next : city[now.v]){
                // 해당 노드가 방문하지 않았고
                // 최단거리 > 현재 가중치 + 다음 가중치일 경우
                if(!visited[next.v] && d[next.v] > now.cost + next.cost) {
                    // 최단거리를 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    pq.add(new Node(next.v, d[next.v]));
                }
            }

        }
    }
}
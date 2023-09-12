import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    // 1. 도시의 개수 n, 버스의 개수 m,
    static int n, m;
    // 버스 정보를 표현할 graph, 방문 여부 visited,
    static ArrayList<City>[] graph;
    static boolean[] visited;
    // 최단 거리 d, 경로를 저장할 route를 선언한다.
    static int[] d;
    static int[] route;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. n, m이 주어진다.
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        // 3. graph, visited, d, route의 크기를 설정하고
        graph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        d = new int[n + 1];
        route = new int[n + 1];
        // graph를 초기화하고 d를 INF로 저장한다.
        for(int i = 1 ; i <= n ; i++){
            graph[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }

        // 4. 출발 도시, 도착 도시, 버스 비용 정보가 주어지면
        StringTokenizer st;
        for(int i = 0 ; i < m ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            // graph에 추가한다.
            graph[start].add(new City(end, price));
        }

        // 5. 출발도시와 도착 도시가 주어지면
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        // 다익스트라 알고리즘을 호출하여 도착지점까지의 최단거리를 탐색한다.
        dijkstra(start);

        // 6. 출발 도시 ~ 도착 도시까지의 최단거리를 출력하고
        bw.write(d[end] + "\n");
        // 경로를 탐색하여
        Stack<Integer> stack = new Stack<>();
        stack.push(end);
        while(route[end] != 0) {
            stack.push(route[end]);
            end = route[end];
        }
        // 경로의 개수와 경로를 출력한다.
        bw.write(stack.size() + "\n");
        while(!stack.isEmpty()){
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static class City{
        // 연결된 노드, 노드까지의 거리
        int v;
        int cost;

        public City(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void dijkstra(int start){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<City> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // d[start]를 0으로 설정하고 pq에 추가한다.
        d[start] = 0;
        pq.add(new City(start, 0));

        // pq가 빌 때 까지 반복하여
        while(!pq.isEmpty()){
            // 현재 위치를 가져와 방문하지 않았을 경우 방문처리하고
            City now = pq.poll();
            if(!visited[now.v]) visited[now.v] = true;
            else continue;

            // 현재 노드와 연결된 (v, cost)를 가져와
            for(City next : graph[now.v]){
                // next가 방문하지 않았고 최단거리가 현재 노드를 경유하여 가는 경우가 더 짧을 경우
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // 최단거리를 갱신하고 pq에 추가한 뒤
                    d[next.v] = now.cost + next.cost;
                    pq.add(new City(next.v, d[next.v]));

                    // 경로를 저장한다.
                    route[next.v] = now.v;
                }
            }
        }
    }
}
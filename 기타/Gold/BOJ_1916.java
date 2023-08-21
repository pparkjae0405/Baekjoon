import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    // 1. 도시 정보 리스트 graph, 최소비용 price 선언
    static ArrayList<City>[] graph;
    static int[] price;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        다익스트라 알고리즘
        특정한 하나의 정점에서 모든 정점으로의 최단경로를 구하는 알고리즘
        1. 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        2. 출발 노드를 우선순위 큐에 추가하고 d[출발 노드]를 0으로 초기화한다.
        3. pq의 제일 위에 있는 노드를 빼내 방문하지 않았을 경우 방문처리하고
        4. 해당 노드와 연결된 Node를 가져와 방문하지 않았고 최단거리 > 현재 노드를 경유하여 가는 경우일 경우 최단거리를 갱신하고 pq에 추가한다.
        5. 3~4를 pq가 빌 때 까지 반복한다.
        */

        // 2. 도시의 개수 N, 버스의 개수 M이 주어진다.
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        // 3. graph, price의 크기를 설정하고
        graph = new ArrayList[N + 1];
        price = new int[N + 1];
        // 그래프를 초기화하고 price를 INF로 저장한다.
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
            price[i] = Integer.MAX_VALUE;
        }

        // 4. M개만큼 출발도시 a, 도착도시 b, 버스비용 c가 주어지고
        StringTokenizer st;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 그래프에 저장한다.
            graph[a].add(new City(b, c));
        }

        // 5. 구하고자 하는 출발도시와 도착도시가 주어지고,
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        // 다익스트라 알고리즘을 수행한 결과를 출력한다.
        dijkstra(start);
        bw.write(price[end] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class City{
        // 연결된 간선, 간선까지의 비용
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
        // 출발 노드를 우선순위 큐에 추가하고 d[출발 노드]를 0으로 초기화한다.
        pq.add(new City(start, 0));
        price[start] = 0;

        // pq가 빌 때 까지
        while(!pq.isEmpty()) {
            // pq의 제일 위에 있는 노드를 빼내
            City now = pq.poll();
            // 최소 길이인지 확인하여 방문여부를 체크하고
            if(price[now.v] < now.cost){
                continue;
            }

            // 해당 노드와 연결된 Node를 가져와
            for(City next : graph[now.v]){
                // 최단거리 > 현재 노드를 경유하여 가는 경우일 경우
                if(price[next.v] > now.cost + next.cost) {
                    // 최단거리를 갱신하고 pq에 추가한다.
                    price[next.v] = now.cost + next.cost;
                    pq.add(new City(next.v, price[next.v]));
                }
            }

        }
    }
}
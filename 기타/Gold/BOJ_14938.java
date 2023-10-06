import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    // 1. 지역의 개수 N, 수색할 수 있는 범위 M, 길의 개수 R,
    static int N, M, R;
    // 연결 정보 place, 아이템 정보 item, 방문 여부 visited,
    static ArrayList<Node>[] place;
    static int[] item;
    static boolean[] visited;
    // 아이템 수 count, 최대 개수 max를 선언한다.
    static int count;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M, R이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        // 3. place, item의 크기를 설정하고
        place = new ArrayList[N + 1];
        item = new int[N + 1];
        // place를 초기화하고 item 정보를 저장한다.
        for(int i = 1 ; i <= N ; i++){
            place[i] = new ArrayList<>();
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }

        // 4. R만큼 정보를 받아 place에 저장한다.
        for(int i = 0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            place[start].add(new Node(end, cost));
            place[end].add(new Node(start, cost));
        }

        // 5. 지역을 돌면서
        for(int i = 1 ; i <= N ; i++){
            // visited, count를 초기화하고
            visited = new boolean[N + 1];
            count = 0;

            // 다익스트라 알고리즘을 호출하여 max를 갱신한다.
            dijkstra(i);
            max = Math.max(max, count);
        }

        // 6. 종료 시 max를 출력한다.
        bw.write(max + "\n");

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

        // 현재 정보를 pq에 추가한다.
        pq.add(new Node(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()) {
            // 현재 정보를 가져와
            Node now = pq.poll();
            // 이미 방문했을 경우 무시,
            if(visited[now.v]) continue;

            // 이외에는 현재 아이템 수를 추가하고 방문처리한 뒤
            count += item[now.v];
            visited[now.v] = true;

            // 연결된 노드들을 탐색하여
            for(Node next : place[now.v]) {
                // 방문하지 않았고
                // 현재 거리 + 다음 거리가 탐색 범위 내라면
                if(!visited[next.v] && now.cost + next.cost <= M){
                    // pq에 추가한다.
                    pq.add(new Node(next.v, now.cost + next.cost));
                }
            }
        }
    }
}
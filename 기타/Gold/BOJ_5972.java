import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 헛간의 개수 N, 길의 수 M,
    static int N, M;
    // 연결 정보 graph, 소 방문 여부 visited,
    static ArrayList<Cow>[] graph;
    static boolean[] visited;
    // 최소 방문 시간 time을 선언한다.
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // graph, time, visited의 크기를 설정하고
        graph = new ArrayList[N + 1];
        time = new int[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            // graph를 초기화하면서 time을 INF로 저장한다.
            graph[i] = new ArrayList<>();
            time[i] = Integer.MAX_VALUE;
        }

        // M만큼 정보를 받아
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // graph에 저장한다.
            graph[start].add(new Cow(end, cost));
            graph[end].add(new Cow(start, cost));
        }

        // 4. 다익스트라 알고리즘을 호출한 뒤
        dijkstra(1);
        // N까지의 최소 시간을 출력한다.
        bw.write(time[N] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Cow {
        // 연결된 소와 거리
        int v;
        int cost;

        public Cow(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void dijkstra(int start) {
        // 가중치 기준 오름차순으로 pq를 선언한다.
        PriorityQueue<Cow> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 위치를 0으로 저장하고 pq에 추가한다.
        time[start] = 0;
        pq.add(new Cow(start, 0));

        // pq가 빌 때 까지 반복하여
        while (!pq.isEmpty()) {
            // 현재 정보를 가져와
            Cow now = pq.poll();
            // 방문하지 않았다면 방문처리하고
            if (!visited[now.v]) visited[now.v] = true;

            // 연결된 노드 정보를 탐색하는데
            for (Cow next : graph[now.v]) {
                // 방문하지 않았고
                // 현재 최댓값 > 현재 시간 + 다음 시간이라면
                if (!visited[next.v] && time[next.v] > now.cost + next.cost) {
                    // time을 갱신하고 pq에 추가한다.
                    time[next.v] = now.cost + next.cost;
                    pq.add(new Cow(next.v, time[next.v]));
                }
            }
        }
    }
}
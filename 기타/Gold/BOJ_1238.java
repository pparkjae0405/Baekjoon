import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    // 1. 학생의 수 N, 단방향 도로의 개수 M, 도착 마을 X,
    static int N, M, X;
    // 마을을 표현할 town, 방문 여부 visited,
    static ArrayList<Town>[] town;
    static boolean[] visited;
    // 본인 마을에서 X까지의 최소거리 go, X에서 본인 마을까지의 최소거리 back,
    static int[] go;
    static int[] back;
    // 최단거리 탐색 작업을 수행할 d를 선언한다.
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M, X가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        // 3. town과 go, back의 크기를 설정하고
        town = new ArrayList[N + 1];
        go = new int[N + 1];
        back = new int[N + 1];
        // town을 초기화한다.
        for(int i = 1 ; i <= N ; i++){
            town[i] = new ArrayList<>();
        }

        // 4. M개의 (도로의 시작점 start, 끝점 end, 소요시간 time) 정보가 주어지고,
        for(int i = 0 ; i < M ; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            // town에 저장한다.
            town[start].add(new Town(end, time));
        }

        // 5. i에서 X까지 가는 최소비용을 구하기 위해
        for(int i = 1 ; i <= N ; i++){
            // visited, d를 초기화하고
            visited = new boolean[N + 1];
            d = new int[N + 1];
            // d의 값을 INF로 저장한 뒤
            for(int j = 1 ; j <= N ; j++){
                d[j] = Integer.MAX_VALUE;
            }

            // X번 마을을 제외한
            if(i != X) {
                // 1 ~ N번 마을에서 다른 모든 마을로의 최단 거리를 구해
                dijkstra(i);
                // i에서 X까지 가는 최소비용을 go에 저장하고
                go[i] = d[X];
            }
        }

        // 6. X에서 다른 모든 마을까지 가는 최소비용을 구하기 위해
        // visited, d를 초기화하고
        visited = new boolean[N + 1];
        d = new int[N + 1];
        // d의 값을 INF로 저장한 뒤
        for(int i = 1 ; i <= N ; i++){
            d[i] = Integer.MAX_VALUE;
        }

        // 다익스트라 알고리즘을 호출하여
        dijkstra(X);
        // back에 저장한다.
        for(int i = 1 ; i <= N ; i++){
            back[i] = d[i];
        }

        // 7. go와 back 합의 최댓값을 max에 저장하여 출력한다.
        int max = Integer.MIN_VALUE;
        for(int i = 1 ; i <= N ; i++){
            if (max < go[i] + back[i]) max = go[i] + back[i];
        }
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Town{
        // 도착 마을, 가중치
        int v;
        int cost;

        public Town(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void dijkstra(int start){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<Town> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 마을을 pq에 추가하고 최단거리를 0으로 저장한다.
        pq.add(new Town(start, 0));
        d[start] = 0;

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 마을을 가져와
            Town now = pq.poll();
            // 방문하지 않았을 경우 방문처리하고
            if(!visited[now.v]) visited[now.v] = true;

            // 연결된 마을들을 가져와
            for(Town next : town[now.v]){
                // 방문하지 않았고 연결된 마을까지의 최단거리 > 현재 노드를 경유하여 가는 경우일 경우
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // 최단거리를 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    pq.add(new Town(next.v, d[next.v]));
                }
            }
        }
    }
}
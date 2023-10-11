import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 행성의 수 N,
    static int N;
    // 연결 정보 graph, 방문 여부 visited,
    static ArrayList<Planet>[] graph;
    static boolean[] visited;
    // MST값 result를 선언한다.
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어지고
        N = Integer.parseInt(br.readLine());
        // graph와 visited의 크기를 설정하고
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        // graph를 초기화한다.
        for(int i = 1 ; i <= N ; i++){
            graph[i] = new ArrayList<>();
        }

        // 3. N*N만큼 연결 정보가 주어지고
        StringTokenizer st;
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++){
                int value = Integer.parseInt(st.nextToken());
                if(i == j) continue;

                // graph에 저장한다.
                graph[i].add(new Planet(j, value));
            }
        }

        // 4. prim 알고리즘을 호출하여 result를 출력한다.
        prim(1);
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Planet{
        int v;
        int cost;

        public Planet(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void prim(int start){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<Planet> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 위치를 pq에 추가한다.
        pq.add(new Planet(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 정보를 가져와
            Planet now = pq.poll();
            // 방문했을 경우 무시,
            if(visited[now.v]) continue;

            // 안했을 경우 방문처리하고 result를 추가한 뒤
            visited[now.v] = true;
            result += now.cost;
            // 연결된 노드를 탐색하여
            for(Planet next : graph[now.v]){
                // 방문하지 않았을 경우 pq에 추가한다.
                if(!visited[next.v]) pq.add(next);
            }
        }
    }
}
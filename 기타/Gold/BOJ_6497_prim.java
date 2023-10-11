import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 집의 수 m, 길의 수 n,
    static int m, n;
    // 정보를 저장할 graph, 방문 여부 visited,
    static ArrayList<House>[] graph;
    static boolean[] visited;
    // 전체 비용 sum, MST의 값 min을 선언한다.
    static int sum, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. m, n이 0, 0이 될 때 까지 입력받는다.
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0) break;

            // 3. graph, visited의 크기를 설정하고
            // graph를 초기화한다.
            graph = new ArrayList[m + 1];
            visited = new boolean[m + 1];
            for(int i = 0 ; i <= m ; i++){
                graph[i] = new ArrayList<>();
            }

            // 4. sum, min을 초기화하고 n만큼의 정보를
            sum = 0;
            min = 0;
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                // graph에 저장하고 sum에 추가한다.
                graph[start].add(new House(end, cost));
                graph[end].add(new House(start, cost));
                sum += cost;
            }

            // 5. 프림 알고리즘을 호출해 MST를 완성하고
            prim(1);
            // sum - min을 출력한다.
            bw.write(sum - min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class House{
        int v;
        int cost;

        public House(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void prim(int start){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<House> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 위치를 pq에 추가한다.
        pq.add(new House(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 정보를 가져와 방문한 적이 있을 경우 무시,
            House now = pq.poll();
            if(visited[now.v]) continue;

            // 없을 경우 방문처리하고 현재 가중치를 추가한 뒤
            visited[now.v] = true;
            min += now.cost;
            // 연결된 정보를 가져와
            for(House next : graph[now.v]) {
                // 방문하지 않았을 경우 pq에 추가한다.
                if(!visited[next.v]) pq.add(next);
            }
        }
    }
}
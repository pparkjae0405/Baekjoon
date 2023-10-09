import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    // 1. 컴퓨터 개수 n, 의존성 개수 d, 해킹당한 컴퓨터 번호 c,
    static int n, d, c;
    // 연결 정보 graph, 컴퓨터 방문 여부 visited,
    static ArrayList<Com>[] graph;
    static boolean[] visited;
    // 감염 시간 t를 선언한다.
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 테스트 케이스 개수 t가 주어지고, t만큼 반복한다.
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < t ; i++){
            // 3. n, d, c가 주어지고
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            // graph, time, visited의 크기를 설정하고
            graph = new ArrayList[n + 1];
            time = new int[n + 1];
            visited = new boolean[n + 1];
            for(int j = 1 ; j <= n ; j++){
                // graph를 초기화하면서 time을 INF로 저장한다.
                graph[j] = new ArrayList<>();
                time[j] = Integer.MAX_VALUE;
            }

            // d만큼 정보를 받아
            for(int j = 0 ; j < d ; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int end = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                // graph에 저장한다.
                graph[start].add(new Com(end, cost));
            }

            // 4. c 컴퓨터를 시작으로 다익스트라 알고리즘을 호출한 뒤
            dijkstra(c);
            // 감염된 컴퓨터의 개수와 시간을 찾아 출력한다.
            int count = 0;
            int max = Integer.MIN_VALUE;
            for(int j = 1 ; j <= n ; j++){
                if(visited[j]) count++;
                if(time[j] != Integer.MAX_VALUE && time[j] > max) max = time[j];
            }
            bw.write(count + " " + max + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Com{
        // 연결된 컴퓨터와 거리
        int v;
        int cost;

        public Com(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void dijkstra(int start){
        // 가중치 기준 오름차순으로 pq를 선언한다.
        PriorityQueue<Com> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 위치를 0으로 저장하고 pq에 추가한다.
        time[start] = 0;
        pq.add(new Com(start, 0));

        // pq가 빌 때 까지 반복하여
        while(!pq.isEmpty()){
            // 현재 정보를 가져와
            Com now = pq.poll();
            // 방문하지 않았다면 방문처리하고
            if(!visited[now.v]) visited[now.v] = true;

            // 연결된 노드 정보를 탐색하는데
            for(Com next : graph[now.v]){
                // 방문하지 않았고
                // 현재 최댓값 > 현재 시간 + 다음 시간이라면
                if(!visited[next.v] && time[next.v] > now.cost + next.cost){
                    // time을 갱신하고 pq에 추가한다.
                    time[next.v] = now.cost + next.cost;
                    pq.add(new Com(next.v, time[next.v]));
                }
            }
        }
    }
}
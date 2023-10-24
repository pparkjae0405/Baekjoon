import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 컴퓨터의 개수 N, 회선 개수 M,
    static int N, M;
    // 컴퓨터 정보 com, 컴퓨터 방문 여부 visited,
    static ArrayList<Com>[] com;
    static boolean[] visited;
    // 최단 거리 d, 정답 정보 answer를 선언한다.
    static int[] d;
    static ArrayList<Com> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // com, visited, d의 크기를 설정한 뒤
        com = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        d = new int[N + 1];
        // com을 초기화하면서 d를 INF로 저장한다.
        for(int i = 1 ; i <= N ; i++){
            com[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }

        // 3. M만큼 회선 정보가 주어지고
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // com에 저장한다.
            com[start].add(new Com(start, end, cost));
            com[end].add(new Com(end, start, cost));
        }

        // 4. 다익스트라 알고리즘을 호출하여
        dijkstra(1);
        // answer를 출력한다.
        bw.write(answer.size() + "\n");
        for(Com next : answer){
            bw.write(next.start + " " + next.end + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Com{
        int start;
        int end;
        int cost;

        public Com(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static void dijkstra(int start){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<Com> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 위치를 0으로 설정하고 pq에 추가한다.
        d[start] = 0;
        pq.add(new Com(start, start,0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 정보를 가져와
            Com now = pq.poll();

            // 도착 지점이 방문하지 않았을 경우
            if(!visited[now.end]){
                // 방문처리한 뒤
                visited[now.end] = true;

                // 가중치가 0이 아닐 경우(처음 컴퓨터가 아닐 경우) answer에 추가하고
                if(now.cost != 0) {
                    answer.add(now);
                }
            }

            // 연결된 컴퓨터를 가져와
            for(Com next : com[now.end]){
                // 방문하지 않았고
                // 다음 최단거리 > 현재 가중치 + 다음 가중치일 경우
                if(!visited[next.end] && d[next.end] > now.cost + next.cost){
                    // 다음 최단거리를 갱신하고 pq에 추가한다.
                    d[next.end] = now.cost + next.cost;
                    pq.add(new Com(next.start, next.end, d[next.end]));
                }
            }
        }
    }
}
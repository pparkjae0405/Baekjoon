import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 분기점의 수 N, 길의 개수 M,
    static int N, M;
    // 연결 정보 game, 방문 여부 visited,
    static ArrayList<Game>[] game;
    static boolean[] visited;
    // 최단 거리 d를 선언한다.
    static long[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // game, visited, d의 크기를 설정한 뒤
        game = new ArrayList[N];
        visited = new boolean[N];
        d = new long[N];
        // game을 초기화하면서 d를 INF로 저장한다.
        for(int i = 0 ; i < N ; i ++){
            game[i] = new ArrayList<>();
            d[i] = Long.MAX_VALUE;
        }

        // 3. 시야 여부가 N만큼 주어지면
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            // N - 1을 제외한 1을 방문할 수 없다고 체크한다.
            int value = Integer.parseInt(st.nextToken());
            if(value == 1 && i != N - 1) visited[i] = true;
        }
        // 연결 정보를 M만큼 받아 game에 저장한다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            game[start].add(new Game(end, cost));
            game[end].add(new Game(start, cost));
        }

        // 4. 다익스트라 알고리즘을 호출하여 0에서 N-1까지 가는 최단거리를 출력한다.
        dijkstra(0);
        if(d[N - 1] == Long.MAX_VALUE){
            bw.write(-1 + "\n");
        }else{
            bw.write(d[N - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Game implements Comparable<Game>{
        int v;
        long cost;

        public Game(int v, long cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Game o) {
            return Long.compare(this.cost, o.cost);
        }
    }

    static void dijkstra(int start){
        // 우선순위 큐를 선언한다.
        PriorityQueue<Game> pq = new PriorityQueue<>();

        // 시작 위치를 0으로 설정하고 pq에 추가한다.
        d[start] = 0;
        pq.add(new Game(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 정보를 가져와
            Game now = pq.poll();
            // 방문하지 않았을 경우 방문처리하고 방문했을 경우 무시한다.
            if(!visited[now.v]) visited[now.v] = true;
            else continue;

            // 연결된 정보를 가져와
            for(Game next : game[now.v]){
                // 방문하지 않았고
                // 다음 최단거리 > 현재 가중치 + 다음 가중치일 경우
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // 최단거리를 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    pq.add(new Game(next.v, d[next.v]));
                }
            }
        }
    }
}
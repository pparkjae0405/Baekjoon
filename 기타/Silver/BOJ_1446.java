import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 지름길의 개수 N, 고속도로의 길이 D,
    static int N, D;
    // 고속도로 정보 road, 방문 여부 visited,
    static ArrayList<Road>[] road;
    static boolean[] visited;
    // 최단 거리 d를 선언한다.
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, D가 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        // road, visited, d의 크기를 선언한 뒤
        road = new ArrayList[D + 1];
        visited = new boolean[D + 1];
        d = new int[D + 1];
        // road를 초기화하면서 d를 INF로 저장한다.
        for(int i = 0 ; i <= D ; i++){
            road[i] = new ArrayList<>();
            d[i] = Integer.MAX_VALUE;
        }

        // 3. N만큼 지름길 정보가 주어지고
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // 정보가 road 범위 안일 경우에만 road에 저장한다.
            if(start <= D && end <= D){
                road[start].add(new Road(end, cost));
            }
        }

        // 4. 다익스트라 알고리즘을 호출하여
        dijkstra(0);
        // 최솟값을 출력한다.
        bw.write(d[D] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Road{
        int v;
        int cost;

        public Road(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void dijkstra(int start){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<Road> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 위치를 0으로 설정하고 pq에 추가한다.
        d[start] = 0;
        pq.add(new Road(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 정보를 가져와
            Road now = pq.poll();

            // 방문하지 않았을 경우 방문처리하고
            if(!visited[now.v]) visited[now.v] = true;

            // 연결된 길을 가져와
            for(Road next : road[now.v]){
                // 다음 도착지가 D를 넘거나 지름길이 유효하지 않다면 무시하고
                if(next.v > D || next.v - now.v <= next.cost) continue;

                // 방문하지 않았고
                // 다음 최솟값 > 현재 가중치 + 다음 가중치일 경우
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // 현재 위치 최솟값 + 다음 도착지점과 현재 가중치 + 다음 가중치 중
                    // 최솟값으로 갱신하고 pq에 추가한다.
                    d[next.v] = Math.min(d[now.v] + next.v, now.cost + next.cost);
                    pq.add(new Road(next.v, d[next.v]));
                }
            }

            // now.v를 1 추가하고 현재 도착지가 D 이하일 경우(지름길이 없을 경우)
            now.v++;
            if(now.v <= D){
                // 현재 최솟값을 이전 최솟값 + 1과 비교하여 최솟값으로 갱신하고
                d[now.v] = Math.min(d[now.v], d[now.v - 1] + 1);
                // pq에 추가한다.
                pq.add(new Road(now.v, d[now.v]));
            }
        }
    }
}
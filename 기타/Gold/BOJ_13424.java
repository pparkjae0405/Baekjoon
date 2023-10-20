import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 1. 방의 개수 N, 통로 개수 M, 친구의 수 K,
    static int N, M, K;
    // 방 연결 정보 info, 방문 여부 visited,
    static ArrayList<Room>[] info;
    static boolean[] visited;
    // 최단 거리 d를 선언한다.
    static int[] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 테스트 케이스 T가 주어지고 T만큼 반복하여
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t = 0 ; t < T ; t++) {
            // N, M이 주어진다.
            st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            // 3. info의 크기를 설정하고
            info = new ArrayList[N + 1];
            // info를 초기화한다.
            for (int i = 1; i <= N; i++) {
                info[i] = new ArrayList<>();
            }

            // 4. M만큼 정보가 주어지고
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                // graph에 저장한다.
                info[start].add(new Room(end, cost));
                info[end].add(new Room(start, cost));
            }

            // 5. K가 주어지면 최솟값과 최단거리의 합을 선언하고
            K = Integer.parseInt(br.readLine());
            int min = Integer.MAX_VALUE;
            int[] sum = new int[N + 1];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0 ; i < K ; i++){
                // 인원 위치가 주어지면
                int loca = Integer.parseInt(st.nextToken());

                // visited와 d를 초기화한 뒤 d를 INF로 저장하고
                visited = new boolean[N + 1];
                d = new int[N + 1];
                Arrays.fill(d, Integer.MAX_VALUE);

                // 다익스트라 알고리즘을 호출해 값을 sum에 추가한다.
                dijkstra(loca);
                for(int j = 1 ; j <= N ; j++){
                    sum[j] += d[j];
                }
            }

            // 6. 종료 시 최솟값에 해당하는 최소 위치를 출력한다.
            for(int i = 1 ; i <= N ; i++){
                if(min > sum[i]) min = sum[i];
            }
            for(int i = 1 ; i <= N ; i++){
                if(sum[i] == min){
                    bw.write(i + "\n");
                    break;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Room{
        int v;
        int cost;

        public Room(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void dijkstra(int start){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<Room> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 위치를 0으로 저장하고 pq에 추가한다.
        d[start] = 0;
        pq.add(new Room(start, 0));

        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // 현재 정보를 가져와
            Room now = pq.poll();
            // 방문하지 않았을 경우 방문처리하고
            if(!visited[now.v]) visited[now.v] = true;

            // 연결된 노드를 가져와
            for(Room next : info[now.v]){
                // 방문하지 않았고
                // 현재 최솟값 > 현재 가중치 + 다음 가중치라면
                if(!visited[next.v] && d[next.v] > now.cost + next.cost){
                    // 최솟값을 갱신하고 pq에 추가한다.
                    d[next.v] = now.cost + next.cost;
                    pq.add(new Room(next.v, d[next.v]));
                }
            }
        }
    }
}
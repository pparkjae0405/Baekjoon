import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    // 1. 동굴의 크기 N, 도둑루피 정보 map,
    static int N;
    static int[][] map;
    // 노드 방문 여부 visited, 최소 금액 price,
    static boolean[][] visited;
    static int[][] price;
    // 이동 방향 dx, dy를 선언한다.
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 동굴의 크기 N이 0일 때 까지 반복하여
        int count = 0;
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0) break;

            // N만큼 map, visited, price를 선언한다.
            map = new int[N][N];
            visited = new boolean[N][N];
            price = new int[N][N];

            // N * N개의 정보가 주어지면
            StringTokenizer st;
            for(int i = 0 ; i < N ; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0 ; j < N ; j++){
                    // map의 정보와 price를 INF로 저장한다.
                    map[i][j] = Integer.parseInt(st.nextToken());
                    price[i][j] = Integer.MAX_VALUE;
                }
            }

            // 다익스트라 알고리즘을 수행한 결과를 출력한다.
            dijkstra();
            count++;
            bw.write("Problem " + count + ": " + price[N - 1][N - 1] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class Rupee{
        // 현재 좌표 (y, x), 잃는 비용
        int y;
        int x;
        int cost;

        public Rupee(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }
    }

    static void dijkstra(){
        // 가중치 기준 오름차순으로 우선순위 큐를 선언한다.
        PriorityQueue<Rupee> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        // 시작 위치를 pq에 추가한 뒤 price[0][0]을 map[0][0] 값으로 저장한다.
        pq.add(new Rupee(0, 0, map[0][0]));
        price[0][0] = map[0][0];

        // pq가 빌 때 까지 반복하여
        while(!pq.isEmpty()){
            // pq에 제일 위에 있는 노드를 꺼내 방문하지 않았을 경우 방문처리
            Rupee now = pq.poll();
            if(!visited[now.y][now.x]) visited[now.y][now.x] = true;

            // 인접 위치로 이동하는데
            for(int i = 0 ; i < 4 ;  i++){
                int nextY = now.y + dy[i];
                int nextX = now.x + dx[i];

                // 해당 위치가 map 범위 안에 있고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N){
                    // 방문하지 않았고 최단 거리가 현재 위치를 경유하여 가는 경우보다 짧을 경우
                    if(!visited[nextY][nextX] && price[nextY][nextX] > price[now.y][now.x] + map[nextY][nextX]){
                        // 최단 거리를 갱신하고 pq에 추가한다.
                        price[nextY][nextX] = price[now.y][now.x] + map[nextY][nextX];
                        pq.add(new Rupee(nextY, nextX, price[nextY][nextX]));
                    }
                }
            }
        }
    }
}
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 집부터 축제까지 거쳐가는 지도 map, 방문 여부 visited,
    static int[][] map;
    static boolean[] visited;
    // bfs를 위한 큐를 선언한다.
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 테스트 케이스의 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 3. T만큼 맥주를 파는 편의점의 개수 N이 주어지면
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++){
            int N = Integer.parseInt(br.readLine());

            // map과 visited의 크기를 설정한 뒤 queue를 선언한다.
            map = new int[N + 2][N + 2];
            visited = new boolean[N + 2];
            queue = new LinkedList<>();

            // 4. 상근이네 집 좌표,
            st = new StringTokenizer(br.readLine(), " ");
            map[0][0] = Integer.parseInt(st.nextToken());
            map[0][1] = Integer.parseInt(st.nextToken());

            // N만큼의 편의점 좌표,
            for(int j = 0 ; j < N ; j++){
                st = new StringTokenizer(br.readLine(), " ");
                map[j + 1][0] = Integer.parseInt(st.nextToken());
                map[j + 1][1] = Integer.parseInt(st.nextToken());
            }
            // 펜타포트 락 페스티벌 좌표를 받아 map에 저장한다.
            st = new StringTokenizer(br.readLine(), " ");
            map[N + 1][0] = Integer.parseInt(st.nextToken());
            map[N + 1][1] = Integer.parseInt(st.nextToken());

            // 5. 시작 위치부터 bfs를 통해 탐색하여
            bfs(0);
            // 행복하게 갈 수 있으면 happy,
            if(visited[N + 1]){
                bw.write("happy" + "\n");
            }else{
                // 중간에 맥주가 바닥나서 더 이동할 수 없으면 sad를 출력한다.
                bw.write("sad" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        // 시작 위치를 방문처리하고 큐에 추가한 뒤
        visited[start] = true;
        queue.add(start);

        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 가져와
            int now = queue.poll();
            int nowY = map[now][0];
            int nowX = map[now][1];

            // 다음 위치를 탐색하는데
            for(int i = 0 ; i < map.length ; i++){
                // 해당 위치가 방문하지 않았다면
                if(!visited[i]){
                    // 거리가 1000 이하인지 계산하여
                    int len = Math.abs(map[i][0] - nowY) +
                            Math.abs(map[i][1] - nowX);
                    if(len <= 1000) {
                        // 갈 수 있을 경우 방문처리하고 큐에 추가한다.
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
    }
}
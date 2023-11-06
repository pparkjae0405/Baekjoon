import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    // 1. 교실의 크기 N, M,
    static int N, M;
    // 교실 정보 info, 방문 여부 visited, 최단 거리 d,
    static int[][] info;
    static boolean[][] visited;
    static int[][] d;
    // 이동 방향 dx, dy,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 0-1 너비우선탐색을 위한 deque를 선언한다.
    static Deque<int[]> deque = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // 주난이의 좌표, 범인의 좌표가 주어지면
        st = new StringTokenizer(br.readLine(), " ");
        int y1 = Integer.parseInt(st.nextToken()) - 1;
        int x1 = Integer.parseInt(st.nextToken()) - 1;
        int y2 = Integer.parseInt(st.nextToken()) - 1;
        int x2 = Integer.parseInt(st.nextToken()) - 1;

        // 3. info, visited, d의 크기를 설정하고
        info = new int[N][M];
        visited = new boolean[N][M];
        d = new int[N][M];
        // info 정보를 저장하면서 d를 INF로 설정한다.
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                info[i][j] = str.charAt(j) - '0';
                d[i][j] = Integer.MAX_VALUE;
            }
        }

        // 4. bfs를 탐색한 결과를 출력한다.
        bfs(y1, x1, y2, x2);
        bw.write(d[y2][x2] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int startY, int startX, int endY, int endX){
        // 시작 위치를 0으로 설정하고 deque에 추가한다.
        d[startY][startX] = 0;
        deque.add(new int[]{startY, startX});

        // deque가 빌 때 까지
        while(!deque.isEmpty()){
            // 현재 정보를 가져와
            int[] now = deque.poll();
            int nowY = now[0];
            int nowX = now[1];
            // 위치가 endY, endX일 경우 종료,
            if(nowY == endY && nowX == endX) return;
            // 방문하지 않았을 경우 방문처리하고
            if(!visited[nowY][nowX]) visited[nowY][nowX] = true;

            // 이외에는 인접 위치를 탐색하여
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 info 범위 안이고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    // 방문하지 않았고
                    if(!visited[nextY][nextX]){
                        // 해당 위치가 0이면
                        if(info[nextY][nextX] == 0){
                            // deque의 맨 앞에 추가 + 방문처리 + 거리 그대로 적용
                            deque.addFirst(new int[]{nextY, nextX});
                            visited[nextY][nextX] = true;
                            d[nextY][nextX] = d[nowY][nowX];
                        }else{
                            // 1이면 deque의 맨 뒤에 추가 + 방문처리 + 거리+1로 적용
                            deque.addLast(new int[]{nextY, nextX});
                            visited[nextY][nextX] = true;
                            d[nextY][nextX] = d[nowY][nowX] + 1;
                        }
                    }
                }
            }
        }
    }
}
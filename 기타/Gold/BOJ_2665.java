import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main{
    // 1. 미로의 크기 N,
    static int N;
    // 미로를 표현할 maze, 방문 여부 visited, 최단 거리 d,
    static int[][] maze;
    static boolean[][] visited;
    static int[][] d;
    // 이동 방향 dx, dy, 0-1 bfs를 위한 Deque를 선언한다.
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Deque<int[]> deque = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어진다.
        N = Integer.parseInt(br.readLine());

        // 3. maze, visited, d의 크기를 설정하고
        maze = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        d = new int[N + 1][N + 1];
        // maze의 정보를 저장하고 d를 INF로 설정한다.
        for(int i = 1 ; i <= N ; i ++){
            String s = br.readLine();
            for(int j = 1 ; j <= N ; j++){
                maze[i][j] = s.charAt(j - 1) - '0';
                d[i][j] = Integer.MAX_VALUE;
            }
        }

        // 4. 다익스트라 알고리즘을 호출하여
        dijkstra();
        // 방을 바꾸며 도착했을 때 최소 몇 개를 바꿨는지 출력한다.
        bw.write(d[N][N] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(){
        // 시작 위치를 0으로 설정하고 deque에 추가한다.
        d[1][1] = 0;
        deque.add(new int[]{1, 1});

        // deque가 빌 때 까지 반복하여
        while(!deque.isEmpty()){
            // 현재 위치를 가져와
            int[] now = deque.poll();
            int nowY = now[0];
            int nowX = now[1];
            // 방문하지 않았을 경우 방문처리하고
            if(!visited[nowY][nowX]) visited[nowY][nowX] = true;

            // 같지 않다면 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 map 범위 안에 있고
                if(nextY >= 1 && nextY <= N && nextX >= 1 && nextX <= N){
                    // 방문하지 않았고
                    if(!visited[nextY][nextX]){
                        // 해당 위치가 1이면 deque의 맨 앞에 추가하고
                        if(maze[nextY][nextX] == 1){
                            deque.addFirst(new int[]{nextY, nextX});
                            // 방문처리한 뒤 현재 값 그대로 추가,
                            visited[nextY][nextX] = true;
                            d[nextY][nextX] = d[nowY][nowX];
                        }else{
                            // 0이면 deque의 맨 뒤에 추가하고
                            deque.offer(new int[]{nextY, nextX});
                            // 방문처리한 뒤 현재 값 + 1로 추가,
                            visited[nextY][nextX] = true;
                            d[nextY][nextX] = d[nowY][nowX] + 1;
                        }
                    }
                }
            }
        }
    }
}
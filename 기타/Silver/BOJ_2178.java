import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 미로의 크기 N, M, 미로 maze, 방문여부 visited를 선언한다.
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 두 정수 N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. N*M 크기의 미로가 주어지고, maze에 저장한다.
        maze = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < M ; j++){
                maze[i][j] = s.charAt(j) - '0';
            }
        }

        // 4. visited의 크기를 설정하고 1, 1을 방문처리한다.
        visited = new boolean[N][M];
        visited[0][0] = true;

        // 5. (1, 1)에서 (N, M)까지 이동하는 최소 칸수를 출력한다.
        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int x, int y){
        // 큐와 이동할 방향 dx, dy를 선언하고, 시작위치를 추가한다.
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int[] start = {x, y};
        queue.add(start);

        // 큐가 빌때까지 반복하여
        while(!queue.isEmpty()) {
            // 큐의 가장 위에 위치한 원소를 뽑아
            int now[] = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // (nextX, nextY) 좌표가 미로 범위 안에 존재하고
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    // 해당 위치가 1이고 방문하지 않았을경우
                    if(maze[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        // 해당 위치를 큐에 넣고 방문처리한 뒤
                        int[] next = {nextX, nextY};
                        queue.add(next);
                        visited[nextX][nextY] = true;

                        // 이동할 위치의 크기를 1 추가한다.
                        maze[nextX][nextY] = maze[nowX][nowY] + 1;
                    }
                }
            }
        }
    }
}
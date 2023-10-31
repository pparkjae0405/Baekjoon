import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 체스 판의 크기 N,
    static int N;
    // 체스 판 chess, 방문 여부 visited
    static int[][] chess;
    static boolean[][] visited;
    // 이동 방향 dx, dy,
    static int[] dx = {-1, 1, -2, 2, -1, 1};
    static int[] dy = {-2, -2, 0, 0, 2, 2};
    // bfs를 위한 큐를 선언한다.
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N과 (r1, c1), (r2, c2)가 주어진다.
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        int r2 = Integer.parseInt(st.nextToken());
        int c2 = Integer.parseInt(st.nextToken());
        // chess, visited의 크기를 설정한 뒤
        chess = new int[N][N];
        visited = new boolean[N][N];

        // bfs를 호출하여 최소 이동 횟수를 출력한다.
        bfs(r1, c1);
        if(chess[r2][c2] == 0){
            bw.write(-1 + "\n");
        }else{
            bw.write(chess[r2][c2] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x){
        // 시작 위치를 방문처리하고 큐에 추가한다.
        visited[y][x] = true;
        queue.add(new int[]{y, x});

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 정보를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 이동가능 위치를 탐색하는데
            for(int i = 0 ; i < 6 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 범위 내에 있고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N){
                    // 방문하지 않았다면
                    if(!visited[nextY][nextX]){
                        // 방문처리하고 이동 횟수를 증가시킨 뒤 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        chess[nextY][nextX] += chess[nowY][nowX] + 1;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
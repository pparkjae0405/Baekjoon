import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 한 변의 길이 I, 체스판을 표현할 chess, 방문여부 visited,
    static int I;
    static int[][] chess;
    static boolean[][] visited;
    // 이동방향 dx, dy, bfs를 위한 큐를 선언한다.
    static int[] dx = {-2, -1, 1, 2, -2, -1, 1, 2};
    static int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. T가 주어지고
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++) {
            // T만큼 한 변의 길이 I,
            I = Integer.parseInt(br.readLine());
            // 나이트가 현재 있는 칸,
            st = new StringTokenizer(br.readLine(), " ");
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            // 이동하려고 하는 칸이 주어지면
            st = new StringTokenizer(br.readLine(), " ");
            int endY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());

            // chess와 visited의 크기를 설정하고
            chess = new int[I][I];
            visited = new boolean[I][I];

            // 큐를 선언하여 시작 위치를 큐에 추가한 뒤 방문처리하고
            queue = new LinkedList<>();
            queue.add(new int[]{startY, startX});
            visited[startY][startX] = true;

            // bfs를 호출하여 이동하려고 하는 칸까지 걸리는 횟수를 출력한다.
            bfs(endY, endX);
            bw.write(chess[endY][endX] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int endY, int endX){
        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 꺼내
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 현재 위치가 endY, endX일 경우 탐색종료하고
            if(nowY == endY && nowX == endX){
                return;
            }

            // 이외에는 이동할 수 있는 위치를 탐색하는데
            for(int i = 0 ; i < 8 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치 체스판 안에 있고
                if(nextY >= 0 && nextY < I && nextX >= 0 && nextX < I){
                    // 방문하지 않았다면
                    if(!visited[nextY][nextX]){
                        // 방문처리하고 횟수를 추가하여 저장한 뒤
                        visited[nextY][nextX] = true;
                        chess[nextY][nextX] = chess[nowY][nowX] + 1;
                        // 큐에 추가한다.
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
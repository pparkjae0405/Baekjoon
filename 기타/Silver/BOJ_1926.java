import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 도화지의 세로 크기 n, 가로 크기 m,
    static int n, m;
    // 도화지 정보 paper, 방문 여부 visited,
    static int[][] paper;
    static boolean[][] visited;
    // 이동 방향 dx, dy, bfs를 위한 큐,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    // 구역의 개수 count, 넓이 area, 넓이의 최댓값 max를 선언한다.
    static int count = 0;
    static int area;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. n, m이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        // paper, visited의 크기를 설정한 뒤
        paper = new int[n][m];
        visited = new boolean[n][m];
        // paper의 정보를 저장한다.
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < m ; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. paper를 돌면서
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                // 방문하지 않은 그림이 있다면
                if(!visited[i][j] && paper[i][j] == 1){
                    // 방문처리하고 큐에 추가한 뒤
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});

                    // area를 초기화하고 count를 증가시키고
                    area = 1;
                    count++;
                    // bfs를 호출하여 max를 갱신한다.
                    bfs();
                    max = Math.max(max, area);
                }
            }
        }

        // 4. count와 max를 출력한다.
        if(count == 0){
            bw.write(0 + "\n" + 0);
        }else{
            bw.write(count + "\n" + max);
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 paper 범위 내고
                if(nextY >= 0 && nextY < n && nextX >= 0 && nextX < m) {
                    // 방문하지 않은 1이 있다면
                    if(!visited[nextY][nextX] && paper[nextY][nextX] == 1) {
                        // 방문처리하고 큐에 추가한 뒤 area를 증가시킨다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                        area++;
                    }
                }
            }
        }
    }
}
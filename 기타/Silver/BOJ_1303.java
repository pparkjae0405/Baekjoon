import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 전쟁터의 가로 크기 N, 세로 크기 M,
    static int N, M;
    // 전쟁터 정보 war, 방문 여부 visited,
    static int[][] war;
    static boolean[][] visited;
    // 이동 방향 dx, dy,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // bfs를 위한 큐,
    static Queue<int[]> queue = new LinkedList<>();
    // 병사의 수 count, 병사 위력의 합 W, B를 선언한다.
    static int count;
    static int W = 0;
    static int B = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // war, visited의 크기를 설정한 뒤
        war = new int[M][N];
        visited = new boolean[M][N];
        // war의 정보를 저장한다.
        for(int i = 0 ; i < M ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                if(str.charAt(j) == 'B'){
                    war[i][j] = 1;
                }else{
                    war[i][j] = 0;
                }
            }
        }

        // 3. war을 돌면서
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                // 방문하지 않은 곳이 있다면
                if(!visited[i][j]){
                    // count를 초기화하고 bfs를 호출하여 인원 수를 체크하고
                    count = 1;
                    bfs(i, j, war[i][j]);

                    // 해당 진영에 따라 W나 B에 추가한다.
                    if(war[i][j] == 0){
                        W += (count * count);
                    }else{
                        B += (count * count);
                    }
                }
            }
        }

        // 4. W와 B를 출력한다.
        bw.write(W + " " + B);

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x, int value){
        // 시작 위치를 방문처리하고 큐에 추가한다.
        visited[y][x] = true;
        queue.add(new int[]{y, x});

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 정보를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 war 범위 안에 있고
                if(nextY >= 0 && nextY < M && nextX >= 0 && nextX < N){
                    // 방문하지 않았고 value와 같다면
                    if(!visited[nextY][nextX] && war[nextY][nextX] == value){
                        // 방문처리하고 count를 증가시킨 뒤 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        count += 1;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
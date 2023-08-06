import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 종이의 세로 개수 N, 가로 개수 M,
    static int N, M;
    // 종이 paper, 방문여부 visited,
    static int[][] paper;
    static boolean[][] visited;
    // 이동방향 dx, dy, 최댓값 max 선언
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. paper, visited의 크기를 설정한다.
        paper = new int[N][M];
        visited = new boolean[N][M];

        // 4. 종이의 정보를 설정한다.
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 5. 종이를 돌면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 시작지점을 true로 설정하고
                visited[i][j] = true;
                // 4칸을 움직일 수 있는 경우 중 최댓값을 탐색
                dfs(i, j, 1, paper[i][j]);
                // 시작지점을 false로 설정한다.
                visited[i][j] = false;

                // T블럭일 경우도 계산한다.
                dfsT(i, j, 1, paper[i][j], 0);
            }
        }

        // 6. 최댓값을 출력한다.
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x, int count, int value){
        // 블럭 개수가 4개라면 탐색 종료시키는데
        if(count == 4){
            // 블럭 값이 최댓값이라면 최댓값 설정
            max = Math.max(max, value);
            return;
        }

        // 인접 위치를 탐색
        for(int i = 0 ; i < 4 ; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            // 범위 안에 있고 방문하지 않았을 경우
            if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                if(!visited[nextY][nextX]){
                    // 다음 위치를 방문처리하고
                    visited[nextY][nextX] = true;

                    // 위치로 이동, 다음 위치를 방문해제한다.
                    dfs(nextY, nextX, count + 1, value + paper[nextY][nextX]);
                    visited[nextY][nextX] = false;
                }
            }
        }
    }

    // T 블럭일 경우 상하좌우 중 3개 선택
    static void dfsT(int y, int x, int count, int value, int start){
        // 블럭 개수가 3개라면 탐색 종료시키는데
        if(count == 4){
            // 블럭 값이 최댓값이라면 최댓값 설정
            max = Math.max(max, value);
            return;
        }

        // 인접 위치를 탐색
        for(int i = start ; i < 4 ; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            // 범위 안에 있으면
            if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M) {
                // 호출
                dfsT(y, x, count + 1, value + paper[nextY][nextX], i + 1);
            }
        }
    }
}
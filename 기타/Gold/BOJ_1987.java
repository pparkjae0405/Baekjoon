import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 가로 줄의 개수 R, 세로 줄의 개수 C,
    static int R, C;
    // 보드를 표현할 board, 방문한 알파벳 visited
    static int[][] board;
    static boolean[] visited = new boolean[26];
    // 이동방향 dx, dy, 최대 칸수 max를 선언한다.
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. R, C가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 3. board의 크기를 설정하고
        board = new int[R][C];
        // 보드 정보를 저장한다.
        for(int i = 0 ; i < R ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                board[i][j] = str.charAt(j) - 65;
            }
        }

        // 4. dfs를 통해 board를 탐색하고,
        dfs(0, 0, 1);
        // 갈 수 있는 최대 횟수를 출력한다.
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x, int count){
        // 현재 위치값을 받아와 해당하는 알파벳을 방문처리하고
        int now = board[y][x];
        visited[now] = true;
        // max값을 갱신한 뒤
        if(max < count) max = count;

        // 인접 위치를 탐색하여
        for(int i = 0 ; i < 4 ; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            // 해당 위치가 board 안에 존재하고
            if(nextY >= 0 && nextY < R && nextX >= 0 && nextX < C) {
                // 해당 알파벳을 방문한 적이 있는지 없을 경우에만
                if(!visited[board[nextY][nextX]]){
                    // 다음 위치 + 칸수 + 1로 재귀호출하고
                    dfs(nextY, nextX, count + 1);
                    // 재귀가 끝났을 경우 방문해제한다.
                    visited[board[nextY][nextX]] = false;
                }
            }
        }
    }
}
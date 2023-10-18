import java.io.*;

public class Main{
    // 1. 그림의 크기 N,
    static int N;
    // 그림 paint, 방문여부 visited,
    static char[][] paint;
    static boolean[][] visited;
    // 이동 방향 dx, dy 선언
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어진다.
        N = Integer.parseInt(br.readLine());

        // 3. paint와 visited의 크기를 지정한다.
        paint = new char[N][N];
        visited = new boolean[N][N];

        // 4. 그림에 대한 정보와 빨간색, 초록색 그리드의 개수를 저장한다.
        int red = 0;
        int green = 0;
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < N ; j++){
                paint[i][j] = s.charAt(j);

                if(paint[i][j] == 'R'){
                    red++;
                }else{
                    green++;
                }
            }
        }

        // 5. 구역의 수 count를 선언하고 그림을 돌면서
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                // 방문하지 않은 곳이라면 구역의 수를 증가시키고 탐색 시작하여
                if(!visited[i][j]){
                    count++;
                    dfs(i, j);
                }
            }
        }

        // 적록색약이 아닌 사람이 봤을 때의 구역의 개수를 출력하고,
        bw.write(count + " ");

        // 6. count와 visited를 초기화하고 R과 G 중 개수가 작은 색깔을 반대 색으로 바꾼 뒤
        count = 0;
        visited = new boolean[N][N];
        if(red > green){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(paint[i][j] == 'G'){
                        paint[i][j] = 'R';
                    }
                }
            }
        }else{
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(paint[i][j] == 'R'){
                        paint[i][j] = 'G';
                    }
                }
            }
        }

        // 다시 그림을 돌면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                // 방문하지 않은 곳이라면 구역의 수를 증가시키고 탐색 시작하여
                if(!visited[i][j]){
                    count++;
                    dfs(i, j);
                }
            }
        }

        // 적록색약인 사람이 봤을 때의 구역의 개수 출력한다.
        bw.write(count + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x){
        // 찾은 위치를 방문처리하고,
        visited[y][x] = true;

        // 해당 위치의 색깔을 가져와
        char color = paint[y][x];
        // 인접 위치를 탐색하는데
        for(int i = 0 ; i < 4 ; i++){
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            // 위치가 그림 범위 안에있고
            if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N){
                // 같은색깔에 방문하지 않은 곳이 있다면
                if(paint[nextY][nextX] == color && !visited[nextY][nextX]){
                    // 해당 위치로 이동
                    dfs(nextY, nextX);
                }
            }
        }
    }
}
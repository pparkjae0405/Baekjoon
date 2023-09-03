import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 방의 세로 크기 N, 가로 크기 M,
    static int N, M;
    // 방을 표현할 room, 이동방향 dx, dy,
    static int[][] room;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    // 청소하는 칸의 개수 count를 선언한다.
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. room의 크기를 설정하고 시작 위치와 바라보는 방향을 입력받은 뒤
        room = new int[N][M];
        st = new StringTokenizer(br.readLine(), " ");
        int startY = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        // 4. 방의 정보를 저장한다.
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 시작 위치 + 바라보는 방향에서부터 작동을 시작하여
        dfs(startY, startX, dir);
        // 종료됐을 때 청소한 칸의 개수를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x, int dir){
        // 현재 위치가 0이라면
        if(room[y][x] == 0){
            // 청소하고 count를 증가시킨다.
            room[y][x] = -1;
            count++;
        }

        // 그 다음 주변 4칸을 탐색하여
        boolean isZero = false;
        for(int i = 0 ; i < 4 ; i++) {
            int nextY = y + dy[i];
            int nextX = x + dx[i];

            // 해당 위치가 방을 넘길경우 무시
            if (nextY < 0 || nextY > N - 1 || nextX < 0 || nextX > M - 1) continue;

            // 해당 위치가 0일 경우 isZero를 true로 변경하고 break
            if (room[nextY][nextX] == 0) {
                isZero = true;
                break;
            }
        }

        // 청소하지 않은 곳이 없다면
        if(!isZero){
            // 한칸 뒤가 벽일 경우 작동을 멈추고
            if(back(y, x, dir)){
                return;
            }else{
                // 벽이 아닐 경우 한칸 뒤로 이동한다.
                moveBack(y, x, dir);
            }
        }else{
            // 주변 4칸 중 0이 있다면
            for(int i = 0 ; i < 4 ; i++){
                // 반시계로 90도 회전시키고
                dir -= 1;
                if(dir == -1) dir = 3;

                // 앞의 칸이 0이라면 해당 위치로 이동한다.
                if(forward(y, x, dir)) {
                    moveForward(y, x, dir);
                    break;
                }
            }
        }
    }

    static boolean back(int y, int x, int dir){
        // 한칸 뒤가 벽인지 확인한다.
        boolean pos = false;
        if(dir == 0){
            if(room[y + 1][x] == 1) pos = true;
        }else if(dir == 1){
            if(room[y][x - 1] == 1) pos = true;
        }else if(dir == 2){
            if(room[y - 1][x] == 1) pos = true;
        }else{
            if(room[y][x + 1] == 1) pos = true;
        }

        return pos;
    }

    static void moveBack(int y, int x, int dir){
        // 한 칸 뒤로 이동시킨다.
        if(dir == 0){
            dfs(y + 1, x, dir);
        }else if(dir == 1){
            dfs(y, x - 1, dir);
        }else if(dir == 2){
            dfs(y - 1, x, dir);
        }else{
            dfs(y, x + 1, dir);
        }
    }

    static boolean forward(int y, int x, int dir){
        // 앞 칸이 0인지 확인한다.
        boolean pos = true;
        if(dir == 0){
            if(room[y - 1][x] != 0) pos = false;
        }else if(dir == 1){
            if(room[y][x + 1] != 0) pos = false;
        }else if(dir == 2){
            if(room[y + 1][x] != 0) pos = false;
        }else{
            if(room[y][x - 1] != 0) pos = false;
        }

        return pos;
    }

    static void moveForward(int y, int x, int dir){
        // 한 칸 앞으로 이동시킨다.
        if(dir == 0){
            dfs(y - 1, x, dir);
        }else if(dir == 1){
            dfs(y, x + 1, dir);
        }else if(dir == 2){
            dfs(y + 1, x, dir);
        }else{
            dfs(y, x - 1, dir);
        }
    }
}
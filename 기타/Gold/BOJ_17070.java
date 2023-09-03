import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 방의 크기 N,
    static int N;
    // 방을 표현할 room, 경우의 수의 개수 count를 선언한다.
    static int[][] room;
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어진다.
        N = Integer.parseInt(br.readLine());

        // 3. room의 크기를 설정하고
        room = new int[N][N];
        // 방의 정보를 저장한다.
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. (1, 2)를 시작으로 dfs를 호출하여 경우의 수를 탐색하고 출력한다.
        dfs(0, 1, 0);
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int y, int x, int type){
        // y, x가 N, N일 경우 count를 증가시키고 종료시킨다.
        if(y == N - 1 && x == N - 1){
            count++;
            return;
        }

        // type에 따라 갈 수 있는 방향으로 이동시키는데
        int nextY = y + 1;
        int nextX = x + 1;
        // 가로방향일 때는 가로, 대각선 호출
        if(type == 0){
            // 가로로 가는 범위가 방을 넘지 않고 해당 위치가 0이라면 가로로 이동,
            if(nextX < N && room[y][nextX] == 0){
                dfs(y, nextX, 0);
            }
        }else if(type == 1){
            // 세로방향일 때는 세로, 대각선 호출
            // 세로로 가는 범위가 방을 넘지 않고 해당 위치가 0이라면 가로로 이동,
            if(nextY < N && room[nextY][x] == 0) {
                dfs(nextY, x, 1);
            }
        }else if(type == 2){
            // 대각선일 때는 가로, 세로, 대각선 호출
            if(nextX < N && room[y][nextX] == 0){
                dfs(y, nextX, 0);
            }
            if(nextY < N && room[nextY][x] == 0) {
                dfs(nextY, x, 1);
            }
        }

        // 대각선으로 가는 범위가 방을 넘지 않고 해당 위치가 0이라면 대각선으로 이동
        if(nextY < N && nextX < N && room[nextY][x] == 0 && room[y][nextX] == 0
                && room[nextY][nextX] == 0) {
            dfs(nextY, nextX, 2);
        }
    }
}
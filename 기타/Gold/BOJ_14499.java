import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 지도의 세로 크기 N, 가로 크기 M, 주사위의 좌표 (x, y), 명령의 개수 K,
    static int N, M, x, y, K;
    // 지도를 표현할 map,
    static int[][] map;
    // 이동 방향(동서북남) dx, dy,
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // 주사위에 적힌 번호 dice를 선언한다.
    static int[] dice = {0, 0, 0, 0, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N, M, x, y, K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 2. map의 크기를 설정하고 정보를 저장한다.
        map = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 3. K만큼의 명령이 주어지면
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < K ; i++){
            // 주사위를 움직이고
            int cmd = Integer.parseInt(st.nextToken()) - 1;
            x += dy[cmd];
            y += dx[cmd];

            // 해당 명령을 수행하면 지도 밖으로 나가게 된다면
            if(x < 0 || x >= N || y < 0 || y >= M){
                // 해당 명령을 취소하고 무시
                x -= dy[cmd];
                y -= dx[cmd];

                continue;
            }

            // 지도 안에서 움직인다면 해당 명령을 수행한 뒤
            if(cmd == 0) east();
            if(cmd == 1) west();
            if(cmd == 2) north();
            if(cmd == 3) south();


            // 바닥면의 숫자를 복사하고
            if(map[x][y] == 0){
                map[x][y] = dice[1];
            }else{
                dice[1] = map[x][y];
                map[x][y] = 0;
            }

            // 맨 위에 적힌 수를 출력한다.
            bw.write(dice[0] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void east(){
        int temp = dice[0];
        dice[0] = dice[4];
        dice[4] = dice[1];
        dice[1] = dice[5];
        dice[5] = temp;
    }

    static void west(){
        int temp = dice[0];
        dice[0] = dice[5];
        dice[5] = dice[1];
        dice[1] = dice[4];
        dice[4] = temp;
    }

    static void north(){
        int temp = dice[0];
        dice[0] = dice[2];
        dice[2] = dice[1];
        dice[1] = dice[3];
        dice[3] = temp;
    }

    static void south(){
        int temp = dice[0];
        dice[0] = dice[3];
        dice[3] = dice[1];
        dice[1] = dice[2];
        dice[2] = temp;
    }
}
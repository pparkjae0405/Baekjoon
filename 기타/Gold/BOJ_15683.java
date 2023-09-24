import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    // 1. 사무실의 세로 크기 N, 가로 크기 M, 사무실을 표현할 room,
    static int N, M;
    static int[][] room;
    // 이동 방향 dx, dy, CCTV 별 탐색범위 type,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][][] type = {{{0}},
            {{0}, {1}, {2}, {3}}, // 1번 CCTV
            {{0, 1}, {2, 3}}, // 2번 CCTV
            {{2, 1}, {1, 3}, {3, 0}, {0, 2}}, // 3번 CCTV
            {{2, 1, 3}, {1, 3, 0}, {3, 0, 2}, {0, 2, 1}}, // 4번 CCTV
            {{2, 3, 0, 1}} // 5번 CCTV
    };
    // CCTV 정보(CCTV 타입, y좌표, x좌표) info, 최소 크기 min을 선언한다.
    static ArrayList<int[]> info = new ArrayList<>();
    static int min = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. room을 선언하고 정보를 저장하면서
        room = new int[N][M];
        int zero = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                room[i][j] = Integer.parseInt(st.nextToken());

                // CCTV면 info에 추가,
                if(room[i][j] != 0 && room[i][j] != 6){
                    info.add(new int[]{room[i][j], i, j});
                }else if(room[i][j] == 0){
                    // 0이면 0의 개수를 추가한다.
                    zero++;
                }
            }
        }

        // 4. 현재 0의 개수를 min으로 설정하고
        min = zero;
        // 백트래킹을 호출하여 최소 크기를 출력한다.
        back(0, info.size(), room);
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth, int count, int[][] room){
        // depth == count일 경우
        if(depth == count) {
            // 0의 개수를 세
            int zero = 0;
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < M ; j++){
                    if(room[i][j] == 0){
                        zero++;
                    }
                }
            }

            // min을 갱신하고 종료한다.
            min = Math.min(min, zero);
            return;
        }

        // 이외에는 현재 CCTV의 정보를 가져와
        int now[] = info.get(depth);
        int nowType = now[0];
        int nowY = now[1];
        int nowX = now[2];

        // 해당하는 타입만큼 돌면서
        for(int i = 0 ; i < type[nowType].length ; i++){
            // room을 복사하고
            int[][] copy = new int[N][M];
            for(int a = 0 ; a < N ; a++){
                for(int b = 0 ; b < M ; b++){
                    copy[a][b] = room[a][b];
                }
            }

            // 해당하는 정보만큼 도는데
            for(int j = 0 ; j < type[nowType][i].length ; j++){
                // 보고있는 방향, 다음 (y, x)좌표를 선언하고
                int where = type[nowType][i][j];
                int nextY = nowY + dy[where];
                int nextX = nowX + dx[where];

                // 해당 방향을 체크하는데
                while(true){
                    // room 크기를 벗어나도 탈출,
                    if(nextY < 0 || nextY >= N || nextX < 0 || nextX >= M) break;

                    // 벽을 만나도 탈출하고
                    if(room[nextY][nextX] == 6) break;

                    // 이외에는 계속 이동한다.
                    copy[nextY][nextX] = -1;
                    nextY += dy[where];
                    nextX += dx[where];
                }
            }

            // 보는 방향을 다 체크했으면 재귀호출한다.
            back(depth + 1, count, copy);
        }
    }
}
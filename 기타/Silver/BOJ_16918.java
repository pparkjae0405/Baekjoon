import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 지도의 세로 크기 R, 가로 크기 C, 지난 시간 N초,
    static int R, C, N;
    // 지도 정보 map,
    static char[][] map;
    // 이동 방향 dx, dy, bfs를 위한 큐를 선언한다.
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. R, C, N이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        // map 정보를 저장한 뒤
        map = new char[R][C];
        for(int i = 0 ; i < R ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                map[i][j] = str.charAt(j);
            }
        }

        // 3. N초가 지난 후의 격자판 상태를 출력한다.
        bfs(1);
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                bw.write(map[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int time){
        while(time < N){
            // map을 돌면서 'O'인 값을 큐에 추가하고 '.'를 'O'로 변경한다.
            for(int i = 0 ; i < R ; i++){
                for(int j = 0 ; j < C ; j++){
                    if(map[i][j] == 'O') queue.add(new int[]{i, j});
                    else map[i][j] = 'O';
                }
            }
            time++;
            // N초가 됐다면 종료한다.
            if(time == N){
                return;
            }

            // 큐가 빌 때 까지
            while(!queue.isEmpty()){
                // 큐에 저장된 값을 가져와
                int[] now = queue.poll();
                int nowY = now[0];
                int nowX = now[1];

                // 해당하는 위치의 폭탄을 제거한다.
                map[nowY][nowX] = '.';
                for(int i = 0 ; i < 4 ; i++){
                    int nextY = nowY + dy[i];
                    int nextX = nowX + dx[i];

                    if(nextY >= 0 && nextY < R && nextX >= 0 && nextX < C){
                        map[nextY][nextX] = '.';
                    }
                }
            }
            time++;
        }
    }
}
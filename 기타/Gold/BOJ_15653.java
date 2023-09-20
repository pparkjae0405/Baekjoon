import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 보드의 세로 크기 N, 가로 크기 M,
    static int N, M;
    // 보드를 표현할 board, 빨간공 + 파란공 방문 여부 visited,
    static int[][] board;
    static boolean[][][][] visited;
    // 이동방향 dx, dy, bfs를 위한 큐,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    // 최소 횟수 min을 선언한다.
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. board, visited의 크기를 설정,
        board = new int[N][M];
        visited = new boolean[N][M][N][M];
        // 빨간 공의 (y, x)좌표, 파란 공의 (y, x) 정보를 선언하고
        int redY = 0;
        int redX = 0;
        int blueY = 0;
        int blueX = 0;
        // board의 정보를 저장하면서
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                int num = str.charAt(j) - '0' + 13;
                board[i][j] = num;

                // 빨간 공과 파란 공의 좌표 위치를 저장한다.
                if(num == 47){
                    redY = i;
                    redX = j;
                }else if(num == 31){
                    blueY = i;
                    blueX = j;
                }
            }
        }

        // bfs를 통해 탐색하고
        bfs(redY, redX, blueY, blueX, 0);
        // 탐색한 결과를 출력한다.
        if(min == Integer.MAX_VALUE){
            bw.write(-1 + "\n");
        }else{
            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int redY, int redX, int blueY, int blueX, int count){
        // 시작 위치를 큐에 추가하고 방문처리한다.
        queue.add(new int[]{redY, redX, blueY, blueX, count});
        visited[redY][redX][blueY][blueX] = true;

        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 가져와
            int[] now = queue.poll();

            // 아닐 경우 인접 위치로 이동시키는데
            for(int i = 0 ; i < 4 ; i++){
                int nextRedY = now[0];
                int nextRedX = now[1];
                int nextBlueY = now[2];
                int nextBlueX = now[3];

                // 빨간 구슬을 벽을 만날 때 까지 이동시키고
                while(board[nextRedY + dy[i]][nextRedX + dx[i]] != 0){
                    nextRedY += dy[i];
                    nextRedX += dx[i];
                    // 구멍일 경우 종료
                    if(board[nextRedY][nextRedX] == 44) break;
                }

                // 파란 구슬을 벽을 만날 때 까지 이동시키고
                while(board[nextBlueY + dy[i]][nextBlueX + dx[i]] != 0){
                    nextBlueY += dy[i];
                    nextBlueX += dx[i];
                    // 구멍일 경우 종료
                    if(board[nextBlueY][nextBlueX] == 44) break;
                }

                // 파란 구슬이 구멍에 들어갔을 경우 무시,
                if(board[nextBlueY][nextBlueX] == 44) continue;
                // 빨간 구슬이 구멍에 들어갔을 경우
                if(board[nextRedY][nextRedX] == 44) {
                    // min과 현재 횟수 + 1의 최솟값을 min에 갱신하고 종료
                    min = Math.min(min, now[4] + 1);
                    return;
                }

                // 빨간 공과 파란 공의 위치가 똑같고
                if(nextRedY == nextBlueY && nextRedX == nextBlueX){
                    // 해당 위치가 구멍이 아닐 경우
                    if(board[nextRedY][nextRedX] != 44){
                        // 두 공이 이동한 칸의 개수를 찾아
                        int redCount = Math.abs(nextRedY - now[0])
                                + Math.abs(nextRedX - now[1]);
                        int blueCount = Math.abs(nextBlueY - now[2])
                                + Math.abs(nextBlueX - now[3]);

                        // 파란 공이 먼저 도착한 경우 빨간 공을 한 칸 뒤로,
                        if(redCount > blueCount){
                            nextRedY -= dy[i];
                            nextRedX -= dx[i];
                        }else {
                            // 반대일 경우 파란 공을 한 칸 뒤로 옮긴다.
                            nextBlueY -= dy[i];
                            nextBlueX -= dx[i];
                        }
                    }
                }

                // 해당 위치가 방문하지 않았을 경우
                if(!visited[nextRedY][nextRedX][nextBlueY][nextBlueX]) {
                    // 방문처리하고 queue에 추가한다.
                    visited[nextRedY][nextRedX][nextBlueY][nextBlueX] = true;
                    queue.add(new int[]{nextRedY, nextRedX, nextBlueY, nextBlueX, now[4] + 1});
                }
            }
        }
    }
}
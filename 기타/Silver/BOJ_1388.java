import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 방의 세로 크기 N, 가로 크기 M,
    static int N, M;
    // 방 정보 info, 방문 여부 visited,
    static char[][] info;
    static boolean[][] visited;
    // 이동 방향 dx, dy,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // bfs를 위한 큐, 판자의 개수 count를 선언한다.
    static Queue<int[]> queue = new LinkedList<>();
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M과 정보가 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // info, visited의 크기를 설정한 뒤
        info = new char[N][M];
        visited = new boolean[N][M];
        // 방 정보를 저장한다.
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                info[i][j] = str.charAt(j);
            }
        }

        // 3. 방을 돌면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 방문하지 않은 곳이 있다면
                if(!visited[i][j]){
                    // 해당 위치를 bfs호출하고 count를 증가시킨다.
                    bfs(i, j, info[i][j]);
                    count++;
                }
            }
        }
        // 결과를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x, char type){
        // 시작 위치를 방문처리하고 큐에 추가한다.
        visited[y][x] = true;
        queue.add(new int[]{y, x});

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 정보를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // -일 경우 좌우, |일 경우 상하를 탐색하여
            if(type == '-'){
                for(int i = 0 ; i < 2 ; i++){
                    int nextY = nowY + dy[i];
                    int nextX = nowX + dx[i];

                    // 범위 내에 있고
                    if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                        // 방문하지 않은 -가 있을 경우
                        if(!visited[nextY][nextX] && info[nextY][nextX] == type){
                            // 방문처리하고 큐에 추가한다.
                            visited[nextY][nextX] = true;
                            queue.add(new int[]{nextY, nextX});
                        }
                    }
                }
            }else{
                for(int i = 2 ; i < 4 ; i++){
                    int nextY = nowY + dy[i];
                    int nextX = nowX + dx[i];

                    // 범위 내에 있고
                    if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                        // 방문하지 않은 |가 있을 경우
                        if(!visited[nextY][nextX] && info[nextY][nextX] == type){
                            // 방문처리하고 큐에 추가한다.
                            visited[nextY][nextX] = true;
                            queue.add(new int[]{nextY, nextX});
                        }
                    }
                }
            }
        }
    }
}
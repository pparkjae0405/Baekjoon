import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 울타리의 세로 크기 R, 가로 크기 C,
    static int R, C;
    // 울타리 정보 info, 방문 여부 visited,
    static char[][] info;
    static boolean[][] visited;
    // 이동 방향 dx, dy, bfs를 위한 큐,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    // 양과 늑대의 총 마릿수 정보와 구역 별 마릿수를 선언한다.
    static int totalS = 0;
    static int totalW = 0;
    static int areaS, areaW;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. R, C가 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // info, visited의 크기를 설정한 뒤
        info = new char[R][C];
        visited = new boolean[R][C];
        // info 정보를 저장하면서
        for(int i = 0 ; i < R ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                info[i][j] = str.charAt(j);

                // 양과 늑대의 마릿수를 체크한다.
                if(info[i][j] == 'o'){
                    totalS++;
                }else if(info[i][j] == 'v'){
                    totalW++;
                }
            }
        }

        // 3. info를 돌면서
        for(int i = 0 ; i < R ; i++){
            for(int j = 0 ; j < C ; j++){
                // 방문하지 않았고 #이 아닌 곳이 있다면
                if(!visited[i][j] && info[i][j] != '#'){
                    // areaS, areaW를 초기화하고 bfs를 호출하여
                    areaS = 0;
                    areaW = 0;
                    bfs(i, j);

                    // 영역 내 양과 늑대의 수를 비교,
                    if(areaS > areaW){
                        // 양이 더 많다면 늑대를 빼고
                        totalW -= areaW;
                    }else{
                        // 늑대가 양을 잡아먹었다면 양을 뺀다.
                        totalS -= areaS;
                    }
                }
            }
        }

        // 4. totalS, totalW를 출력한다.
        bw.write(totalS + " " + totalW);

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int y, int x){
        // 시작 위치를 방문처리하고 큐에 추가한다.
        visited[y][x] = true;
        queue.add(new int[]{y, x});

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 정보를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 양이나 늑대라면 마릿수를 추가하고
            if(info[nowY][nowX] == 'o'){
                areaS++;
            }else if(info[nowY][nowX] == 'v'){
                areaW++;
            }

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 info 범위 안에 있고
                if(nextY >= 0 && nextY < R && nextX >= 0 && nextX < C){
                    // 방문하지 않았고 #가 아니라면
                    if(!visited[nextY][nextX] && info[nextY][nextX] != '#'){
                        // 방문처리 + 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
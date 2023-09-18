import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 모눈종이의 세로 크기 N, 가로 크기 M,
    static int N, M;
    // 모눈종이를 표현할 paper, 방문 여부 visited,
    static int[][] paper;
    static boolean[][] visited;
    // 이동 방향 dx, dy,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // bfs를 위한 큐, 최소 시간 time,
    static Queue<int[]> queue = new LinkedList<>();
    static int time = 0;
    // 종료 조건 isZero, 한 시간 전 남아있는 칸의 개수 last를 선언한다.
    static boolean isZero = false;
    static int last;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. paper의 크기를 설정하고 정보를 저장한다.
        paper = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. 1이 없을 때 까지 bfs 반복
        while(true){
            // 모두 0일 경우 종료
            checkZero();
            if(isZero) break;

            // visited를 초기화하고
            visited = new boolean[N][M];
            // (0, 0)을 시작점으로 바깥 공간을 방문처리한다.
            bfs(0, 0);

            // 이후 바깥 공간과 맡닿아있는 치즈와 현재 치즈 개수를 저장한 뒤
            last = 0;
            checkOne();
            // 0으로 바꾼다.
            change();
            // time을 1 추가한다.
            time++;
        }

        // 5. time, last를 출력한다.
        bw.write(time + "\n");
        bw.write(last + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void checkZero(){
        // paper을 돌면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 0일 경우 isZero를 true,
                if(paper[i][j] == 0){
                    isZero = true;
                }else{
                    // 1일 경우 isZero를 false로 만들고 종료
                    isZero = false;
                    return;
                }
            }
        }
    }

    static void bfs(int y, int x){
        // 시작 위치를 방문처리하고 큐에 추가
        visited[y][x] = true;
        queue.add(new int[]{y, x});

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 위치를 가져와
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 종이범위 안이고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    // 방문하지 않은 0이 있다면
                    if(!visited[nextY][nextX] && paper[nextY][nextX] == 0){
                        // 해당 위치를 방문처리하고 큐에 추가
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }

    static void checkOne(){
        // paper을 돌면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 1이 있을 경우 last를 증가시키고
                if(paper[i][j] == 1) {
                    last++;

                    // 해당 위치 주변에 바깥 공간이 1개 이상 있는지 확인하여
                    int count = 0;
                    for(int k = 0 ; k < 4 ; k++){
                        int nextY = i + dy[k];
                        int nextX = j + dx[k];

                        if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                            if(visited[nextY][nextX] && paper[nextY][nextX] == 0){
                                count++;
                            }
                        }
                    }

                    // count가 1 이상일 경우 해당 위치를 방문처리
                    if(count >= 1){
                        visited[i][j] = true;
                    }
                }
            }
        }
    }

    static void change(){
        // paper을 돌면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 방문한 1이 있을 경우 0으로 바꾼다.
                if(visited[i][j] && paper[i][j] == 1){
                    paper[i][j] = 0;
                }
            }
        }
    }
}
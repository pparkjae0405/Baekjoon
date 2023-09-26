import java.io.*;
import java.util.*;

public class Main{
    // 1. 공간의 크기 N,
    static int N;
    // 공간을 표현할 place, 방문 여부 visited, 이동 방향 dx, dy,
    static int[][] place;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // bfs를 위한 큐, 물고기 좌표(y, x) + 시간을 저장할 fish,
    static Queue<Fish> queue;
    static ArrayList<Fish> fish = new ArrayList<>();
    // 먹은 물고기 eat, 상어 정보 shark, 현재 상어의 크기 size, 결과 result를 선언한다.
    static int eat = 0;
    static Fish shark;
    static int size = 2;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어지고 place, visited의 크기를 설정,
        N = Integer.parseInt(br.readLine());
        place = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                // 정보를 저장하면서
                place[i][j] = Integer.parseInt(st.nextToken());

                // 해당 위치가 상어일 경우 상어 정보를 저장하고 0으로 변경한다.
                if(place[i][j] == 9){
                    shark = new Fish(i, j, 0);
                    place[i][j] = 0;
                }
            }
        }

        // 3. bfs를 호출한 결과를 출력한다.
        bfs();
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Fish{
        int y;
        int x;
        int time;

        public Fish(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }

    static void bfs(){
        // 큐를 선언하고 시작 정보를 추가하고 방문처리한다.
        queue = new LinkedList<>();
        queue.add(shark);
        visited[shark.y][shark.x] = true;

        while(true){
            // 큐가 빌 때 까지 반복하여
            while(!queue.isEmpty()){
                // 현재 queue를 가져와
                Fish now = queue.poll();
                int time = now.time;

                // 인접 위치를 탐색하는데
                for(int i = 0 ; i < 4 ; i++){
                    int nextY = now.y + dy[i];
                    int nextX = now.x + dx[i];

                    // 해당 범위가 place 안에 있고 방문하지 않았다면
                    if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < N){
                        if(!visited[nextY][nextX]) {
                            // 크기가 size보다 작고 0이 아니라면
                            if (place[nextY][nextX] < size && place[nextY][nextX] != 0) {
                                // 큐에 추가하고 방문처리한 뒤 fish에 추가한다.
                                queue.add(new Fish(nextY, nextX, time + 1));
                                visited[nextY][nextX] = true;
                                fish.add(new Fish(nextY, nextX, time + 1));
                            }

                            // 크기가 size와 같거나 비어있다면
                            if (place[nextY][nextX] == size || place[nextY][nextX] == 0) {
                                // 큐에 추가하고 방문처리한다.
                                queue.add(new Fish(nextY, nextX, time + 1));
                                visited[nextY][nextX] = true;
                            }
                        }
                    }
                }
            }

            // 찾은 고기들을 모두 먹고
            if(!fish.isEmpty()){
                eat();

                // queue와 visited를 초기화한 뒤
                queue.clear();
                visited = new boolean[N][N];

                // 현재 상어를 추가하고 방문처리한다.
                queue.add(shark);
                visited[shark.y][shark.x] = true;
            }else{
                return;
            }
        }
    }

    static void eat(){
        // 우선순위 별로 물고기 리스트를 정렬하고
        Collections.sort(fish, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                if(o1.time == o2.time) {
                    if(o1.y == o2.y) {
                        if(o1.x > o2.x) {
                            return 1;
                        }else {
                            return -1;
                        }
                    }else {
                        if(o1.y > o2.y) {
                            return 1;
                        }else {
                            return -1;
                        }
                    }
                }else if(o1.time > o2.time){
                    return 1;
                }else {
                    return -1;
                }
            }
        });

        // 현재 고기 위치를 가져와
        Fish now = fish.get(0);

        // 상어 위치를 이동시키고
        shark.y = now.y;
        shark.x = now.x;
        // eat, result를 증가한다.
        if(++eat == size){
            size++;
            eat = 0;
        }
        result += now.time;

        // 그 후 현재 위치를 0으로 바꾸고
        place[now.y][now.x] = 0;
        // fish를 초기화한다.
        fish.clear();
    }
}
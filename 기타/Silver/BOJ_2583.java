import java.io.*;
import java.util.*;

public class Main{
    // 1. 모눈종이의 세로 크기 M, 가로 크기 N,
    static int M, N;
    // 모눈종이 paper, 방문 여부 visited,
    static int[][] paper;
    static boolean[][] visited;
    // 이동 방향 dx, dy,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // bfs를 위한 큐, 영역 개수 count, 넓이 area, 넓이 배열 arr를 선언한다.
    static Queue<int[]> queue = new LinkedList<>();
    static int count = 0;
    static int area;
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. M, N, 직사각형의 개수 K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 3. paper, visited의 크기를 설정하고
        paper = new int[M][N];
        visited = new boolean[M][N];
        // K개만큼 직사각형의 정보가 주어지면
        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            // 해당 범위의 값을 1로 변경한다.
            for(int a = startY ; a < endY ; a++){
                for(int b = startX ; b < endX ; b++){
                    paper[a][b] = 1;
                }
            }
        }

        // 4. paper를 돌면서
        for(int i = 0 ; i < M ; i++){
            for(int j = 0 ; j < N ; j++){
                // 방문하지 않은 0이 있다면
                if(!visited[i][j] && paper[i][j] == 0){
                    // 방문처리하고 큐에 추가한 뒤
                    visited[i][j] = true;
                    queue.add(new int[]{i, j});

                    // count를 1 증가시키고 area를 초기화하고
                    count++;
                    area = 0;
                    // bfs를 호출하여 탐색한 넓이를 arr에 추가한다.
                    bfs();
                    arr.add(area);
                }
            }
        }

        // 5. count를 출력하고 arr을 오름차순 정렬하여 출력한다.
        bw.write(count + "\n");
        Collections.sort(arr);
        for(int i = 0 ; i < arr.size() ; i++){
            bw.write(arr.get(i) + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 가져와 area를 증가시키고
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];
            area++;

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 paper 범위 안이고
                if(nextY >= 0 && nextY < M && nextX >= 0 && nextX < N) {
                    // 방문하지 않은 0이 있다면
                    if(!visited[nextY][nextX] && paper[nextY][nextX] == 0) {
                        // 방문처리하고 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }
}
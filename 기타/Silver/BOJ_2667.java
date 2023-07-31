import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
    // 1. 지도의 크기 N, 지도 map, 방문여부 visited,
    static int N;
    static int[][] map;
    static boolean[][] visited;
    // 아파트 단지 groupNum, 단지 별 아파트 수를 저장할 apartNum 선언
    static ArrayList<Integer> groupNum = new ArrayList<>();;
    static int apartNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 정수 N이 주어진다.
        N = Integer.parseInt(br.readLine());

        // 3. map과 visited를 N*N으로 선언하고, 주어진 지도를 저장한다.
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = s.charAt(j) - '0';
            }
        }

        // 4. 지도를 돌면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                // 방문하지 않은 아파트를 찾고,
                if(map[i][j] == 1 && !visited[i][j]){
                    // 아파트 숫자를 1로 초기화한 뒤
                    apartNum = 1;
                    // 단지 내 아파트의 숫자를 그래프 탐색을 통해 저장한다.
                    bfs(i, j);
                    groupNum.add(apartNum);
                }
            }
        }

        // 5. 결과를 오름차순으로 정렬하여 총 단지 수와 집의 수를 출력한다.
        Collections.sort(groupNum);
        bw.write(groupNum.size() + "\n");
        for(int i = 0 ; i < groupNum.size() ; i++){
            bw.write(groupNum.get(i) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int x, int y){
        // 큐와 이동할 방향 dx, dy를 선언하고,
        Queue<int[]> queue = new LinkedList<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 시작위치를 추가하고 방문처리한다.
        int[] start = {x, y};
        queue.add(start);
        visited[x][y] = true;

        // 큐가 빌때까지 반복하여
        while(!queue.isEmpty()) {
            // 큐의 가장 위에 위치한 원소를 뽑아
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                // (nextX, nextY) 좌표가 미로 범위 안에 존재하고
                if(nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
                    // 해당 위치가 1이고 방문하지 않았을경우
                    if(map[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                        // 해당 위치를 큐에 넣고 방문처리한 뒤
                        int[] next = {nextX, nextY};
                        queue.add(next);
                        visited[nextX][nextY] = true;

                        // 아파트 수를 1 증가시킨다.
                        apartNum++;
                    }
                }
            }
        }
    }
}
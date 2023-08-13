import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 캠퍼스 세로 크기 N, 가로 크기 M,
    static int N;
    static int M;
    // 캠퍼스 campus, 방문 여부 visited,
    static char[][] campus;
    static boolean[][] visited;
    // 이동방향 dx, dy, bfs를 위한 큐, 만날 수 있는 사람의 수 count 선언
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> queue = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 캠퍼스 크기 N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. campus, visited의 크기를 설정한다.
        campus = new char[N][M];
        visited = new boolean[N][M];

        // 4. 캠퍼스 정보를 저장하고,
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                campus[i][j] = str.charAt(j);
                // I일 경우 시작 지점을 큐에 저장하고 방문처리한다.
                if(campus[i][j] == 'I'){
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        // 5. bfs를 수행한 결과를 출력한다.
        bfs();
        if(count == 0){
            bw.write("TT" + "\n");
        }else{
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        // 큐가 빌 때까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 가져오고
            int[] now = queue.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 인접 위치를 탐색하는데
            for(int i = 0 ; i < 4 ; i++){
                int nextY = nowY + dy[i];
                int nextX = nowX + dx[i];

                // 해당 위치가 캠퍼스 범위 안이고
                if(nextY >= 0 && nextY < N && nextX >= 0 && nextX < M){
                    // 방문하지 않았고 해당 위치가 X가 아닐 경우
                    if(!visited[nextY][nextX] && campus[nextY][nextX] != 'X'){
                        // 해당 위치가 P일 경우엔 만난 사람의 수를 증가시킨 뒤
                        if(campus[nextY][nextX] == 'P') count++;

                        // 방문처리 및 큐에 추가한다.
                        visited[nextY][nextX] = true;
                        queue.add(new int[]{nextY, nextX});
                    }
                }
            }

        }
    }
}
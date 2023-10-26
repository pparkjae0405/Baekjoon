import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 미로의 크기 N,
    static int N;
    // 1xN 크기의 미로 maze, 칸 별 점프 횟수 count, 방문여부 visited,
    static int[] maze;
    static int[] count;
    static boolean[] visited;
    // bfs를 위한 큐를 선언한다.
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어지고
        N = Integer.parseInt(br.readLine());
        // maze, count, visited의 크기를 설정한다.
        maze = new int[N + 1];
        count = new int[N + 1];
        visited = new boolean[N + 1];

        // 3. 칸 별 적혀있는 수를 저장하고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++){
            maze[i] = Integer.parseInt(st.nextToken());
        }
        // 시작 지점부터 탐색한 결과를 출력한다.
        visited[1] = true;
        queue.add(1);
        bfs();
        if(N == 1){
            bw.write(0 + "\n");
        }else if(count[N] == 0){
            bw.write(-1 + "\n");
        }else{
            bw.write(count[N] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 칸의 정보를 가져와 적힌 숫자를 가져온 뒤
            int now = queue.poll();
            int num = maze[now];

            // now부터 now + num까지 탐색하면서
            for(int i = now ; i <= now + num ; i++){
                // N을 넘는 경우 종료하고
                if(i > N) return;

                // 이외에는 방문하지 않았을 경우
                if(!visited[i]){
                    // 방문처리하고 점프 횟수를 저장한 뒤 큐에 추가한다.
                    visited[i] = true;
                    count[i] = count[now] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
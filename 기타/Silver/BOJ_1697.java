import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 수빈이의 위치 N, 동생의 위치 K
    static int N, K;
    // 위치를 나타낼 1차원 배열 line, 방문여부 visited
    static int[] line;
    static boolean[] visited;
    // 이동 위치 dx, bfs를 위한 큐 선언
    static int[] dx = {-1, 1, 2};
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N과 K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 3. line과 visited의 크기를 설정하고
        line = new int[100001];
        visited = new boolean[100001];

        // 4. 시작 위치를 1로 설정한 뒤 N에서 K까지 이동하는 최소 칸수를 출력한다.
        line[N] = 1;
        bw.write(bfs(N) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int start){
        // 큐에 시작 위치를 추가하고 방문처리한다.
        queue.add(start);
        visited[start] = true;

        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 큐의 가장 위에 위치한 원소를 뽑아
            int now = queue.poll();

            // 순간이동이나 걷기를 통해 이동할 위치를 탐색하는데
            for(int i = 0 ; i < 3 ; i++){
                int next;
                if(i == 2){
                    next = now * dx[i];
                }else{
                    next = now + dx[i];
                }

                // next 좌표가 line 안에 존재하고
                if(next >= 0 && next < 100001){
                    // 해당 위치가 0이고 방문하지 않았을 경우
                    if(line[next] == 0 && !visited[next]){
                        // 해당 위치를 큐에 넣고 방문처리한 뒤
                        queue.add(next);
                        visited[next] = true;

                        // 이동할 위치의 크기를 1 추가한다.
                        line[next]= line[now] + 1;
                    }
                }
            }
        }

        // 다 돌고 나온 뒤 도착 위치의 값을 리턴
        return line[K] - 1;
    }
}
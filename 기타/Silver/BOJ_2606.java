import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 컴퓨터 개수 N, 연결된 개수 M, 바이러스 시작 컴퓨터 start
    static int N, M, start;
    static int[][] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고 시작 컴퓨터를 설정한다.
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        start = 1;

        // 3. arr과 visited의 크기를 설정한다.
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 4. M만큼 간선이 주어지고,
        StringTokenizer st;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 해당하는 곳을 1로설정한다.
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        // 5. DFS를 수행하고 감연된 컴퓨터의 수를 출력한다.
        dfs(start);
        int count = 0;
        for(int i = 2 ; i <= N ; i++){
            if(visited[i]) count++;
        }
        bw.write(count + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int start){
        // 방문한 노드를 true로 바꾸고
        visited[start] = true;

        // 인접 노드를 탐색하여
        for(int i = 1 ; i <= N ; i++){
            // 연결된 노드 중 방문하지 않은 가장 작은 노드를 찾고
            if(arr[start][i] == 1 && visited[i] == false){
                // 그 노드로 이동
                dfs(i);
            }
        }
    }
}
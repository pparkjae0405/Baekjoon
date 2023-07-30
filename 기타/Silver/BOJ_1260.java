import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 정점의 개수 N, 간선의 개수 M, 탐색 시작 정점의 번호 V
    static int N, M, V;
    // 노드 별 연결된 정점 그래프를 표현할 2차원 배열 arr,
    static int[][] arr;
    // 노드 방문 여부를 판별할 boolean 배열 visited,
    static boolean[] visited;
    // 탐색 결과를 출력할 StringBuilder를 선언한다.
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M, V가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        // 3. arr과 visited의 크기를 설정한다.
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 4. M만큼 간선이 주어지고,
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 해당하는 곳을 1로설정한다.
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        // 5. DFS를 수행하고 visited를 초기화한 뒤 BFS를 수행한 결과를 출력한다.
        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);
        System.out.print(sb);

        bw.flush();
        br.close();
        bw.close();
    }

    // 깊이 우선 탐색(DFS)
    static void dfs(int V){
        // 방문한 노드를 true로 바꾸고
        visited[V] = true;
        // 해당 노드를 출력한다.
        sb.append(V + " ");

        // 인접 노드를 탐색하여
        for(int i = 1 ; i <= N ; i++){
            // 연결된 노드 중 방문하지 않은 가장 작은 노드를 찾고
            if(arr[V][i] == 1 && visited[i] == false){
                // 그 노드로 이동
                dfs(i);
            }
        }
    }

    // 너비 우선 탐색(BFS)
    static void bfs(int V){
        // 큐 선언 및 방문한 노드 추가
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        // 방문한 노드를 true로 바꾸고
        visited[V] = true;

        // 큐가 빌때까지 반복하여
        while(!queue.isEmpty()){
            // 큐의 가장 위에 위치한 원소를 뽑아 출력하고
            V = queue.poll();
            sb.append(V + " ");

            // 인접 노드를 탐색하여
            for(int i = 1 ; i <= N ; i++){
                // 연결된 노드 중 방문하지 않은 원소들을
                if(arr[V][i] == 1 && visited[i] == false){
                    // 큐에 삽입하고 해당 노드를 방문처리
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
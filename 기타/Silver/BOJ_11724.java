import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 정점의 개수 N, 간선의 개수 M,
    static int N, M;
    // 노드 별 연결된 노드 arr, 방문 여부를 확인할 visited,
    static int[][] arr;
    static boolean[] visited;
    // 연결 요소의 개수 count 선언
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. arr, visited 크기 설정
        arr = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        // 4. 간선 정보 설정
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 해당하는 곳을 1로 설정
            arr[x][y] = 1;
            arr[y][x] = 1;
        }

        // 5. 정점의 개수만큼 돌면서
        for(int i = 1 ; i <= N ; i++){
            // 방문하지 않은 정점일 경우
            if(!visited[i]) {
                // dfs를 수행하고 count를 증가시켜
                dfs(i);
                count++;
            }
        }

        // 6. 결과를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start){
        // 방문한 노드를 true로 바꾸고
        visited[start] = true;

        // 인접 노드를 탐색하여
        for(int i = 1 ; i <= N ; i++){
            // 연결된 노드 중 방문하지 않은 가장 작은 노드를 찾고
            if(arr[start][i] == 1 && !visited[i]){
                // 그 노드로 이동시킨다.
                dfs(i);
            }
        }
    }
}
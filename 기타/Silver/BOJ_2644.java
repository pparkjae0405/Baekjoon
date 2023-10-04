import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 전체 사람의 수 N, 관계의 개수 M,
    static int N, M;
    // 관계 정보 info, 방문 여부 visited,
    static int[][] info;
    static boolean[] visited;
    // 촌수를 셀 count를 선언한다.
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어진다.
        N = Integer.parseInt(br.readLine());

        // 3. info, visited의 크기를 설정하고
        info = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        // 구할 start, end가 주어진 뒤
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        // 4. M이 주어지고 정보를 info에 저장한다.
        M = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            info[a][b] = 1;
            info[b][a] = 1;
        }

        // 5. start부터 end까지의 count를 계산해 출력한다.
        dfs(0, start, end);
        if(count == 0){
            bw.write(-1 + "\n");
        }else {
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int depth, int start, int end){
        // start와 end가 같으면
        if(start == end){
            // depth를 count로 설정하고 종료한다.
            count = depth;
            return;
        }

        // 이외에는 현재 start를 방문처리하고
        visited[start] = true;
        // 인접 노드들을 탐색하여
        for(int i = 1 ; i <= N ; i++){
            // 방문하지 않고 연결된 가장 작은 값을 찾아
            if(!visited[i] && info[start][i] == 1){
                // 해당 위치로 이동시킨다.
                dfs(depth + 1, i, end);
            }
        }
    }
}
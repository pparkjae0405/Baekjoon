import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    // 1. 동기의 수 N, 관계의 수 M,
    static int N, M;
    // 동기 정보 info, 방문 여부 visited를 선언한다.
    static ArrayList<ArrayList<Integer>> info;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고, info와 visited의 크기를 설정한다.
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        info = new ArrayList<>();
        visited = new boolean[N + 1];
        for(int i = 0 ; i <= N ; i++){
            info.add(new ArrayList<>());
        }

        // 3. M만큼 정보를 저장한다.
        StringTokenizer st;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            info.get(start).add(end);
            info.get(end).add(start);
        }

        // 4. dfs를 호출하여 상근이가 초대할 수 있는 동기의 수를 출력한다.
        visited[1] = true;
        dfs(1, 0);
        int count = 0;
        for(int i = 0 ; i <= N ; i++){
            if(visited[i]) count++;
        }
        bw.write(count - 1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start, int depth){
        // depth가 2면 종료하고
        if(depth == 2){
            return;
        }

        // 이외에는 현재 위치와 연결된 친구를 돌면서
        for(Integer next : info.get(start)){
            // 방문처리하고 재귀호출한다.
            visited[next] = true;
            dfs(next, depth + 1);
        }
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    // 1. 참가인원의 수 N, 친구 관계의 수 M,
    static int N, M;
    // 참가 인원 별 친구관계 friend, 인원 탐색 여부 visited, 결과 answer를 선언한다.
    static ArrayList<Integer>[] friend;
    static boolean[] visited;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // friend의 크기를 설정한 뒤 초기화하고
        friend = new ArrayList[N];
        for(int i = 0 ; i < N ; i++) {
            friend[i] = new ArrayList<>();
        }
        // 정보를 저장한다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            friend[start].add(end);
            friend[end].add(start);
        }

        // 3. dfs를 호출하여 확인하기 위해
        for(int i = 0 ; i < N ; i++){
            // visited의 크기를 설정하고 시작 위치를 방문처리한 뒤
            visited = new boolean[N];
            visited[i] = true;
            // answer가 0일 경우 탐색하여
            if(answer == 0) {
                dfs(i, 0);
            }
        }

        // 4. 결과를 출력한다.
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int now, int depth){
        // 5명을 다 확인했다면 answer를 1로 저장하고 종료
        if(depth == 4){
            answer = 1;
            return;
        }

        // 이외에는 친구관계를 돌면서
        for(int i = 0 ; i < friend[now].size() ; i++){
            // 방문하지 않았다면
            int next = friend[now].get(i);
            if(!visited[next]){
                // 해당 위치를 방문처리하고 재귀호출한 뒤
                visited[next] = true;
                dfs(next, depth + 1);
                // 재귀가 끝나면 방문해제한다.
                visited[next] = false;
            }
        }
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    // 1. 노드의 개수 N, 연결 정보 tree, 노드 방문여부 visited, 최대 거리 max를 선언한다.
    static int N;
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어진다.
        N = Integer.parseInt(br.readLine());

        // 3. tree의 크기를 설정하고
        tree = new ArrayList[N + 1];
        // tree를 초기화한 뒤
        for(int i = 1 ; i <= N ; i++){
            tree[i] = new ArrayList<>();
        }
        // N만큼 연결 정보를 저장한다.
        StringTokenizer st;
        for(int i = 0 ; i < N - 1 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            tree[start].add(new Node(end, len));
            tree[end].add(new Node(start, len));
        }

        // 4. 출발 노드(1 ~ N) 범위를 돌면서
        for(int i = 1 ; i <= N ; i++){
            // visited의 크기를 설정하고
            visited = new boolean[N + 1];
            // 출발 노드를 방문처리한 뒤 dfs호출하여
            visited[i] = true;
            dfs(i, 0);
        }
        // 최대 거리를 출력한다.
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        // 연결된 노드, 노드까지의 길이
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static void dfs(int start, int len){
        // 연결된 노드로 이동하면서
        for(Node next : tree[start]){
            // 방문하지 않았다면
            if(!visited[next.v]){
                // 방문처리하고 거리를 추가해 dfs를 재귀호출한다.
                visited[next.v] = true;
                dfs(next.v, len + next.cost);
            }
        }
        // 탐색이 끝났을 경우 max를 갱신한다.
        if(len > max) max = len;

    }
}
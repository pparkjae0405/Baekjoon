import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 노드의 개수 N, 그래프를 표현할 tree, 노드 방문 여부 visited, 부모 노드 parent
    static int N;
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;
    static int[] parent;
    // bfs를 위한 큐를 선언한다.
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 노드의 개수 N이 주어진다.
        N = Integer.parseInt(br.readLine());

        // 2. N만큼 tree, visited, parent를 초기화한다.
        tree = new ArrayList<>();
        for(int i = 0 ; i < N ; i++){
            tree.add(new ArrayList<>());
        }
        visited = new boolean[N];
        parent = new int[N];

        // 3. N-1개의 줄에 트리 상에서 연결된 두 정점이 주어지고,
        StringTokenizer st;
        for(int i = 0 ; i < N - 1 ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            // tree에 추가한다.
            tree.get(a).add(b);
            tree.get(b).add(a);
        }

        // 4. bfs를 통해 부모 노드를 저장한 뒤 출력한다.
        bfs(0);
        for(int i = 1 ; i < N ; i++){
            bw.write(parent[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        // 시작 위치를 큐에 넣은 뒤 방문처리하고
        queue.add(start);
        visited[start] = true;

        // 큐가 빌 때까지
        while(!queue.isEmpty()){
            // 해당 노드를 가져와 방문처리하고
            int node = queue.poll();
            visited[node] = true;

            // 해당 노드에 연결된 노드들을 가져와
            for(int conn : tree.get(node)){
                // 방문한 노드가 아닐 경우
                if(!visited[conn]){
                    // 해당 노드를 방문처리하고 큐에 추가한 뒤
                    visited[conn] = true;
                    queue.add(conn);

                    // 부모 노드를 parent에 저장한다.
                    parent[conn] = node + 1;
                }
            }
        }
    }
}
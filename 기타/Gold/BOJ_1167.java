import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    // 1. 정점의 개수 V,
    static int V;
    // 트리를 표현할 tree, 정점 방문 여부 visited,
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    // 트리의 지름 d, 가장 먼 노드 node를 선언한다.
    static int d, node;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. V가 주어진다.
        V = Integer.parseInt(br.readLine());

        // 3. tree의 크기를 설정하고 초기화한 뒤
        tree = new ArrayList[V + 1];
        for(int i = 1 ; i <= V ; i++){
            tree[i] = new ArrayList<>();
        }

        // 4. V만큼 정보가 주어지면
        StringTokenizer st;
        for(int i = 0 ; i < V ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            // 출발 정점 번호를 저장하고
            int start = Integer.parseInt(st.nextToken());

            // -1이 나올 때 까지 도착 정점 번호, 정점까지의 거리를 받아
            while(true){
                int end = Integer.parseInt(st.nextToken());
                if(end == -1){
                    // -1일 경우 끝내고
                    break;
                } else {
                    // 아닐 경우 거리를 받아 tree에 저장한다.
                    int len = Integer.parseInt(st.nextToken());
                    tree[start].add(new Node(end, len));
                }
            }
        }

        // 5. 1에서부터 가장 먼 노드를 찾고,
        visited = new boolean[V + 1];
        visited[1] = true;
        dfs(1, 0);
        // node에서부터 가장 먼 노드까지의 거리를 구한 뒤
        visited = new boolean[V + 1];
        visited[node] = true;
        dfs(node, 0);
        // 지름을 출력한다.
        bw.write(d + "\n");


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
        // len이 d보다 크다면 그 떄의 길이와 노드를 저장하고,
        if(len > d){
            d = len;
            node = start;
        }

        // 연결된 노드로 이동하면서
        for(Node next : tree[start]){
            // 방문하지 않았다면
            if(!visited[next.v]){
                // 방문처리하고 거리를 추가해 재귀호출한다.
                visited[next.v] = true;
                dfs(next.v, len + next.cost);
            }
        }
    }
}
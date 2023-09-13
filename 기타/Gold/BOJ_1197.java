import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    // 1. 정점의 개수 V, 간선의 개수 E,
    static int V, E;
    // 그래프 정보를 저장할 graph, 부모 노드를 저장할 parent를 선언한다.
    static int[][] graph;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        최소 신장 트리(MST) - 크루스칼 알고리즘
        간선을 하나씩 늘려가면서 MST를 완성한다.
        1. 그래프 정보를 저장하고 가중치 오름차순으로 정렬한다.
        2. 크기가 가장 작은 간선부터 살피면서 사이클이 생기지 않으면
           (가중치 기준 오름차순으로 탐색하기 때문에 같은 부모일 경우 추가하지 않음)
           a의 부모 노드를 찾는 find,
           a와 b의 부모 노드를 설정하는 union를 통해 가중치를 추가한다.
         */

        // 2. V, E가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        // 3. parent, graph의 크기를 설정한 뒤
        parent = new int[V + 1];
        graph = new int[E][3];
        // parent의 초기값을 설정하고
        for(int i = 1 ; i <= V ; i++){
            parent[i] = i;
        }
        // 출발 노드, 도착 노드, 가중치 정보를 graph에 저장한다.
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            graph[i][0] = Integer.parseInt(st.nextToken());
            graph[i][1] = Integer.parseInt(st.nextToken());
            graph[i][2] = Integer.parseInt(st.nextToken());
        }

        // 4. 가중치 기준 오름차순으로 graph를 정렬하고
        Arrays.sort(graph, (o1, o2) -> o1[2] - o2[2]);
        // 크루스칼 알고리즘을 수행한 결과를 출력한다.
        bw.write(kruskal(graph, parent) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int kruskal(int[][] graph, int[] parent){
        // 현재 가중치 cost를 선언하고
        int cost = 0;

        // graph를 돌면서
        for(int i = 0 ; i < graph.length ; i++){
            // i번째 정보의 출발과 도착 노드의 부모가 일치하지 않을 경우
            if(find(parent, graph[i][0]) != find(parent, graph[i][1])) {
                // 현재 가중치를 추가하고
                cost += graph[i][2];
                // 두 노드의 부모 노드를 저장한다.
                union(parent, graph[i][0], graph[i][1]);
            }
        }

        // 탐색을 종료하였을 때의 cost를 리턴한다.
        return cost;
    }

    static int find(int[] parent, int x){
        // 현재 노드의 부모 노드가 본인일 경우 x 리턴
        if(parent[x] == x) return x;
            // 아닐 경우 현재 노드의 부모 노드로 이동하여 다시 탐색
        else return find(parent, parent[x]);
    }

    static void union(int[] parent, int x, int y){
        // x와 y 노드의 부모 노드를 찾는다.
        x = find(parent, x);
        y = find(parent, y);

        // 두 노드 중 작은 곳으로 부모 노드를 설정한다.
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
}
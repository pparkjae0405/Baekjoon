import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // 1. 정점의 개수 V, 간선의 개수 E,
    static int V, E;
    // 가중치 기준 오름차순으로 그래프 정보를 저장할 graph, 부모 노드 parent,
    static ArrayList<Node> graph;
    static int[] parent;
    // 최소 가중치 min을 선언한다.
    static int min = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. V, E가 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        // graph, parent의 크기를 설정한 뒤 parent의 초기값을 설정한다.
        graph = new ArrayList<>();
        parent = new int[V + 1];
        for(int i = 1 ; i <= V ; i++){
            parent[i] = i;
        }

        // 3. graph 정보를 저장하고 가중치 기준 오름차순으로 정렬한다.
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.add(new Node(start, end, cost));
        }
        Collections.sort(graph, (o1, o2) -> o1.cost - o2.cost);

        // 4. 크루스칼 알고리즘을 호출한 결과를 출력한다.
        kruskal();
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node{
        int start;
        int end;
        int cost;

        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }

    static void kruskal(){
        // 그래프를 돌면서
        for(int i = 0 ; i < graph.size() ; i++){
            // 현재 정보의 출발 노드와 도착 노드의 부모를 찾아
            Node now = graph.get(i);
            // 일치하지 않을 경우
            if(find(now.start) != find(now.end)){
                // 현재 가중치를 추가하고 두 노드의 부모를 설정한다.
                min += now.cost;
                union(now.start, now.end);
            }
        }
    }

    static int find(int x){
        // 현재 위치와 부모 노드가 일치할 경우 해당 값을 리턴,
        if(parent[x] == x) return x;
        // 일치하지 않을 경우 해당 위치로 재귀호출한다.
        return find(parent[x]);
    }

    static void union(int x, int y){
        // x, y의 부모 노드를 찾고
        x = find(x);
        y = find(y);

        // 둘 중 작은 곳으로 부모 노드를 설정한다.
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
}
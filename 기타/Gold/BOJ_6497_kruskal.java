import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // 1. 집의 수 m, 길의 수 n,
    static int m, n;
    // 가중치 기준 오름차순으로 그래프 정보를 저장할 graph, 부모 노드 parent,
    static ArrayList<House> graph;
    static int[] parent;
    // 전체 비용 sum, MST의 값 min을 선언한다.
    static int sum, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. m, n이 0, 0이 될 때 까지 입력받는다.
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0) break;

            // 3. graph, parent의 크기를 설정하고
            // parent의 초기값을 설정한다.
            graph = new ArrayList<>();
            parent = new int[m + 1];
            for(int i = 1 ; i <= m ; i++){
                parent[i] = i;
            }

            // 4. sum, min을 초기화하고 n만큼의 정보를
            sum = 0;
            min = 0;
            for(int i = 0 ; i < n ; i++){
                st = new StringTokenizer(br.readLine(), " ");
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());

                // graph에 저장하고 sum에 추가한다.
                graph.add(new House(start, end, cost));
                sum += cost;
            }

            // 5. 가중치 기준 오름차순으로 graph를 정렬한 뒤
            Collections.sort(graph, (o1, o2) -> o1.cost - o2.cost);
            // 크루스칼 알고리즘을 호출해 MST를 완성하고
            kruskal();
            // sum - min을 출력한다.
            bw.write(sum - min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static class House{
        int a;
        int b;
        int cost;

        public House(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static void kruskal(){
        // 그래프를 돌면서
        for(int i = 0 ; i < graph.size() ; i++){
            // 현재 정보의 출발 노드와 도착 노드의 부모가 일치하지 않을 경우
            House now = graph.get(i);
            if(find(now.a) != find(now.b)){
                // 현재 가중치를 추가하고 두 노드의 부모 노드를 설정한다.
                min += now.cost;
                union(now.a, now.b);
            }
        }
    }

    static int find(int x){
        // 현재 위치와 부모 노드가 일치할 경우 해당 값 리턴
        if(x == parent[x]) return x;
        // 일치하지 않을 경우 해당 위치로 재귀호출
        else return find(parent[x]);
    }

    static void union(int x, int y){
        // x와 y의 부모 노드를 찾는다.
        x = find(x);
        y = find(y);

        // 두 노드 중 작은 곳으로 부모 노드를 설정한다.
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
}
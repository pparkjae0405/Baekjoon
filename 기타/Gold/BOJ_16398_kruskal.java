import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    // 1. 행성의 수 N,
    static int N;
    // 연결 정보 graph, 부모 노드 parent,
    static ArrayList<Planet> graph;
    static int[] parent;
    // MST값 result를 선언한다.
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어지고
        N = Integer.parseInt(br.readLine());
        // graph와 parent의 크기를 설정하고
        graph = new ArrayList<>();
        parent = new int[N + 1];
        // parent를 초기화한다.
        for(int i = 1 ; i <= N ; i++){
            parent[i] = i;
        }

        // 3. N*N만큼 연결 정보가 주어지고
        StringTokenizer st;
        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++){
                int value = Integer.parseInt(st.nextToken());
                if(j <= i) continue;

                // graph에 저장한다.
                graph.add(new Planet(i, j, value));
            }
        }

        // 4. graph를 가중치 기준 오름차순으로 정렬한 뒤
        Collections.sort(graph, (o1, o2) -> o1.cost - o2.cost);
        // kruskal 알고리즘을 호출하여 result를 출력한다.
        kruskal();
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Planet{
        int a;
        int b;
        int cost;

        public Planet(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static void kruskal(){
        // 그래프를 돌면서
        for(int i = 0 ; i < graph.size() ; i++){
            // 현재 정보를 가져와
            Planet now = graph.get(i);
            // 출발 노드와 도착 노드의 부모가 일치하지 않을 경우
            if(find(now.a) != find(now.b)){
                // 현재 가중치를 추가하고 두 노드의 부모 노드를 설정한다.
                result += now.cost;
                union(now.a, now.b);
            }
        }
    }

    static int find(int x){
        // 현재 위치와 부모 노드가 일치할 경우 해당 값을 리턴하고
        if(x == parent[x]) return x;
        // 이외에는 해당 위치로 재귀호출한다.
        return find(parent[x]);
    }

    static void union(int x, int y){
        // x와 y의 부모 노드를 찾아
        x = find(x);
        y = find(y);

        // 더 작은 곳으로 부모 노드를 설정한다.
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
}
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    // 1. 2차원 ArrayList(메모리를 절약하기 위해) graph
    // 각 노드가 몇 번째로 방문되었는지 저장할 order
    // 순서 cnt를 1로 선언한다.
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] order;
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 2. 정점의 수 N, 간선의 수 M, 시작 정점 R이 주어진다.
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        // 3. visited를 N+1(노드의 번호와 맞추기 위해)로 크기를 초기화하고
        order = new int[N+1];

        // 4. 2차원 ArrayList를 정점의 수 N만큼 추가한 뒤
        for(int i = 0 ; i <= N ; i++){
            graph.add(new ArrayList<Integer>());
        }

        // 5. 간선 개수 M만큼 정점 u와 v의 정보를 받아서
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 해당 정점에 어떤 정점이 연결되어 있는지 추가하고
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // 6. 그래프 요소들을 오름차순 정렬하고
        for(int i = 1 ; i <= N ; i++){
            Collections.sort(graph.get(i));
        }

        // 7. 재귀를 이용하여 dfs를 수행하여 출력하는데
        dfs(R);
        for (int i = 1; i < order.length; i++) {
            bw.write(order[i]+"\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start){
        // 8. dfs의 재귀 사용법에 따라
        // 8-1. 탐색 시작 노드를 방문처리한다.(여기서는 순서 저장)
        order[start] = cnt;
        // 8-2. 방문 노드를 출력한다.(visited 대신 순서를 저장하므로 생략)
        for(int i = 0 ; i < graph.get(start).size() ; i++){
            // 8-3. 방문 노드에 인접한 노드(가장 작은 값)를 찾고,
            int closeNode = graph.get(start).get(i);
            // 방문한 적이 없다면(값이 없다면) 재귀를 수행한다.
            if(order[closeNode] == 0){
                cnt++;
                dfs(closeNode);
            }
        }
    }
}
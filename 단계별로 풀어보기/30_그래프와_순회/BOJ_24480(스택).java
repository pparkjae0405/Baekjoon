import java.io.*;
import java.util.*;

public class Main{
    // 1. 2차원 ArrayList(메모리를 절약하기 위해) graph
    // 각 노드의 방문여부를 확인할 visited
    // 각 노드가 몇 번째로 방문되었는지 저장할 order
    // 순서 cnt를 1로 선언한다.
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
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
        // 3. visited와 order를 N+1(노드의 번호와 맞추기 위해)로 크기를 초기화하고
        visited = new boolean[N+1];
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

        // 6. 그래프 요소들을 내림차순으로 정렬한 뒤
        for(int i = 1 ; i <= N ; i++){
            Collections.sort(graph.get(i), Collections.reverseOrder());
        }

        // 7. 스택을 이용하여 dfs를 수행한 결과를 출력하는데
        dfs(R);
        for(int i = 1 ; i < order.length ; i++){
            bw.write(order[i] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int start){
        // 8. dfs의 스택 사용법에 따라
        // 8-1. 스택을 선언하고 탐색 시작 노드를 스택에 삽입한다.
        Stack<Integer> stack = new Stack<>();
        stack.push(start);

        // 8-2. 스택이 빌 때까지 반복하는데
        while(stack.empty() == false){
            // 스택 맨 위에 있는 방문노드를 뽑고
            int node = stack.pop();

            // 방문한 노드라면 아래를 생략하고
            if(visited[node]){
                continue;
            }

            // 아니라면 노드를 방문처리하고 order에 해당 노드의 방문 순서를 저장한 뒤
            visited[node] = true;
            order[node] = cnt++;

            // 해당 노드에 인접한 노드를 찾아
            for(int i = 0 ; i < graph.get(node).size(); i++){
                int closeNode = graph.get(node).get(i);
                // 방문한 적이 없다면 스택에 넣고 탈출한다.
                if(visited[closeNode] == false){
                    stack.push(closeNode);
                    break;
                }
            }

        }
    }
}
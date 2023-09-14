import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    // 1. 집의 개수 N, 길의 개수 M,
    static int N, M;
    // 마을 정보 town, 부모 노드 parent,
    static ArrayList<Town> town;
    static int[] parent;
    // 길 유지비 합의 최솟값 min, 그 중 최댓값 max를 선언한다.
    static int min = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. town, parent를 초기화하고
        town = new ArrayList<>();
        parent = new int[N + 1];
        // parent의 초기값을 설정한다.
        for(int i = 1 ; i <= N ; i++){
            parent[i] = i;
        }

        // 4. 시작 마을, 도착 마을, 가중치 정보를 town에 저장하고
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            town.add(new Town(start, end, cost));
        }
        // 가중치 기준 오름차순으로 정렬한다.
        Collections.sort(town, (o1, o2) -> o1.cost - o2.cost);

        // 5. 크루스칼 알고리즘을 호출하여 MST를 완성하고
        kruskal();
        // 가장 가중치가 높은 값을 빼서 출력한다.
        bw.write(min - max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Town{
        int a;
        int b;
        int cost;

        public Town(int a, int b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static void kruskal(){
        // 정보를 돌면서
        for(int i = 0 ; i < town.size() ; i++){
            // 현재 정보를 가져와
            Town now = town.get(i);
            // 출발 지점과 도착 노드의 부모 노드가 다를 경우
            if(find(now.a) != find(now.b)){
                // 가중치를 추가하고 부모 노드를 설정하고,
                min += now.cost;
                union(now.a, now.b);

                // 현재 가중치를 저장한다.
                max = now.cost;
            }
        }
    }

    static int find(int x){
        // 해당 노드와 부모 노드가 같으면 해당 값 리턴
        if(x == parent[x]) return x;
        // 이외에는 부모 노드로 재귀 호출
        else return find(parent[x]);
    }

    static void union(int x, int y){
        // x, y의 부모 노드를 찾고
        x = find(x);
        y = find(y);

        // 더 작은 곳으로 부모 노드를 설정한다.
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
}
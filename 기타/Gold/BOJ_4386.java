import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main{
    // 1. 별의 개수 n,
    static int n;
    // 별의 정보 star, 부모 노드 parent, 최소 비용 min을 선언한다.
    static ArrayList<Star> star;
    static int[] parent;
    static double min = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. n이 주어진다.
        n = Integer.parseInt(br.readLine());

        // 3. star와 parent를 초기화하고
        star = new ArrayList<>();
        parent = new int[n + 1];
        // parent의 초기값을 설정한다.
        for(int i = 1 ; i <= n ; i++){
            parent[i] = i;
        }

        // 4. 각 별의 좌표가 주어지고 info에 저장한 뒤
        double[][] info = new double[n + 1][2];
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine() , " ");
            info[i][0] = Double.parseDouble(st.nextToken());
            info[i][1] = Double.parseDouble(st.nextToken());
        }
        // 경우의 수를 돌면서 출발 지점, 도착 지점, 가중치를 찾아 star에 추가한다.
        for(int i = 0 ; i < n - 1 ; i++){
            for(int j = i + 1 ; j < n ; j++){
                double cost = Math.sqrt(Math.pow(info[j][0] - info[i][0], 2) +
                        Math.pow(info[j][1] - info[i][1], 2));

                star.add(new Star(i + 1, j + 1, cost));
            }
        }

        // 5. star를 가중치 기준 오름차순으로 정렬한다.
        Collections.sort(star, (o1, o2) -> Double.compare(o1.cost, o2.cost));

        // 6. 크루스칼 알고리즘을 호출하여 min을 출력한다.
        kruskal();
        bw.write(Math.round(min * 100) / 100.0 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Star{
        int a;
        int b;
        double cost;

        public Star(int a, int b, double cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    static void kruskal(){
        // 정보를 돌면서
        for(int i = 0 ; i < star.size() ; i++){
            // 출발노드와 도착노드의 부모노드가 다를 경우
            Star now = star.get(i);
            if(find(now.a) != find(now.b)){
                // 가중치를 추가하고 부모노드를 설정한다.
                min += now.cost;
                union(now.a, now.b);
            }
        }
    }

    static int find(int x){
        // 현재 위치와 부모 노드가 같을 경우 해당 값 리턴
        if(x == parent[x]) return x;
        // 이외에는 부모 노드로 재귀호출
        else return find(parent[x]);
    }

    static void union(int x, int y){
        // x, y의 부모 노드를 찾고
        x = find(x);
        y = find(y);

        // 더 작은 곳으로 부모노드를 설정한다.
        if(x < y) parent[y] = x;
        else parent[x] = y;
    }
}
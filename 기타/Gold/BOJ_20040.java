import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 노드의 개수 N, 진행된 차례의 수 M,
    static int N, M;
    // 부모 노드 parent, 완성되는 차례의 수 result를 선언한다.
    static int[] parent;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. parent의 크기를 설정하고, 초기값을 저장한다.
        parent = new int[N];
        for(int i = 0 ; i < N ; i++){
            parent[i] = i;
        }

        // 4. 1 ~ M까지 돌면서 출발 노드, 도착 노드가 주어지면
        for(int i = 1 ; i <= M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 사이클이 형성되는지 확인하여 해당 번째를 result로 설정하고 종료한다.
            if(!union(start, end)){
                result = i;
                break;
            }
        }

        // 5. 탐색 종료 시의 result를 출력한다.
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static boolean union(int x, int y){
        x = find(x);
        y = find(y);

        if(x == y) return false;
        parent[y] = x;
        return true;
    }

    static int find(int x){
        if(x == parent[x]) return x;
        else return find(parent[x]);
    }
}
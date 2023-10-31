import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    // 1. 돌다리의 개수 n,
    static int n;
    // 돌다리에 적힌 번호정보 bridge, 방문 여부 visited,
    static int[] bridge;
    static boolean[] visited;
    // bfs를 위한 큐를 선언한다.
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. n이 주어지고
        n = Integer.parseInt(br.readLine());
        // bridge, visited의 크기를 설정한 뒤
        bridge = new int[n];
        visited = new boolean[n];
        // bridge 정보를 저장한다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 출발점 s가 주어지면 bfs를 호출하여
        int s = Integer.parseInt(br.readLine());
        bfs(s - 1);
        // 방문 가능한 돌들의 개수를 출력한다.
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            if(visited[i]) count++;
        }
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        // 시작 위치를 방문처리하고 큐에 추가한다.
        visited[start] = true;
        queue.add(start);

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 정보를 가져와
            int now = queue.poll();

            // 해당하는 위치에 적혀있는 값에 따라 좌우로 이동하여
            int left = now - bridge[now];
            int right = now + bridge[now];

            // 해당 위치가 범위 내에 있고
            // 방문하지 않았다면
            // 방문처리하고 큐에 추가한다.
            if(left >= 0 && left < n){
                if(!visited[left]){
                    visited[left] = true;
                    queue.add(left);
                }
            }
            if(right >= 0 && right < n){
                if(!visited[right]){
                    visited[right] = true;
                    queue.add(right);
                }
            }
        }
    }
}
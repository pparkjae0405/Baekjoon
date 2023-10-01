import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 컴퓨터의 개수 N, 연결 개수 M,
    static int N, M;
    // 컴퓨터 연결 정보 conn, 컴퓨터 방문 여부 visited,
    static ArrayList<Integer>[] conn;
    static boolean[] visited;
    // 최댓값 max, 최대 개수 저장 arr, bfs를 위한 큐를 선언한다.
    static int max = 0;
    static int[] arr;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. conn, arr의 크기를 설정한 뒤 conn를 초기화하고
        conn = new ArrayList[N + 1];
        arr = new int[N + 1];
        for(int i = 1 ; i <= N ; i++){
            conn[i] = new ArrayList<>();
        }

        // 4. M만큼 연결 정보가 주어지고
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // conn에 저장한다.
            conn[start].add(end);
        }

        // 5. 1 ~ N까지의 컴퓨터를 돌면서
        for(int i = 1 ; i <= N ; i++) {
            // visited, arr를 초기화하고 bfs를 호출하고
            visited = new boolean[N + 1];
            bfs(i);
        }

        // 6. arr을 돌면서 max값을 찾고, max값인 컴퓨터를 출력한다.
        for(int i = 1 ; i <= N ; i++){
            if(max < arr[i]) max = arr[i];
        }
        for(int i = 1 ; i <= N ; i++){
            if(arr[i] == max) bw.write(i + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(int start){
        // 시작 위치를 큐에 추가하고 방문처리한다.
        queue.add(start);
        visited[start] = true;

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 위치를 가져와
            int now = queue.poll();

            // 연결된 컴퓨터들의 정보 중
            for(int next : conn[now]){
                // 방문하지 않은 컴퓨터가 있다면
                if(!visited[next]){
                    // arr 추가 및 방문처리 뒤 큐에 추가한다.
                    arr[next]++;
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }
}
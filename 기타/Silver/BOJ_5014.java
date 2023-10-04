import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 건물의 총 높이 F, 현재 위치 S,
    // 목표 지점 G, 위로 U층 가는 버튼, 아래로 D층 가는 버튼,
    static int F, G, S, U, D;
    // 건물 정보 info, 방문 여부 visited,
    static int[] info;
    static boolean[] visited;
    // bfs를 위한 큐를 선언한다.
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. F, S, G, U, D가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        // 3. info, visited의 크기를 설정하고
        info = new int[F + 1];
        visited = new boolean[F + 1];
        // S와 G가 같다면 0을 출력하고
        if(S == G){
            bw.write(0 + "\n");
        }else {
            // 이외에는 시작 지점을 큐에 추가하고 방문처리한다.
            queue.add(S);
            visited[S] = true;

            // 4. bfs를 호출하여 S부터 G까지의 버튼의 최솟값을 출력한다.
            bfs();
            if (info[G] == 0) {
                bw.write("use the stairs" + "\n");
            } else {
                bw.write(info[G] + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        // 큐가 빌 때 까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 가져와
            int now = queue.poll();
            // 현재 위치가 G와 같을 경우 종료하고
            if(now == G) return;

            // 이외에는 위로 U층, 아래로 D층 가는 경우를 탐색하는데
            int nextU = now + U;
            int nextD = now - D;

            // 해당 위치가 범위 안이고 방문하지 않았을 경우
            // 방문처리하고 +1하여 저장한 뒤 큐에 추가한다.
            if(nextU > 0 && nextU <= F){
                if(!visited[nextU]) {
                    visited[nextU] = true;
                    info[nextU] = info[now] + 1;
                    queue.add(nextU);
                }
            }
            if(nextD > 0 && nextD <= F){
                if(!visited[nextD]) {
                    visited[nextD] = true;
                    info[nextD] = info[now] + 1;
                    queue.add(nextD);
                }
            }
        }
    }
}
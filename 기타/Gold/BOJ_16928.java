import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 1 ~ 100칸까지의 보드판 board와 방문 여부 visited,
        int[] board = new int[101];
        boolean[] visited = new boolean[101];
        // 이동 방향 d, bfs를 위한 큐를 선언한다.
        int[] d = {1, 2, 3, 4, 5, 6};
        Queue<Integer> queue = new LinkedList<>();

        // 2. 사다리의 수 N, 뱀의 수 M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 해시맵을 사용해 <사다리&뱀의 위치:이동하는 위치>로 저장한다.
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < N + M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int key = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            hashMap.put(key, value);
        }

        // 3. 시작 위치를 큐에 넣고 방문처리한 뒤
        queue.add(1);
        visited[1] = true;

        // 4. 큐가 빌 때까지 반복하여
        while(!queue.isEmpty()){
            // 현재 위치를 빼낸 뒤
            int now = queue.poll();

            // 주사위가 나오는 경우로 이동하는데
            for(int i = 0 ; i < 6 ; i++){
                int next = now + d[i];

                // next가 보드판 범위 내에 존재하고
                if(next >= 1 && next <= 100) {
                    // 해당 칸이 방문하지 않았다면
                    if (!visited[next]) {
                        // 해당 칸을 방문처리하고
                        visited[next] = true;

                        // 해당 칸이 사다리나 뱀이라면
                        if (hashMap.containsKey(next)) {
                            // 사다리나 뱀을 통해 이동되는 칸이 방문하지 않은 곳이라면
                            if(!visited[hashMap.get(next)]) {
                                // 이동되는 칸을 방문처리하고
                                visited[hashMap.get(next)] = true;

                                // 해당 칸의 값을 1 추가하여 저장한 뒤 큐에 추가한다.
                                board[hashMap.get(next)] = board[now] + 1;
                                queue.add(hashMap.get(next));
                            }
                        }else{
                            // 해당 칸이 사다리나 뱀이 아니라면
                            // 해당 칸의 값을 1 추가하여 저장한 뒤 큐에 추가
                            board[next] = board[now] + 1;
                            queue.add(next);
                        }
                    }
                }
            }
        }

        // 5. 100칸까지 가는 최소 횟수를 출력한다.
        bw.write(board[100] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main{
    // 1. 수빈이가 있는 위치 N, 동생이 있는 위치 K,
    static int N, K;
    // 좌표를 표현할 line, 0-1 bfs를 위한 Deque를 선언한다.
    static int[] line;
    static Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        0-1 너비 우선 탐색
        가중치가 0, 1만 좀재하는 그래프에서 최단 경로를 찾는 알고리즘
        Deque를 사용하여 0이면 맨앞에, 1이면 맨뒤에 추가하여 빠르게 최단 경로를 찾는다.
         */

        // 2. N, K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        // 3. line의 크기를 설정하고 -1로 초기화한다.
        line = new int[100001];
        Arrays.fill(line, -1);

        // 4. 시작 지점부터 탐색을 시작해
        bfs0_1(N);
        // 도착 지점까지의 최단 시간을 출력한다.
        bw.write(line[K] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs0_1(int start){
        // 시작 지점을 0으로 설정하고 Deque에 추가한다.
        line[start] = 0;
        deque.offer(start);

        // deque가 빌 때 까지 반복하여
        while(!deque.isEmpty()){
            // 현재 위치를 가져오고
            int now = deque.poll();
            // 현재 위치가 K와 같다면 종료
            if(now == K){
                return;
            }

            // 같지 않다면 순간이동, 걷기를 하는데
            // 순간이동한 위치가 K 이하이고 -1이라면
            if(now * 2 <= 100000 && line[now * 2] == -1){
                // deque의 맨 앞에 추가하고, 현재 위치값과 동일하게 바꾼다.
                deque.addFirst(now * 2);
                line[now * 2] = line[now];
            }

            // 왼쪽으로 걸었다면
            if(now > 0 && line[now - 1] == -1){
                // deque의 뒤에 추가하고 현재 위치값 + 1로 저장한다.
                deque.offer(now - 1);
                line[now - 1] = line[now] + 1;
            }

            // 오른쪽으로 걸었다면
            if(now < 100000 && line[now + 1] == -1){
                // deque의 뒤에 추가하고 현재 위치값 + 1로 저장한다.
                deque.offer(now + 1);
                line[now + 1] = line[now] + 1;
            }

        }
    }
}
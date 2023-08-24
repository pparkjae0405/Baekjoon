import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 시작 정수 A, 도착 정수 B
    static long A, B;
    // bfs를 위한 큐, 연산 횟수 count를 선언한다.
    static Queue<Long> queue = new LinkedList<>();
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. A, B가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        // 3. bfs를 통해 count를 출력한다.
        bw.write(bfs() + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(){
        // 시작 위치를 방문처리하고 큐에 넣은 뒤
        queue.add(A);

        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 현재 큐의 크기를 가져와
            int size = queue.size();

            // 크기만큼 값을 꺼내 연산을 수행하여
            for(int i = 0 ; i < size ; i++){
                long now = queue.poll();

                // B에 도달했을 경우 count + 1 을 반환,
                if(now == B){
                    return count + 1;
                }

                // 그외에는 범위 연산값이 범위 안일 경우 큐에 추가한다.
                if(now * 2 <= B) queue.add(now * 2);
                if((now * 10) + 1 <= B) queue.add((now * 10) + 1);
            }
            // 연산 종료 시 count 증가
            count++;
        }

        // 반환되지 않았을 경우 -1 반환
        return -1;
    }
}
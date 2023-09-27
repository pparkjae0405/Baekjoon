import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스의 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 케이스를 입력받는데
        StringTokenizer st = null;
        for(int i = 0 ; i < T ; i++){
            // 수열의 크기 M를 입력받고 중앙값의 개수를 출력,
            int M = Integer.parseInt(br.readLine());
            bw.write((M + 1) / 2 + "\n");

            // 최솟값, 최댓값 우선순위 큐를 선언하고
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            PriorityQueue<Integer> maxPq = new PriorityQueue<>((o1, o2) -> o2 - o1);

            // 3. 수열의 원소가 M만큼 주어지는데
            int count = 0;
            for(int j = 0 ; j < M ; j++){
                // 줄바꿈 시 새로 받아오고
                if(j % 10 == 0) st = new StringTokenizer(br.readLine(), " ");
                int num = Integer.parseInt(st.nextToken());

                // max와 min의 크기가 같을 경우 max에 추가,
                if(maxPq.size() == minPq.size()){
                    maxPq.offer(num);
                }else{
                    // 이외에는 min에 추가한다.
                    minPq.offer(num);
                }

                // 4. minPq가 비어있지 않다면
                if(!minPq.isEmpty()){
                    // max와 min의 맨 앞의 값을 확인해
                    if(maxPq.peek() > minPq.peek()){
                        // max가 더 클 경우 서로 바꾼다.
                        int a = maxPq.poll();
                        int b = minPq.poll();

                        maxPq.offer(b);
                        minPq.offer(a);
                    }
                }

                // 5. i가 짝수번째이고
                if(j % 2 == 0){
                    // count가 9이거나 j가 M-1과 같다면
                    if(count == 9 || j == M - 1){
                        // max의 맨 앞의 값을 출력하고 count를 0으로 초기화,
                        bw.write(maxPq.peek() + "\n");
                        count = 0;
                    }else{
                        // 이외에는 max의 맨 앞 값을 출력한다.
                        bw.write(maxPq.peek() + " ");
                    }
                    // 종료 시 count를 증가시킨다.
                    count++;
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
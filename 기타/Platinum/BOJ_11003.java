import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N과 L이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        // 2. N개의 수 Ai가 주어지고 arr에 저장한다.
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 덱을 선언하고 탐색하는데
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0 ; i < N ; i++){
            // 덱에 값이 있으면 덱의 마지막 값 > 현재 인덱스의 값일 경우 삭제
            while(!deque.isEmpty() && arr[deque.getLast()] > arr[i]){
                deque.removeLast();
            }

            // 현재 인덱스를 추가하고
            deque.offer(i);

            // 덱의 첫 번째 인덱스 < i-L+1라면 범위를 벗어났으므로
            if(deque.getFirst() < i - L + 1){
                // 해당 인덱스를 삭제하고
                deque.removeFirst();
            }

            // 덱의 맨 앞에 있는 인덱스의 값을 출력한다.
            bw.write(arr[deque.peekFirst()] + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
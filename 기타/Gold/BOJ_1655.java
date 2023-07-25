import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 정수의 개수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 중앙값을 찾기 위해 반으로 나눠 왼쪽의 최댓값을 반환하는 left,
        // 오른쪽의 최솟값을 반환하는 right 우선순위 큐를 선언한다.
        PriorityQueue<Integer> left = new PriorityQueue<Integer>(Comparator.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<Integer>();

        // 3. N만큼 정수가 주어지는데
        for(int i = 0 ; i < N ; i++){
            int a = Integer.parseInt(br.readLine());
            // left와 right의 사이즈가 같으면 left에,
            if(left.size() == right.size()){
                left.offer(a);
            }else{
                // 그 외에는 right에 저장한다.
                right.offer(a);
            }

            // 두 큐가 비어있지 않을 때
            if(!left.isEmpty() && !right.isEmpty()) {
                // left의 최댓값 < right의 최솟값이라면
                if(right.peek() < left.peek()){
                    // 두 값을 바꿔 저장하고
                    int temp = right.poll();
                    right.offer(left.poll());
                    left.offer(temp);
                }
            }
            // left의 최댓값을 출력한다.
            bw.write(left.peek() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
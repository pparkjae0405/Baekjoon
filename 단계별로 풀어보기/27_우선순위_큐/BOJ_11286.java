import java.io.*;
import java.util.*;
import java.lang.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 연산의 개수 N, 절대값 비교 순서의 우선순위 큐 a를 선언하고
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> a = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            // Comparator를 통해 비교기준을 만드는데
            public int compare(Integer o1, Integer o2) {
                int A = Math.abs(o1);
                int B = Math.abs(o2);
                // compare(Object left, Object right)의 리턴값이
                // -1일 경우 left가 왼쪽에 오고(left right)
                // 0일 경우 left와 right가 같으며
                // 1일 경우 left가 오른쪽에 와야하므로(right left)

                // 절대값이 A > B라면
                // B A 순으로 저장되므로 1을 리턴하고,
                if(A > B){
                    return 1;
                }else if(A == B){
                    // 절대값이 가장 작은 값이 여러개라면 실제 값을 비교,
                    // left > right일 경우
                    // right left 순으로 저장되므로 1을 리턴하고,
                    if(o1 > o2){
                        return 1;
                    }else{
                        // left < right일 경우
                        // left right 순으로 저장되므로 -1을 리턴하고,
                        return -1;
                    }
                }else{
                    // A < B라면
                    // A B 순으로 저장되므로 -1을 리턴한다.
                    return -1;
                }
            }
        });

        // 2. 그 후 연산 정보를 나타내는 정수 x가 N개 주어지는데
        for(int i = 0 ; i < N ; i++){
            int x = Integer.parseInt(br.readLine());
            // 0일 경우 비어있다면 0을 출력하고,
            if(x == 0){
                if(a.isEmpty()){
                    bw.write(0 + "\n");
                }else{
                    // 비어있지 않다면 기준 값을 출력,
                    bw.write(a.poll() + "\n");
                }
            }else{
                // 0이 아니라면 기준 값을 a에 추가한다.
                a.add(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
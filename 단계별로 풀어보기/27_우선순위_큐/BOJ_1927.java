import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 연산의 개수 N, 높은 숫자 순서의 우선순위 큐 a를 선언한다.
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> a = new PriorityQueue<Integer>();

        // 2. 연산 정보를 나타내는 정수 x가 N개 주어지는데
        for(int i = 0 ; i < N ; i++){
            int x = Integer.parseInt(br.readLine());
            // 0일 경우 비어있다면 0을 출력,
            if(x == 0){
                if(a.isEmpty()){
                    bw.write(0 + "\n");
                }else{
                    // 비어있지 않다면 가장 작은 값을 출력하고
                    bw.write(a.poll() + "\n");
                }
            }else if(x > 0) {
                // 자연수라면 배열에 x를 추가한다.
                a.add(x);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
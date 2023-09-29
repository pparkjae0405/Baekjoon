import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N개의 (정수값, 해당 위치)를 저장하고
        Node[] arr = new Node[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }
        // 정수값 기준 오름차순으로 정렬한다.
        Arrays.sort(arr);

        // 3. max를 선언하고
        int max = 0;
        // 1 ~ N까지 돌면서 max값을 갱신한다.
        for(int i = 0 ; i < N ; i++){
            max = Math.max(max, arr[i].idx - i);
        }

        // 4. max값을 출력한다.
        bw.write((max + 1) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static class Node implements Comparable<Node>{
        // 값, 위치
        int v;
        int idx;

        public Node(int v, int idx) {
            this.v = v;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return v - o.v;
        }
    }
}
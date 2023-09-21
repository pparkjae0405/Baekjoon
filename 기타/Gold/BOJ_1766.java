import java.io.*;
import java.util.*;

public class Main{
    // 1. 문제의 수 N, 문제 정보의 개수 M,
    static int N, M;
    // 문제 정보를 표현할 problem, 진입차수 degree,
    static ArrayList<Integer>[] problem;
    static int[] degree;
    // 탐색을 위한 pq, 출력을 위한 sb를 선언한다.
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. student를 초기화, degree의 크기를 설정하고
        problem = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++){
            problem[i] = new ArrayList<>();
        }
        degree = new int[N + 1];
        // 연결 정보를 받아 저장하고 진입차수를 추가한다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            problem[start].add(end);
            degree[end]++;
        }

        // 4. 진입차수가 0인 모든 노드를 큐에 넣고
        for(int i = 1 ; i <= N ; i++){
            if(degree[i] == 0) pq.add(i);
        }
        // 위상정렬을 호출하여 순서를 출력한다.
        sort();
        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void sort(){
        // pq가 빌 때 까지
        while(!pq.isEmpty()){
            // pq에서 원소를 꺼내 sb에 저장하고
            int now = pq.poll();
            sb.append(now).append(" ");

            // 해당 노드에서 나가는 간선을 그래프에서 제거하고
            for(int next : problem[now]){
                degree[next]--;

                // 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.
                if(degree[next] == 0) pq.add(next);
            }
        }
    }
}
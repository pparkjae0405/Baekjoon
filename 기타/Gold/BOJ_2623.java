import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 가수의 수 N, 보조 PD의 수 M,
    static int N, M;
    // 가수 정보를 표현할 singer, 진입차수 degree,
    static ArrayList<Integer>[] singer;
    static int[] degree;
    // 탐색을 위한 큐, 출력을 위한 result를 선언한다.
    static Queue<Integer> queue = new LinkedList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. student를 초기화, degree의 크기를 설정하고
        singer = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++){
            singer[i] = new ArrayList<>();
        }
        degree = new int[N + 1];
        // 연결 정보를 받아
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int count = Integer.parseInt(st.nextToken());
            if(count == 0) continue;

            int start = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < count - 1 ; j++) {
                int end = Integer.parseInt(st.nextToken());

                // 저장하고 진입차수를 추가, start를 갱신한다.
                singer[start].add(end);
                degree[end]++;
                start = end;
            }
        }

        // 4. 진입차수가 0인 모든 노드를 큐에 넣은 뒤
        for(int i = 1 ; i <= N ; i++){
            if(degree[i] == 0) queue.add(i);
        }
        // 위상정렬을 호출하여 순서를 출력한다.
        sort();
        if(result.size() == N){
            for(int i = 0 ; i < result.size() ; i++){
                bw.write(result.get(i) + "\n");
            }
        }else{
            bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void sort(){
        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 큐에서 원소를 꺼내 result에 저장하고
            int now = queue.poll();
            result.add(now);

            // 해당 노드에서 나가는 간선을 그래프에서 제거하고
            for(int next : singer[now]){
                degree[next]--;

                // 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.
                if(degree[next] == 0) queue.add(next);
            }
        }
    }
}
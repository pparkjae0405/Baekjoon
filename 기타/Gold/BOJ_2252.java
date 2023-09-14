import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 학생 수 N, 비교 횟수 M,
    static int N, M;
    // 학새 정보를 표현할 student, 진입차수 degree,
    static ArrayList<Integer>[] student;
    static int[] degree;
    // 탐색을 위한 큐, 출력을 위한 sb를 선언한다.
    static Queue<Integer> queue = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        /*
        위상 정렬
        사이클이 없는 방향 그래프의 모든 노드를 방향성에 거스르지 않도록 순서대로 나열
        1. 진입차수가 0인 모든 노드를 큐에 넣는다.
        2. 큐에서 원소를 꺼내 해당 노드에서 나가는 간선을 그래프에서 제거한다.
        3. 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.
        4. 큐가 빌 때 까지 2, 3을 반복한다.
         */

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. student를 초기화, degree의 크기를 설정하고
        student = new ArrayList[N + 1];
        for(int i = 1 ; i <= N ; i++){
            student[i] = new ArrayList<>();
        }
        degree = new int[N + 1];
        // 연결 정보를 받아 저장하고 진입차수를 추가한다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            student[start].add(end);
            degree[end]++;
        }

        // 4. 진입차수가 0인 모든 노드를 큐에 넣고
        for(int i = 1 ; i <= N ; i++){
            if(degree[i] == 0) queue.add(i);
        }
        // 위상정렬을 호출하여 순서를 출력한다.
        sort();
        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void sort(){
        // 큐가 빌 때 까지
        while(!queue.isEmpty()){
            // 큐에서 원소를 꺼내 sb에 저장하고
            int now = queue.poll();
            sb.append(now).append(" ");

            // 해당 노드에서 나가는 간선을 그래프에서 제거하고
            for(int next : student[now]){
                degree[next]--;

                // 새롭게 진입차수가 0이 된 노드를 큐에 넣는다.
                if(degree[next] == 0) queue.add(next);
            }
        }
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 정점의 개수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N만큼 그래프의 인접 행렬이 주어진다.
        int[][] arr = new int[N][N];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 플로이드-워셜 알고리즘
        // 모든 정점에서 모든 정점으로의 최단 경로를 구하는 알고리즘,
        // a에서 b로 가는 최소 비용 VS a에서 중간 노드로 가는 비용 + 중간 노드에서 b로 가는 비용
        // 을 비교하여 최단 거리를 갱신하지만 현재 문제에서는 경로가 있는지만 판별하면 됨.

        // 3. 거쳐가는 노드 k
        for(int k = 0 ; k < N ; k++) {
            // 출발 노드 i
            for(int i = 0 ; i < N ; i++) {
                // 도착 노드 j
                for(int j = 0 ; j < N ; j++) {
                    // 경유가 가능하다면 i -> j로 가는 경우를 1로 설정한다.
                    if (arr[i][k] == 1 && arr[k][j] == 1) {
                        arr[i][j] = 1;
                    }
                }
            }
        }

        // 4. arr을 출력한다.
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
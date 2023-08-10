import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 유저의 수 N과 친구 관계의 수 M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 2차원 배열 kevin을 선언하고,
        // 자기 자신을 제외한 숫자를 INF(1000)으로 설정한다.
        int[][] kevin = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(i != j) kevin[i][j] = 1000;
            }
        }

        // 3. M만큼 친구 관계가 주어지고, 해당 위치를 1로 설정한다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            kevin[x][y] = 1;
            kevin[y][x] = 1;
        }

        // 4. 플로이드 워셜을 통해
        // a에서 b로 가는 최소 비용 VS a에서 중간 노드로 가는 비용 + 중간 노드에서 b로 가는 비용
        // 을 비교하여 최단 거리를 갱신한다.
        for(int k = 0 ; k < N ; k++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(kevin[i][j] > kevin[i][k] + kevin[k][j]){
                        kevin[i][j] = kevin[i][k] + kevin[k][j];
                    }
                }
            }
        }

        // 5. 케인 베이컨의 수가 가장 작은 경우와 그 사람(수가 같을 경우 번호가 작은 사람)을 찾아
        int min = Integer.MAX_VALUE;
        int ans = -1;
        for(int i = 0 ; i < N ; i++){
            int sum = 0;
            for(int j = 0 ; j < N ; j++){
                sum += kevin[i][j];
            }

            if(min > sum && ans < i){
                min = sum;
                ans = i;
            }
        }
        // 출력한다.
        bw.write(ans + 1 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
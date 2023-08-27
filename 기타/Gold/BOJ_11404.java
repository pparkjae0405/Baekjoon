import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 도시의 개수 n, 버스의 개수 m이 주어진다.
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        // 2. 도시 별 정보를 저장하고
        int[][] city = new int[n + 1][n + 1];
        // 자기 자신을 제외한 나머지를 INF로 초기화한 뒤
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i != j){
                    city[i][j] = 100000000;
                }
            }
        }

        // 3. 버스의 정보(출발도시 도착도시 버스비용)를 저장한다.
        StringTokenizer st;
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            // 노선 비용이 더 낮은 경우를 저장한다.
            if(city[start][end] > price) {
                city[start][end] = price;
            }
        }

        // 4. 플로이드 워셜을 통해
        for(int b = 1 ; b <= n ; b++){
            for(int a = 1 ; a <= n ; a++){
                for(int c = 1 ; c <= n ; c++){
                    // A -> C로 가는 비용보다 A -> B, B -> C로 가는 경우가 더 싸다면
                    if(city[a][c] > city[a][b] + city[b][c]){
                        // 해당 값을 갱신한다.
                        city[a][c] = city[a][b] + city[b][c];
                    }
                }
            }
        }

        // 5. 결과를 출력한다.
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(city[i][j] == 100000000) bw.write("0" + " ");
                else bw.write(city[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
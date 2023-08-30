import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    // 1. 도시의 크기 N, 고를 치킨집의 개수 M,
    static int N, M;
    // 도시 정보를 저장할 city, 집의 위치를 저장할 house,
    static int[][] city;
    static ArrayList<int[]> house = new ArrayList<>();
    // 치킨집의 위치를 저장할 chicken, 치킨집 방문 여부 visited,
    static ArrayList<int[]> chicken = new ArrayList<>();
    static boolean[] visited;
    // 도시의 치킨 거리 최솟값 min을 선언한다.
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. city의 크기를 설정하고
        city = new int[N][N];
        // 도시 정보와 치킨집의 개수를 저장한 뒤
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());

                // 값이 1이면 house에 추가, 2면 chicken에 추가한다.
                if(city[i][j] == 1) house.add(new int[]{i, j});
                else if(city[i][j] == 2) chicken.add(new int[]{i, j});
            }
        }

        // 4. 치킨집의 개수만큼 visited를 선언하고,
        // 백트래킹을 호출하여 M개를 고른 결과를 출력한다.
        visited = new boolean[chicken.size()];
        back(0, 0);
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth, int idx){
        // 치킨집 M개를 골랐다면
        if(depth == M){
            // 전체 집 치킨거리의 합을 선언하고
            int total = 0;

            // 하나의 집을 선택하여
            for(int i = 0 ; i < house.size() ; i++){
                int one = Integer.MAX_VALUE;
                for(int j = 0 ; j < chicken.size() ; j++){
                    // 고른 치킨집의 경우에만
                    if(visited[j]){
                        // 거리를 계산하여 최소 거리를 찾고,
                        int dist = Math.abs(house.get(i)[0] - chicken.get(j)[0])
                                + Math.abs(house.get(i)[1] - chicken.get(j)[1]);
                        one = Math.min(one, dist);
                    }
                }
                // 전체 집 치킨거리의 합에 추가한 뒤
                total += one;
            }

            // 최종적으로 min과 비교하고 종료시킨다.
            min = Math.min(total, min);
            return;
        }

        // 이외에는 치킨집의 개수만큼 돌면서
        for(int i = idx ; i < chicken.size() ; i++){
            // 방문하지 않았을 경우
            if(!visited[i]){
                // 방문처리하고
                visited[i] = true;
                // depth와 i를 1 증가시켜 재귀호출한 뒤
                back(depth + 1, i + 1);
                // 재귀가 종료되었을 경우 방문해제한다.
                visited[i] = false;
            }
        }
    }
}
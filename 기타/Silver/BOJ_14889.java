import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 1. 인원 수 N, 팀 능력치 team, 인원 방문 여부 visited, 차이의 최솟값 min을 선언한다.
    static int N;
    static int[][] team;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어지고
        N = Integer.parseInt(br.readLine());
        // team과 visited의 크기를 설정한다.
        team = new int[N][N];
        visited = new boolean[N];

        // 3. team 정보를 저장한다.
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                team[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. 백트래킹을 호출해 팀을 구성하고
        back(0, 0);
        // 최솟값을 출력한다.
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth, int idx){
        // 두 팀이 나누어졌다면
        if(depth == N / 2){
            // 두 팀의 능력치를 계산하여 차이를 갱신한다.
            cal();
            return;
        }

        // 이외에는 팀원을 돌면서
        for(int i = idx ; i < N ; i++){
            // 선택하고 재귀호출한 뒤
            visited[i] = true;
            back(depth + 1, i + 1);
            // 재귀 종료 시 선택해제한다.
            visited[i] = false;
        }
    }

    static void cal(){
        // 두 팀의 능력치를 선언하고
        int start = 0;
        int link = 0;
        for(int i = 0 ; i < N - 1 ; i++){
            for(int j = i + 1 ; j < N ; j++){
                // 두 선수가 start 소속일 경우
                if(visited[i] && visited[j]){
                    // start에 추가하고
                    start += (team[i][j] + team[j][i]);
                }else if(!visited[i] && !visited[j]){
                    // 두 선수가 link 소속일 경우 link에 추가해
                    link += (team[i][j] + team[j][i]);
                }
            }
        }

        // 두 팀의 능력치 차이를 계산하고
        int value = Math.abs(start - link);
        // 0일 경우 0으로 변경 후 종료,
        if(value == 0){
            min = 0;
            return;
        }
        // 이외에는 더 작은 값으로 갱신한다.
        min = Math.min(min, value);
    }
}
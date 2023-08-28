import java.io.*;

public class Main{
    // 1. N, N까지의 순열 selectArr, 방문 여부 visited,
    static int N;
    static int[] selectArr;
    static boolean[] visited;
    // 출력을 위한 sb를 선언한다.
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어지고 selectArr, visited의 크기를 설정한다.
        N = Integer.parseInt(br.readLine());
        selectArr = new int[N];
        visited = new boolean[N + 1];

        // 3. 백트래킹을 통해 1 ~ N까지의 수로 이루어진 순열을 출력한다.
        back(0);
        bw.write(sb + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth){
        // N개를 골랐을 경우
        if(depth == N){
            // 순열을 출력한다.
            for(int i = 0 ; i < N ; i++){
                sb.append(selectArr[i]).append(" ");
            }
            sb.append("\n");
        }

        // 그 외에는 1 ~ N까지 돌면서
        for(int i = 1 ; i <= N ; i++){
            // 선택하지 않았을 경우 방문처리하고
            if(!visited[i]){
                visited[i] = true;

                // selectArr에 저장한 뒤 depth를 증가시켜 재귀호출하여
                selectArr[depth] = i;
                back(depth + 1);
                // 재귀가 종료되면 방문해제한다.
                visited[i] = false;
            }
        }
    }
}
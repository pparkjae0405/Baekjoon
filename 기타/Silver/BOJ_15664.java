import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 1. 자연수의 개수 N, 선택 개수 M,
    static int N, M;
    // 자연수 정보 arr, 방문 여부 visited,
    static int[] arr;
    static boolean[] visited;
    // 선택한 수 selectArr, 출력을 위한 sb를 선언한다.
    static int[] beforeArr;
    static int[] selectArr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // arr, visited, selectArr의 크기를 설정한 뒤
        arr = new int[N];
        visited = new boolean[N];
        selectArr = new int[M];
        // arr의 정보를 저장하고 정렬한다.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 3. 백트래킹을 호출해 결과를 출력한다.
        back(0, 0);
        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth, int idx){
        // M개 선택했을 경우
        if(depth == M){
            // 해당 정보를 sb에 저장하고 종료한다.
            for(int i = 0; i < M; i++){
                sb.append(selectArr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        // 이외에는 arr을 돌면서
        int before = -1;
        for(int i = idx ; i < N ; i++){
            // 현재 값을 저장하고
            int now = arr[i];
            // 방문하지 않았고 이전 값과 같지 않다면
            if(!visited[i] && now != before){
                // before값을 현재 값으로 바꾸고
                before = now;
                // 방문처리 + 선택 + 재귀호출한 뒤
                visited[i] = true;
                selectArr[depth] = arr[i];
                back(depth + 1, i);
                // 재귀종료 시 방문해제한다.
                visited[i] = false;
            }
        }
    }
}
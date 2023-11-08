import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 1. 수의 개수 k, 수의 정보 arr, 방문 여부 visited,
    static int k;
    static int[] arr;
    static boolean[] visited;
    // 선택한 수 selectArr, 출력을 위한 sb를 선언한다.
    static int[] selectArr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 테스트 케이스가 주어지고
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            // k가 0이면 종료하고
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;

            // 이외에는 k만큼 arr, visited 크기를 설정하고
            arr = new int[k];
            visited = new boolean[k];
            // arr 정보를 저장한다.
            for(int i = 0 ; i < k ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 3. selectArr를 초기화하고 백트래킹을 호출한다.
            selectArr = new int[6];
            back(0, 0);
            sb.append("\n");
        }

        // 4. 경우의 수를 출력한다.
        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth, int idx){
        // 6개를 골랐을 경우
        if(depth == 6){
            // 해당 정보를 sb에 저장한다.
            for(int i = 0 ; i < 6 ; i++){
                sb.append(selectArr[i] + " ");
            }
            sb.append("\n");

            return;
        }

        // 이외에는 arr을 돌면서
        for(int i = idx ; i < k ; i++){
            // 방문하지 않았을 경우
            if(!visited[i]){
                // 방문처리 + 수 선택 + 재귀호출하고
                visited[i] = true;
                selectArr[depth] = arr[i];
                back(depth + 1, i);
                // 종료 시 방문해제한다.
                visited[i] = false;
            }
        }
    }
}
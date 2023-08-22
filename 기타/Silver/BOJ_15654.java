import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    // 1. 자연수의 개수 N, 그 중 선택할 개수 M,
    static int N, M;
    // 자연수를 저장할 배열 arr, M개를 선택할 배열 selectArr
    static int[] arr;
    static int[] selectArr;
    // 방문 여부 visited, 출력을 위한 sb를 선언한다.
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. N과 M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. arr, visited, selectArr의 크기를 설정하고
        arr = new int[N];
        visited = new boolean[N];
        selectArr = new int[M];
        // N개의 수를 받아 arr에 저장한 뒤 정렬한다.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 4. 백트래킹을 통해 N개 중 M개를 고르는 모든 경우의 수를 출력한다.
        back(0);
        System.out.println(sb);

        br.close();
    }

    static void back(int depth){
        // depth가 M과 같을 경우 selectArr을 출력하고 종료
        if(depth == M){
            for(int i = 0 ; i < M ; i++){
                sb.append(selectArr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        // 이외에는 N까지 돌면서
        for(int i = 0 ; i < N ; i++){
            // 방문하지 않았을 경우
            if(!visited[i]){
                // 해당 값을 selectArr에 저장하고 방문처리한 뒤
                selectArr[depth] = arr[i];
                visited[i] = true;

                // depth를 1 증가시켜 재귀호출하고 종료 시 방문처리를 해제해준다.
                back(depth + 1);
                visited[i] = false;
            }
        }
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 1. 배열의 개수 N, 배열 정보 arr, 방문 여부 visited,
    static int N;
    static int[] arr;
    static boolean[] visited;
    // 선택한 배열 selectArr, 최댓값 max를 선언한다.
    static int[] selectArr;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어지면 arr, visited, selectArr의 크기를 설정하고
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        selectArr = new int[N];
        // arr 정보를 저장한다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 백트래킹을 호출해 max를 출력한다.
        back(0);
        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth){
        // depth가 N과 같아졌다면
        if(depth == N){
            // 식을 계산하여 max를 갱신한다.
            int sum = 0;
            for(int i = 0 ; i < N - 1 ; i++){
                sum += Math.abs(selectArr[i] - selectArr[i + 1]);
            }
            max = Math.max(max, sum);

            return;
        }

        // 이외에는 arr를 돌면서
        for(int i = 0 ; i < N ; i++){
            // 방문하지 않은 값을
            if(!visited[i]){
                // 방문처리 + 선택하여 재귀호출하고
                visited[i] = true;
                selectArr[depth] = arr[i];
                back(depth + 1);
                // 재귀 종료 시 방문해제한다.
                visited[i] = false;
            }
        }
    }
}
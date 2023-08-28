import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    // 1. 자연수의 개수 N, 자연수 M,
    static int N, M;
    // N개의 수를 저장할 arr, M개를 고른 수열 selectArr, 방문 여부 visited,
    static int[] arr;
    static int[] selectArr;
    static boolean[] visited;
    // 출력을 위한 sb를 선언한다.
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // arr, visited, selectArr의 크기를 설정한다.
        arr = new int[N];
        visited = new boolean[N];
        selectArr = new int[M];

        // 3. N개의 수를 arr에 저장하고 정렬한다.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 4. 백트래킹을 통해 N개 중 M개를 오름차순으로 고른 수열을 출력한다.
        back(0);
        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth){
        // M개를 골랐을 경우
        if(depth == M){
            // 수열을 출력하고
            for (int i = 0; i < M; i++) {
                sb.append(selectArr[i]).append(" ");
            }
            sb.append("\n");

            // 종료한다.
            return;
        }

        // 그 외에는 arr을 돌면서
        for(int i = 0 ; i < N ; i++){
            // 고른 수를 selectArr에 저장 후 depth를 증가시켜 재귀호출한다.
            selectArr[depth] = arr[i];
            back(depth + 1);
        }
    }
}
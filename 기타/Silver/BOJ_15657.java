import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    // 1. 자연수의 개수 N, 자연수 M,
    static int N, M;
    // 수를 저장할 arr, M개를 고른 수열을 저장할 selectArr,
    static int[] arr;
    static int[] selectArr;
    // 출력을 위한 sb을 선언한다.
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 3. N만큼 arr배열을 선언하고 수를 저장한 뒤 정렬한다.
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 4. selectArr의 크기를 설정하고
        selectArr = new int[M];
        // 백트래킹을 통해 N개 중 M개를 고른 수열을 출력한다.
        back(0);
        System.out.print(sb);

        br.close();
    }

    static void back(int depth){
        // depth가 M과 같을 경우
        if(depth == M){
            // 비내림차순인지 확인하여
            boolean isDes = true;
            for(int i = 0 ; i < M - 1 ; i++){
                if(selectArr[i] > selectArr[i + 1]){
                    isDes = false;
                    break;
                }
            }

            if(isDes) {
                // 출력하고 종료
                for (int i = 0; i < M; i++) {
                    sb.append(selectArr[i]).append(" ");
                }
                sb.append("\n");
            }
            return;
        }

        // 그외의 경우 arr 배열을 돌면서 수를 선택하고
        for(int i = 0 ; i < N ; i++){
            selectArr[depth] = arr[i];
            // depth를 증가시켜 재귀호출한다.
            back(depth + 1);
        }
    }
}
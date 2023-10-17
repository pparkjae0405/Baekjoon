import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 1. 자연수의 개수 N, 자연수 M,
    static int N, M;
    // 배열 arr, 선택 배열 selectArr,
    static int[] arr;
    static int[] selectArr;
    // 출력을 위한 sb를 선언한다.
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 2. arr, selectArr의 크기를 설정하고
        arr = new int[N];
        selectArr = new int[M];
        // 배열정보를 arr에 저장한 뒤 정렬한다.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 3. 백트래킹을 호출해 값을 출력한다.
        back(0, 0);
        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int idx, int depth){
        // depth == M이면
        if(depth == M){
            // selectArr의 값을 출력하고 종료한다.
            for(int i = 0 ; i < M ; i++){
                sb.append(selectArr[i]).append(" ");
            }
            sb.append("\n");

            return;
        }

        // 이외에는 arr를 돌면서
        int before = 0;
        for(int i = idx ; i < N ; i++){
            // 이전값과 같을 경우 무시,
            if(before == arr[i]) continue;

            // 이외에는 값을 선택해 재귀호출하고
            selectArr[depth] = arr[i];
            back(i, depth + 1);
            // 종료 시 현재 값을 before에 저장한다.
            before = arr[i];
        }
    }
}
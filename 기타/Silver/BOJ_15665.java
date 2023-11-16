import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 1. 자연수 개수 N, 자연수 M,
    static int N, M;
    // 자연수 정보 arr, 선택한 정보 selectArr,
    static int[] arr;
    static int[] selectArr;
    // 출력을 위한 sb를 선언한다.
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, M이 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // arr, selectArr의 크기를 설정한 뒤
        arr = new int[N];
        selectArr = new int[M];
        // arr 정보를 저장하고 정렬한다.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        // 3. 백크래킹을 호출한 결과를 출력한다.
        back(0);
        bw.write(sb + "");

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth){
        // M만큼 선택했다면
        if(depth == M) {
            // 선택한 정보를 sb에 저장하고 종료한다.
            for(int i = 0 ; i < M ; i++){
                sb.append(selectArr[i] + " ");
            }
            sb.append("\n");

            return;
        }

        // 이외에는 arr을 돌면서
        int before = -1;
        for(int i = 0 ; i < N ; i++){
            // 이전에 선택한 수가 아닐 경우에
            int now = arr[i];
            if(before != now){
                // 수를 선택하고 재귀호출한다.
                before = now;
                selectArr[depth] = now;
                back(depth + 1);
            }
        }
    }
}
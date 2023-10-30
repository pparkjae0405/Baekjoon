import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 1. 정수의 개수 N과 정수 S, 정수 배열 arr,
    static int N, S;
    static int[] arr;
    // 부분수열의 개수 count를 선언한다.
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N, S가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        // 2. N만큼 정수를 저장한다.
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 백트래킹을 호출한 결과를 출력한다.
        back(0, 0);
        // S가 0이면 공집합을 제외하고 출력
        if(S == 0) {
            bw.write(count - 1 + "\n");
        }else{
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int idx, int sum){
        // 현재 위치가 N과 같다면
        if(idx == N){
            // sum이 S와 같은지 확인하여 count를 증가시킨다.
            if(sum == S) count++;
            return;
        }

        // 이외에는 idx를 증가시켜 재귀호출한다.
        back(idx + 1, sum + arr[idx]);
        back(idx + 1, sum);
    }
}
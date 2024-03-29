import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 집의 개수 N, 공유기 개수 C가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        // 2. N만큼의 배열 a를 선언하고, 집의 좌표를 입력받은 뒤 정렬한다.
        int[] a = new int[N];
        for(int i = 0 ; i < N ; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(a);

        // 3. 거리의 최소값 low ~ 최대값 max를 이분탐색하여
        int low = 1;
        int max = a[N-1]-a[0];
        // 설치한 공유기 개수 = C일 때의 최대 거리 result를 판단하는데
        int result = 0;
        while(low <= max) {
            // 거리의 중간값 half, 첫 집의 좌표 start, 공유기 설치개수 count를 선언하고
            int half = (low + max) / 2;
            int start = a[0];
            int count = 1;

            // 4. 다른 집들과 비교하는데
            for (int i = 1; i < N; i++) {
                // 그 다음 집과의 거리 next가 half 이상이면
                int next = a[i] - start;
                if (next >= half) {
                    // 공유기를 설치하고 시작지점을 그 집으로 바꾼다.
                    count++;
                    start = a[i];
                }
            }

            // 5. count가 C 이상이라면
            if (count >= C) {
                // 공유기의 수를 줄여야 하므로 low를 올리고,
                result = half;
                low = half + 1;
            } else {
                // 그 외에는 공유기의 수를 늘려야 하므로
                // max를 내린다.
                max = half - 1;
            }
        }

        // 6. while문을 탈출한 최대 거리 result를 출력한다.
        bw.write(result+"\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
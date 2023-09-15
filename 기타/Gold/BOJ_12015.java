import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수열 A의 크기 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 수열 A의 정보를 저장한다.
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 수열 LIS를 선언하고 첫 값을 첫 자리에 놓는다.
        int[] LIS = new int[N];
        int idx = 0;
        LIS[idx++] = A[0];

        // 4. 나머지 값을 돌면서
        for(int i = 1 ; i < N ; i++){
            // 이전에 놓은 값 < 현재 위치의 수열값일 경우(오름차순이라면)
            if(LIS[idx - 1] < A[i]){
                // 다음 위치에 저장,
                LIS[idx++] = A[i];
            }else{
                // 작을 시 LIS의 0 ~ count 중 처음으로 A[i]보다 커지는 자리에 놓는다.
                int loweridx = lowerBound(LIS, A[i], 0, idx);
                LIS[loweridx] = A[i];
            }
        }

        // 5. LIS를 돌면서 0이 아닌 값의 개수를 출력한다.
        int count = 0;
        for(int i = 0 ; i < N ; i++){
            if(LIS[i] != 0) count++;
        }
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int lowerBound(int[] LIS, int value, int start, int end){
        // start가 end 이상이 될 때 까지 반복하여
        while(start < end){
            // 중간값을 찾아
            int mid = start + (end - start)/2;

            // 해당 값이 더 작으면 오른쪽을 삭제,
            if(value <= LIS[mid]){
                end = mid;
            }else{
                // 더 크면 왼쪽을 삭제
                start = mid + 1;
            }
        }
        // 탐색 종료 시의 start 위치를 리턴한다.
        return start;
    }
}
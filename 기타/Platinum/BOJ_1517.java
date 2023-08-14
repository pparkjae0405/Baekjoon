import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static long count = 0;
    static int[] arr;
    static int[] sortedArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N개의 정수 A[1], A[2] ... A[N]이 주어진다.
        arr = new int[N];
        sortedArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 병합 정렬을 수행하면서 count를 증가시킨 결과를 출력한다.
        sort(arr, 0, N-1);
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void sort(int[] arr, int start, int end){
        if(start < end){
            // 중간 지점을 계산하여 전반부와 후반부로 나눠 정렬한 뒤
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            // 병합한다.
            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid, int end){
        // 전반부와 후반부의 첫 번째 원소의 인덱스를 저장하고
        int p = start;
        int q = mid + 1;
        int idx = start;

        while(p <= mid && q <= end) {
            // 대소를 비교하여
            if(arr[p] <= arr[q])
                // 전반부 원소 <= 후반부 원소일 경우
                // 전반부에서 원소를 가져오고,
                sortedArr[idx++] = arr[p++];
            else {
                // 이외에는 후반부에서 원소를 가져오는데,
                sortedArr[idx++] = arr[q++];
                // 이 때 swap이 왼쪽 배열에 남아있는 숫자만큼 일어나므로
                // count에 mid - p + 1 값을 추가한다.
                count += (mid - p + 1);
            }
        }

        // 한 쪽에 몰려있을 경우 따로따로 확인
        while(p <= mid) {
            sortedArr[idx++] = arr[p++];
        }
        while(q <= end){
            sortedArr[idx++] = arr[q++];
        }

        // 정렬된 배열을 arr에 저장한다.
        for (int i = start ; i <= end ; i++) {
            arr[i] = sortedArr[i];
        }
    }
}
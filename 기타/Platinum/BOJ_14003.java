import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
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

        // 3. 수열의 각 위치를 저장할 loca,
        int[] loca = new int[N];
        // 증가수열을 저장할 ArrayList를 선언하고 첫 값을 MIN으로 설정한다.
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(Integer.MIN_VALUE);

        // 4. 수열을 돌면서
        for(int i = 0 ; i < N ; i++){
            // 현재 수가 오름차순일 경우
            if(A[i] > arrayList.get(arrayList.size() - 1)) {
                // 다음 위치에 value를 추가하고 loca값을 해당 위치로 설정한다.
                arrayList.add(A[i]);
                loca[i] = arrayList.size() - 1;
            }else{
                // 마지막 수보다 작을 경우 이분 탐색을 통해 처음으로 커지는 자리에 놓는다.
                int start = 1;
                int end = arrayList.size() - 1;

                // start가 end보다 클 때 까지 반복하여
                while(start < end){
                    // 중간값 mid를 선언하고
                    int mid = (start + end) / 2;

                    // 해당 값이 더 작을 경우 start를 mid + 1로,
                    if(arrayList.get(mid) < A[i]){
                        start = mid + 1;
                    }else{
                        // 이상일 경우 end를 mid로 설정한다
                        end = mid;
                    }
                }
                // 탐색 종료 시의 값과 loca값을 설정한다.
                arrayList.set(end, A[i]);
                loca[i] = end;
            }
        }

        // 5. 수열의 크기를 출력하고,
        int idx = arrayList.size() - 1;
        bw.write(idx + "\n");
        // 수열의 순서를 스택에 넣어 출력한다.
        Stack<Integer> stack = new Stack<>();
        for(int i = N - 1 ; i >= 0 ; i--){
            if(loca[i] == idx){
                idx--;
                stack.push(A[i]);
            }
        }
        while(!stack.isEmpty()){
            bw.write(stack.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. N, 수를 저장할 num, 연산자 개수를 저장할 oper,
    static int N;
    static int[] num;
    static int[] oper;
    // 선택한 연산자 순서 order, min, max를 선언한다.
    static int[] order;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어진다.
        N = Integer.parseInt(br.readLine());

        // 3. num, order, oper의 크기를 설정하고
        num = new int[N];
        order = new int[N - 1];
        oper = new int[5];
        // N개의 수를 num에 저장,
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }
        // 연산자 개수를 oper에 저장한다.
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i < 5 ; i++){
            oper[i] = Integer.parseInt(st.nextToken());
        }

        // 4. 백트래킹을 호출하여 연산자를 선택하는 경우의 수를 탐색한다.
        back(0);

        // 5. max와 min을 출력한다.
        bw.write(max + "\n" + min);

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth){
        // N - 1만큼 선택하였을 경우
        if(depth == N - 1){
            // 해당하는 연산을 수행한 뒤
            int result = num[0];
            for(int i = 0 ; i < N - 1 ; i++){
                result = cal(result, i, order[i]);
            }

            // min과 max를 갱신하고 종료한다.
            min = Math.min(min, result);
            max = Math.max(max, result);
            return;
        }

        // 이외에는 oper를 돌면서 선택안한 연산자를 선택하고
        for(int i = 1 ; i < 5 ; i++){
            if(oper[i] != 0){
                // 사용처리 + order에 저장 후 재귀호출
                oper[i]--;
                order[depth] = i;
                back(depth + 1);
                // 종료 시 사용해제한다.
                oper[i]++;
            }
        }
    }

    static int cal(int result, int idx, int order){
        // +일 경우 다음 수를 더한다.
        if(order == 1){
            result += num[idx + 1];
        }else if(order == 2){
            // -일 경우 다음 수를 뺀다.
            result -= num[idx + 1];
        }else if(order == 3){
            // *일 경우 다음 수를 곱한다.
            result *= num[idx + 1];
        }else{
            // /이고 result가 음수일 경우
            if(result < 0){
                // result를 양수로 바꾸고 다음 수로 나눈 뒤
                result *= -1;
                result /= num[idx + 1];
                // result를 음수로 바꾼다.
                result *= -1;
            }else{
                // 양수일 경우 다음 수로 나눈다.
                result /= num[idx + 1];
            }
        }

        // 연산 종료 시 result를 리턴한다.
        return result;
    }
}
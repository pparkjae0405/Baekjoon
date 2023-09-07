import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수신되는 탑의 위치와 높이를 저장할 stack을 선언하고
        Stack<int[]> stack = new Stack<>();

        // 2. n만큼 수를 입력받으면서
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= n ; i++){
            // i번째 탑의 높이를 가져와
            int height = Integer.parseInt(st.nextToken());

            // 스택이 비어있지 않다면
            while(!stack.isEmpty()){
                // 이전 탑의 높이를 탐색하면서 현재 탑의 높이 이상이라면
                if(stack.peek()[1] >= height){
                    // 해당하는 탑의 위치를 출력하고 종료시키고
                    bw.write(stack.peek()[0] + " ");
                    break;
                }
                // 높이 미만이라면 맨 위에 위치한 탑을 제거한다.
                stack.pop();
            }

            // 스택을 확인하여 비어있다면 0 출력,
            if(stack.isEmpty()) bw.write("0" + " ");

            // 그 후 현재 탑의 위치와 높이를 stack에 추가한다.
            stack.push(new int[]{i, height});
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
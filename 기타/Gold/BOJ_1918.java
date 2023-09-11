import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 중위 표기식이 주어지고, 연산자를 넣을 stack를 선언한다.
        String s = br.readLine();
        Stack<Character> stack = new Stack<>();

        // 2. s를 하나씩 돌면서
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);

            // 알파벳이면 그대로 출력,
            if(c >= 'A' && c <= 'Z'){
                bw.write(c + "");
            }else if(c == '('){
                // 여는 괄호일 경우 스택에 추가,
                stack.push(c);
            }else if(c == ')'){
                // 닫는 괄호일 경우 여는 괄호가 나올 때 까지 stack값을 뺀다.
                while(!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    bw.write(stack.pop() + "");
                }
            }else{
                // 이외의 경우 스택이 비고
                // 스택의 맨 위 값의 우선순위가 현재 값의 우선순위보다 클 때 까지
                // 반복하여 스택에서 뺀다.
                while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)){
                    bw.write(stack.pop() + "");
                }
                stack.push(c);
            }
        }

        // 3. 스택에 남은 것들을 출력한다.
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static int priority(char c) {
        // 여는 괄호면 0
        if(c == '('){
            return 0;
        }else if(c == '+' || c == '-') {
            // +, -면 1
            return 1;
        }else{
            // 나머지는 2 리턴
            return 2;
        }
    }
}
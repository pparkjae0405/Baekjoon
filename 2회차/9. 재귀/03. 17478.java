import java.io.*;
public class Main {
    // 3. 재귀함수를 구현한다.
    // n값에 따른 "____"의 횟수를 저장할 클래스변수 a를 선언하고,
    static String a = "";
    public static void chatBot(int n){
        // a의 "____" 값을 받아올 b를 선언 한 뒤
        String b = a;
        // 재귀함수가 종료되면 반환하고
        if(n==0){
            System.out.println(b + "\"재귀함수가 뭔가요?\"");
            System.out.println(b + "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            System.out.println(b + "라고 답변하였지.");
            return;
        }
        // 그렇지 않으면 횟수에 따라 여러 번 나오는 말을 출력한 뒤
        System.out.println(b + "\"재귀함수가 뭔가요?\"");
        System.out.println(b + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        System.out.println(b + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        System.out.println(b + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

        // 재귀함수를 호출하기 전 클래스 변수 a에 ____를 추가하여 재귀를 인식하도록 한 뒤에
        a += "____";
        // 재귀함수를 사용하고,
        chatBot(n-1);
        // 맨 마지막에 나오는 말을 출력한다.
        System.out.println(b + "라고 답변하였지.");
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 횟수 N을 입력받는다
        int N = Integer.parseInt(br.readLine());
        // 2. 처음 한 번만 나오는 말 출력
        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        // 4. 함수를 호출하여 재귀 함수를 출력한다.
        chatBot(N);
    }
}
import java.io.*;
public class Main {
    // 1. 출력할 StringBuilder, 옮긴 횟수 count를 클래스 변수로 선언한다.
    public static StringBuilder sb = new StringBuilder();
    public static int count = 0;
    // 3. 재귀함수를 구현한다(원판의 개수 n, 탑 a,b,c)
    public static void hanoi(int n, int a, int b, int c){
        ++count;
        // n이 1이라면 a -> c로 이동
        if(n == 1){
            sb.append(a + " " + c + "\n");
            return;
        }

        // n-1개의 원판을 A -> B로 이동
        hanoi(n-1, a, c, b);

        // 남은 1개의 원판을 A -> C로 이동
        sb.append(a + " " + c + "\n");

        // n-1개의 원판을 B -> C로 이동
        hanoi(n-1, b, a, c);
    }
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2. 원판의 개수 N을 입력받는다.
        int N = Integer.parseInt(br.readLine());
        // 4. 함수를 호출하여 값을 받아온다.
        hanoi(N, 1, 2, 3);
        // 5. StringBuilder의 맨 처음에 옮긴 횟수 count를 추가한다.
        sb.insert(0, count + "\n");
        // 6. StringBuilder를 출력한다.
        System.out.println(sb);
    }
}
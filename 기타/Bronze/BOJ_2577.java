import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. a,b,c를 입력받음
        int a,b,c;
        a = Integer.parseInt(br.readLine());
        b = Integer.parseInt(br.readLine());
        c = Integer.parseInt(br.readLine());
        // 2. 세 자연수를 곱함
        int mul = a*b*c;
        // 3. 1차원 배열에 각각의 숫자를 비교하여 개수 덧셈
        int[] n = new int[10];
        while(true){
            int temp;
            temp = mul % 10;
            mul = mul/10;
            for(int i = 0 ; i < 10 ; i++) {
                if (temp == i) {
                    n[i]++;
                }
            }
            if(mul == 0){
                break;
            }
        }
        // 4. 1차원 배열 출력
        for(int i = 0 ; i < 10 ; i++){
            System.out.println(n[i]);
        }
    }
}
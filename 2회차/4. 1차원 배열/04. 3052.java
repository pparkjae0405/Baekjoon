import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 42개의 정수를 가지는 배열, 수 저장 배열 선언, 서로 다른 값 판별 diff 선언
        int[] n = new int[42];
        int[] count = new int[10];
        int diff = 0;
        // 2. 10개의 수를 입력받고, 42로 나눈 나머지를 배열에 저장
        for(int i = 0 ; i < 10 ; i++){
            count[i] = Integer.parseInt(br.readLine());
            int temp = count[i]%42;
            for(int j = 0; j < 42 ; j++){
                if(temp == j)
                    n[j]++;
            }
        }
        // 3. 배열을 돌며 0이 아니라면 diff값 증가
        for(int i = 0; i < 42 ; i++){
            if(n[i] != 0)
                diff++;
        }
        // 4. diff값 출력
        System.out.println(diff);
    }
}
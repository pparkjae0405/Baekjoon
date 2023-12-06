import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 반복하여
        for(int i = 0 ; i < T ; i++){
            // 거스름돈 C가 주어지고
            int C = Integer.parseInt(br.readLine());
            // 쿼터, 다임, 니켈, 페니 개수를 선언한 뒤
            int a = 0;
            int b = 0;
            int c = 0;
            int d = 0;

            // 3. 거스름돈이 0이 될 때 까지 반복하여
            while(C != 0){
                // 현재 거스름돈을 확인하여 해당하는 개수를 증가시킨다.
                if(C >= 25){
                    a++;
                    C -= 25;
                }else if(C >= 10){
                    b++;
                    C -= 10;
                }else if(C >= 5){
                    c++;
                    C -= 5;
                }else if(C >= 1){
                    d++;
                    C -= 1;
                }
            }

            // 4. 결과를 출력한다.
            bw.write(a + " " + b + " " + c + " " + d + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
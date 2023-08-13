import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 버거 3개 중 최솟값, 음료 2개 중 최솟값을 구한다.
        int burgerMin = 2100;
        int drinkMin = 2100;

        // 2. 값이 주어지고 최소 세트 가격을 출력한다.
        for(int i = 0 ; i < 3 ; i++){
            int price = Integer.parseInt(br.readLine());
            if(burgerMin > price) burgerMin = price;
        }
        for(int i = 0 ; i < 2 ; i++){
            int price = Integer.parseInt(br.readLine());
            if(drinkMin > price) drinkMin = price;
        }
        bw.write(burgerMin + drinkMin - 50 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
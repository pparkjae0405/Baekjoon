import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 돈의 단위 money를 선언한다.
        int[] money = {500, 100, 50, 10, 5, 1};

        // 2. 물건의 가격이 주어지고, 1000에서 price를 뺀다.
        int price = Integer.parseInt(br.readLine());
        price = 1000 - price;

        // 3. 잔돈의 개수 count를 선언하고
        int count = 0;
        while(price != 0){
            // 물건을 사고 남은 돈이 0이 될 때까지 잔돈을 더한다.
            for(int i = 0 ; i < money.length ; i++){
                if(price >= money[i]){
                    count++;
                    price -= money[i];
                    break;
                }
            }
        }

        // 4. count를 출력한다.
        bw.write(count + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
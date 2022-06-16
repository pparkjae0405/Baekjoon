import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        while(true){
            // 1. 주어진 숫자를 5의 배수가 되면 배수 개수만큼
            if(N%5 == 0){
                count += N/5;
                System.out.println(count);
                break;
            }else{
                // 2. 이외엔 3으로 빼며 count 증가
                N -= 3;
                count++;
            }
            // 3. N이 음수가 나오면 3과 5로 나눌 수 없으므로 -1 출력
            if(N < 0) {
                System.out.println("-1");
                break;
            }
        }
    }
}
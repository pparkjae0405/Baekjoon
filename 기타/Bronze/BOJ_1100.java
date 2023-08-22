import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 하얀 칸의 말의 개수 count를 선언하고
        int count = 0;
        // 체스판을 돌아보며
        for(int i = 1 ; i <= 8 ; i++){
            String str = br.readLine();

            for(int j = 0 ; j < 8 ; j++){
                // 홀수일 경우 홀수 칸에 F가 있는지 확인
                if(i % 2 == 1){
                    if((j+1) % 2 == 1){
                        if(str.charAt(j) == 'F'){
                            count++;
                        }
                    }
                }
                // 짝수일 경우 짝수 칸에 F가 있는지 확인하여
                if(i % 2 == 0){
                    if((j+1) % 2 == 0){
                        if(str.charAt(j) == 'F'){
                            count++;
                        }
                    }
                }
            }
        }

        // 2. count를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
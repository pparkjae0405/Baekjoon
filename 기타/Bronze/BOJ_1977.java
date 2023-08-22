import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. M, N이 주어진다.
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        // 2. M 이상 N 이하의 완전제곱수의 합과 최솟값을 찾아 출력한다.
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1 ; i <= 100 ; i++){
            if(i*i < M) continue;
            if(i*i > N) break;

            if(i*i >= M && i*i <= N){
                sum += (i*i);
                if(min > (i*i)){
                    min = (i*i);
                }
            }
        }
        if(sum != 0) {
            bw.write(sum + "\n" + min);
        }else{
            bw.write(-1 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
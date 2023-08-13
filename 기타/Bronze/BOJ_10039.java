import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 점수 5개가 주어지고, 40점 미만이면 40점으로 변경하여 추가
        int sum = 0;
        for(int i = 0 ; i < 5 ; i++){
            int score = Integer.parseInt(br.readLine());

            if(score < 40) score = 40;
            sum += score;
        }

        // 2. 평균값 출력
        bw.write(sum/5 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
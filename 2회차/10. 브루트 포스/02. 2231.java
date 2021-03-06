import java.io.*;
public class Main {
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 자연수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());
        // 2. 생성자 answer 선언, 1~N까지 돌아가며 생성자가 있는지 판단하는데
        int answer = 0;
        for(int i = 1 ; i < N ; i++){
            // i의 자릿수를 판단할 ilen, 현재 숫자를 임시로 저장할 j, 자릿수의 합인 sum을 선언하고
            int ilen = (int)(Math.log10(i)+1);
            int sum = 0;
            int j = i;
            // ilen이 1이라면 한번만, 아니라면 ilen만큼 돌면서 자릿수를 추출하여 sum값에 더한 뒤
            if(ilen == 1){
                sum = i;
            }else {
                for (int k = 0; k < ilen; k++) {
                    sum += j % 10;
                    j /= 10;
                }
            }
            // 본인자신 + 본인 자리수의 합이 N일 경우 루프문을 탈출하여
            if(sum+i == N){
                answer = i;
                break;
            }
        }
        // 3. 생성자가 없으면 0, 있으면 생성자 출력
        if(answer == 0){
            bw.write("0" + "\n");
        }else{
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
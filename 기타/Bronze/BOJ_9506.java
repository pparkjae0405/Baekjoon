import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. -1이 나올 때 까지 입력받아
        while(true) {
            int n = Integer.parseInt(br.readLine());
            if(n == -1) {
                break;
            }

            // n까지의 약수들을 arr 배열에 저장하고
            int[] arr = new int[n];
            int sum = 0;
            int index = 0;
            for(int i = 1 ; i < n ; i++) {
                if(n % i == 0) {
                    arr[index++] = i;
                    sum += i;
                }
            }

            // 약수의 합이 n이 아니라면 오류 출력
            if(sum != n) {
                bw.write(n + " is NOT perfect." + "\n");
                continue;
            }

            // 이외에는 해당 값이 어떤 약수들로 이루어져 있는지 출력
            bw.write(n + " = ");
            for(int i = 0 ; i < index ; i++) {
                // i가 마지막일 경우 "해당값"
                if(i == index - 1){
                    bw.write(arr[i] + "");
                }else{
                    // 나머지는 "해당값 + " 을 출력한다.
                    bw.write(arr[i] + " + ");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
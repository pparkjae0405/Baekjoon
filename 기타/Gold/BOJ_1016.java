import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. min과 max가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        // 2. 범위만큼의 에라토스테네스의 체를 선언한다.
        boolean[] prime = new boolean[1000001];
        Arrays.fill(prime, true);
        prime[1] = false;
        for(int i = 2 ; i <= 1000000 ; i++){
            if(prime[i]){
                for(int j = 2 ; i * j <= 1000000 ; j++){
                    prime[i * j] = false;
                }
            }
        }

        // 3. min부터 max까지의 제곱ㄴㄴ수를 판별할 check를 선언하고
        boolean[] check = new boolean[(int)(max - min + 1)];
        // 2부터 max를 넘지 않는 곳 까지의 제곱만큼 돌면서
        for(long i = 2 ; i * i <= max ; i++){
            // 소수가 아닐 경우 무시,
            if(!prime[(int) i]) continue;

            // 이외에는 소수의 제곱 pow를 저장하고
            long pow = i * i;
            // min으로 나눈 뒤 나머지가 있다면 +1 하여 sqrt에 저장한 뒤
            long sqrt = min / pow;
            if(min % pow != 0) sqrt += 1;

            // sqrt부터 pow의 j배 만큼의 소수를
            for(long j = sqrt ; j * pow <= max; j++) {
                // 제곱ㄴㄴ수가 아니라고 체크한다.
                if(!check[(int)(j * pow - min)]){
                    check[(int)(j * pow - min)] = true;
                }
            }
        }

        // 4. 제곱ㄴㄴ수가 몇 개 있는지 확인할 count를 선언하고
        int count = 0;
        // min부터 max까지 돌면서
        for (long i = min ; i <= max ; i++) {
            // 제곱ㄴㄴ수일 경우 count를 증가시켜
            if (!check[(int)(i - min)]) {
                count++;
            }
        }
        // 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
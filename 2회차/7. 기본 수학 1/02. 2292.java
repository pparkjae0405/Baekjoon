import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 숫자 N, N까지의 거리 dis, 범위를 위한 a가 주어짐
        int N = Integer.parseInt(br.readLine());
        int dis = 1;
        int a = 2;
        // 2. 규칙에 따라 dis를 구하여 출력
        // N이 1이면 1 출력
        if(N == 1){
            System.out.println(dis);
        }else {
            // 8, 20, 38 ... 순으로 범위가 정해지고
            // N이 a보다 커지는 순간이 해당하는 범위가 됨.
            while(a <= N){
                a += 6*dis;
                dis++;
            }
            System.out.println(dis);
        }
    }
}
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 정수 N, 소인수 a가 주어진다
        int N = Integer.parseInt(br.readLine());
        int a = 2;
        // 2. N이 1일경우 아무것도 출력하지 않고,
        if(N != 1){
            // 3. N의 값이 1이 되면 while문을 탈출하는데
            while(N != 1){
                // N을 a로 나눈 나머지가 0일 때 a를 출력하고 N을 a로 나누고
                if(N % a == 0){
                    bw.write(a + "\n");
                    N /= a;
                // 아니라면 a를 증가를 반복
                }else{
                    a++;
                }
            }
        }
        // 4. write한 값을 flush하여 출력
        bw.flush();
    }
}
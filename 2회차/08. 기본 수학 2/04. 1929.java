import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 1. M과 N, 소수 판별 arr 배열이 주어진다.
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean arr[] = new boolean[N+1];

        // 0과 1을 전처리해준다.
        arr[0] = true;
        arr[1] = true;

        // 2. 2~N까지 i를 증가시켜가며
        for(int i = 2 ; i <= Math.sqrt(arr.length); i++){
            // 에라토스테네스의 체를 활용하여 소수가 아닌 것들을 처리해준다.
            if(arr[i]) continue;
            for(int j = i*i ; j<arr.length ; j+=i){
                arr[j] = true;
            }
        }

        // 3. 배열을 돌아가며 소수들을 출력한다.
        for(int i = M ; i <= N ; i++){
            if(arr[i] == false){
                bw.write(i + "\n");
            }
        }
        bw.flush();
    }
}
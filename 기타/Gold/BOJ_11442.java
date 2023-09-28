import java.io.*;

public class Main{
    // 1. 나눌 값 a, 초기값 행렬 arr를 선언한다.
    static long a = 1000000007;
    static long[][] arr = {{1, 1}, {1, 0}};
    static long result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어지고, N이 짝수이면 1를 뺀다.
        long N = Long.parseLong(br.readLine());
        if(N % 2 == 0) N -= 1;

        // 3. answer 배열을 찾아 a로 나눈 나머지를 출력한다.
        long[][] answer = fibo(N - 1);
        bw.write((answer[0][0] + answer[0][1]) % a + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static long[][] fibo(long N){
        // N이 0이면 {{1, 0}, {0, 0}} 리턴,
        if(N == 0){
            long[][] arr1 = new long[2][2];
            arr1[0][0] = 1;
            return arr1;
        }else if(N == 1){
            // N이 1이면 초기값 arr 리턴,
            return arr;
        }

        // 이외에는 행렬의 제곱연산을 수행하고
        long[][] before = fibo(N / 2);
        long[][] arr1 = new long[2][2];
        for(int i = 0 ; i < 2 ; i++){
            for(int j = 0 ; j < 2 ; j++){
                for(int k = 0 ; k < 2 ; k++){
                    arr1[i][j] += (before[i][k] * before[k][j]) % a;
                }
            }
        }

        // 짝수이면 arr1 리턴,
        if(N % 2 == 0){
            return arr1;
        }else{
            // 홀수이면 행렬의 제곱연산 수행하고 arr2 리턴
            long[][] arr2 = new long[2][2];
            for(int i = 0 ; i < 2 ; i++){
                for(int j = 0 ; j < 2 ; j++){
                    for(int k = 0 ; k < 2 ; k++){
                        arr2[i][j] += (arr1[i][k] * arr[k][j]) % a;
                    }
                }
            }
            return arr2;
        }
    }
}
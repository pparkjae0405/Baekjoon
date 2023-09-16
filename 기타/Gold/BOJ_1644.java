import java.io.*;
import java.util.ArrayList;

public class Main{
    // 1. 구할 자연수 N, N까지의 소수 prime을 선언한다.
    static int N;
    static ArrayList<Integer> prime = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어지고 N까지의 소수를 구한다.
        N = Integer.parseInt(br.readLine());
        getPrime(N);

        // 3. 두 포인터 start, end, 경우의 수 count,
        int start = 0;
        int end = 0;
        int count = 0;
        // 연속된 소수의 합 sum, N까지의 소수 개수 size를 선언하고
        int sum = 2;
        int size = prime.size();

        // 4. 두 포인터를 사용해 연속된 소수의 합으로 나타낼 수 있는 경우의 수를 구한다.
        while(start < size && end < size){
            // sum이 N일 경우
            if(sum == N){
                // 경우의 수를 추가하고
                count++;
                // 현재 시작값을 빼고 start를 뒤로 한 칸 땡긴다.
                sum -= prime.get(start);
                start++;
            }else if(sum > N){
                // sum이 더 클 경우 현재 시작값을 빼고 start를 뒤로 한 칸 땡긴다.
                sum -= prime.get(start);
                start++;
            }else{
                // sum이 더 작을 경우 end를 뒤로 한 칸 땡기는데
                end++;
                // size 이상일 경우 종료하고
                if(end >= size) break;
                // 이외에는 현재 끝값을 더한다.
                sum += prime.get(end);
            }
        }

        // 5. 경우의 수를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void getPrime(int N){
        // 1 ~ N까지의 배열을 선언하고 제곱근을 구한다.
        int[] arr = new int[N + 1];
        int root = (int)Math.sqrt(N);

        // 2 ~ N까지의 수를 저장하고
        for(int i = 2 ; i <= N ; i++){
            arr[i] = i;
        }

        // 2 ~ N의 제곱근까지 돌면서
        for(int i = 2 ; i <= root ; i++){
            if(arr[i] != 0){
                // 0이 아닐 경우 배수들을 설정해준다.
                for(int j = i + i ; j <= N ; j += i){
                    arr[j] = 0;
                }
            }
        }

        // 2 ~ N까지 돌면서 0이 아닐 경우 prime에 추가한다.
        for(int i = 2 ; i <= N ; i++){
            if(arr[i] != 0){
                prime.add(arr[i]);
            }
        }
    }
}
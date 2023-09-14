import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. N만큼 arr을 저장한다.
        int[] arr = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1 ; i <= N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 3. a ~ b의 범위가 팰린드롬 수인지 확인할 dp배열을 선언하고
        boolean[][] dp = new boolean[N + 1][N + 1];
        // 개수가 1일 경우 팰린드롬
        for(int i = 0 ; i <= N ; i++){
            dp[i][i] = true;
        }
        // 개수가 2개일 경우 두 값이 같으면 팰린드롬
        for(int i = 1 ; i < N ; i++){
            if(arr[i] == arr[i + 1]){
                dp[i][i + 1] = true;
            }
        }
        // 개수가 3개 이상일 경우
        for(int i = 2 ; i < N ; i++){
            for(int j = 1 ; j + i <= N ; j++){
                // 두 점 사이에 위치한 수가 팰린드롬이고 양 끝점의 수가 같으면 팰린드롬
                if(dp[j + 1][j + i - 1] && arr[j] == arr[j + i]){
                    dp[j][j + i] = true;
                }
            }
        }

        // 4. 질문의 개수 M이 주어지면
        int M = Integer.parseInt(br.readLine());
        // a ~ b까지가 팰린드롬 수인지 확인하여 출력한다.
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(dp[a][b]) bw.write(1 + "\n");
            else bw.write(0 + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
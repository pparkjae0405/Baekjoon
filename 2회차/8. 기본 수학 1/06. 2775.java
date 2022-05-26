import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 15x15만큼의 2차원 배열 A를 선언한다
        int[][] A = new int[15][15];
        // 2. 배열에 값을 저장한다.
        for(int i = 0 ; i < 15 ; i++){
            A[i][1] = 1; // i층 1호들은 1명으로 저장
            A[0][i] = i; // 0층 i호들은 0~14명으로 저장
        }

        for(int i = 1 ; i < 15 ; i++){
            for(int j = 2 ; j < 15 ; j++){
                // 1층 2호 = 1층 1호 + 0층 2호
                A[i][j] = A[i][j-1] + A[i-1][j];
            }
        }
        // 3. 테스트 케이스 T를 입력받는다
        int T = Integer.parseInt(br.readLine());
        // 4. T의 횟수만큼 반복하여 층수 k, 호실 n을 입력받는다
        for(int i = 0 ; i < T ; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(A[k][n] + "\n");
        }
        // 5. 원하는 호실의 명수를 출력한다
        bw.flush();
    }
}
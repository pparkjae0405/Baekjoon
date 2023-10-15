import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 정사각형의 세로 크기 N, 가로 크기 M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. N*M 크기의 배열을 선언하고, 정보를 저장한다.
        int[][] arr = new int[N][M];
        for(int i = 0 ; i < N ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < M ; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        // 3. 정사각형의 크기 answer를 선언하고
        int answer = 1;
        // arr를 탐색하면서
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                // 배열을 벗어나지 않을 경우만큼 확인하는데
                for(int k = 1 ; k + i < N && k + j < M ; k++){
                    // 다른 꼭짓점의 값이 동일하다면
                    if(arr[i][j] == arr[i + k][j] &&
                            arr[i][j] == arr[i][j + k] &&
                                arr[i][j] == arr[i + k][j + k])
                        // answer를 해당 정사각형의 넓이와 비교해 갱신한다.
                        answer = Math.max(answer, (k+1)*(k+1));
                }
            }
        }
        // answer를 출력한다.
        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
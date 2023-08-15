import java.io.*;

public class Main{
    static int N;
    static int count = 0;
    static int[] chess;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다
        N = Integer.parseInt(br.readLine());

        // 2. 체스 판을 선언하고, 백트래킹을 통해 경우의 수를 출력한다.
        chess = new int[N];
        nQueen(0);
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void nQueen(int depth){
        // 마지막 행까지 수행했다면 경우의 수 증가시키고 종료
        if(depth == N){
            count++;
            return;
        }

        // 행마다 돌면서
        for(int i = 0 ; i < N ; i++){
            // depth 번째 행, i번째 열에 퀸을 놓고
            chess[depth] = i;

            // 가능한 위치라면
            if(isPossible(depth)) {
                // 다음 행으로 넘어간다.
                nQueen(depth + 1);
            }
        }
    }

    static boolean isPossible(int depth){
        for(int i = 0 ; i < depth ; i++) {
            // 행마다 하나씩 놓아야 하므로 가로는 비교할 필요 X
            // 그러므로 이전까지 놓았던 퀸의 세로에 위치하는지,
            if (chess[depth] == chess[i]) {
                return false;
            } else if (Math.abs(depth - i) == Math.abs(chess[depth] - chess[i])) {
                // 이전까지 놓았던 퀸의 대각선에 위치하는지 확인한다.
                return false;
            }
        }

        return true;
    }
}
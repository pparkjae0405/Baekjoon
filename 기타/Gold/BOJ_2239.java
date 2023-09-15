import java.io.*;

public class Main{
    // 1. 보드판 정보 board, 종료 조건 isEnd를 선언한다.
    static int[][] board;
    static boolean isEnd;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. board의 크기를 설정하고
        board = new int[9][9];
        // 보드판 정보를 저장한다.
        for(int i = 0 ; i < 9 ; i++){
            String s = br.readLine();
            for(int j = 0 ; j < 9 ; j++){
                board[i][j] = s.charAt(j) - '0';
            }
        }

        // 3. 백트래킹을 수행한 결과를 출력한다.
        back(0);
        for(int i = 0 ; i < 9 ; i++){
            for(int j = 0 ; j < 9 ; j++){
                bw.write(board[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void back(int depth){
        // 보드판만큼 수행했다면
        if(depth == 81){
            // isEnd를 true로 설정하고 종료시킨다.
            isEnd = true;
            return;
        }

        // 이외에는 0이 아니면 재귀호출,
        int y = depth / 9;
        int x = depth % 9;
        if(board[y][x] != 0){
            back(depth + 1);
        }else{
            // 0이 아니면 해당 위치와 연관된 가로, 세로, 3*3에 있는 수 찾아
            for(int k = 1 ; k < 10 ; k++) {
                // 1 ~ 9가 존재할 경우 무시,
                if(!check(y, x, k)) continue;

                // 없을 경우 해당하는 값으로 설정하고 방문처리한 뒤
                board[y][x] = k;
                // 재귀호출하고
                back(depth + 1);

                // 종료조건을 만족하지 못할 시 0으로 설정한다.
                if(isEnd) return;
                board[y][x] = 0;
            }
        }
    }

    static boolean check(int y, int x, int k){
        // 가로, 세로 확인
        for(int i = 0 ; i < 9 ; i++){
            if(board[i][x] == k || board[y][i] == k) return false;
        }

        // 범위 확인
        int squareY = y / 3 * 3;
        int squareX = x - x % 3;
        for(int i = squareY ; i < squareY + 3 ; i++){
            for(int j = squareX ; j < squareX + 3 ; j++){
                if(board[i][j] == k) return false;
            }
        }

        return true;
    }
}
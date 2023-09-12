import java.io.*;
import java.util.Arrays;

public class Main{
    // 1. 출력할 별을 저장할 star를 선언한다.
    static char[][] star;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 3. star의 크기를 설정하고 공백으로 채운다.
        star = new char[N][N * 2 - 1];
        for(int i = 0 ; i < N ; i++){
            Arrays.fill(star[i], ' ');
        }

        // 4. draw 함수를 호출하여 star를 설정한다.
        draw(0, N - 1, N);

        // 5. star를 돌면서 별을 출력한다.
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N * 2 - 1 ; j++){
                bw.write(star[i][j] + "");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void draw(int r, int c, int N){
        // 가장 작은 삼각형일 경우 해당하는 별을 찍는다.
        if(N == 3){
            star[r][c] = '*';
            star[r + 1][c - 1] = star[r + 1][c + 1] = '*';
            star[r + 2][c - 2] = star[r + 2][c - 1] =
                    star[r + 2][c] = star[r + 2][c + 1] =
                            star[r + 2][c + 2] = '*';
        }else{
            // 이외에는 삼각형을 3개로 쪼개서 재귀호출한다.
            int half = N / 2;
            draw(r, c, half);
            draw(r + half, c - half, half);
            draw(r + half, c + half, half);
        }
    }
}
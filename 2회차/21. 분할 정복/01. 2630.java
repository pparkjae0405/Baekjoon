import java.io.*;
import java.util.*;

public class Main {
    // 1. 하얀색, 파란색 색종이 카운트 white, blue를 선언하고,
    // 2차원 배열 a를 선언한다.
    public static int white = 0;
    public static int blue = 0;
    public static int[][] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 전체 종이 한 변의 길이 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 3. N만큼 a를 할당한 뒤 각 줄의 색을 저장한다.
        a = new int[N][N];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. 재귀함수를 호출하여 결과를 출력한다.
        cal(0, 0, N);

        bw.write(white + "\n");
        bw.write(blue + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 5. 재귀함수를 구현하여
    public static void cal(int row, int col, int size){
        // 0 ~ size까지 색이 같은지 확인하는데
        // 첫 번째 색 firstColor, 색 동일 여부 확인 check를 선언하고
        int firstColor = a[row][col];
        boolean check = true;
        for(int i = row ; i < row+size ; i++){
            for(int j = col ; j < col+size ; j++){
                if(a[i][j] != firstColor){
                    // 색이 틀리다면 check를 false로 만든다.
                    check = false;
                }
            }
        }

        // 색의 동일 여부가 true이고
        // 첫 번째 색이 하얀색이면 white를 증가,
        // 파란색이면 blue를 증가시키고 종료한다.
        if(check){
            if(firstColor == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }

        // 다른 색이 존재한다면 크기를 반으로 줄이고
        int halfsize = size / 2;
        // 배열을 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래로 쪼개
        // 재귀호출한다.
        cal(row, col, halfsize);
        cal(row, col+halfsize, halfsize);
        cal(row + halfsize, col, halfsize);
        cal(row + halfsize, col + halfsize, halfsize);
    }
}
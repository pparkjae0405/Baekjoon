import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 하얀색, 파란색 색종이의 개수 white, blue
    static int white = 0;
    static int blue = 0;
    // 종이를 저장할 배열 arr를 선언한다.
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 종이 한 변의 길이 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. arr의 크기를 설정하고,
        arr = new int[N][N];

        // 3. N*N만큼 받아 저장한 뒤
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 4. white와 blue의 개수를 구해
        recur(0, 0, N);

        // 5. white와 blue를 출력한다.
        bw.write(white + "\n");
        bw.write(blue + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void recur(int row, int col, int size){
        // 색종이의 맨 처음 색을 저장하고
        int firstColor = arr[row][col];

        // 색종이의 크기만큼 돌면서 전부 똑같은 색인지 확인하여
        boolean isSame = true;
        for(int i = row ; i < row + size ; i++){
            for(int j = col ; j < col + size ; j++){
                if(arr[i][j] != firstColor) isSame = false;
            }
        }

        // 같다면 해당 색의 색종이의 개수를 증가시키고
        if(isSame){
            if(firstColor == 1){
                blue++;
            }else{
                white++;
            }
        }else{
            // 다르다면 4등분하여 재귀를 통해 호출한다.
            int halfsize = size / 2;
            recur(row, col, halfsize);
            recur(row, col + halfsize, halfsize);
            recur(row + halfsize, col, halfsize);
            recur(row + halfsize, col + halfsize, halfsize);
        }
    }
}
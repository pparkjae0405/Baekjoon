import java.io.*;
import java.util.StringTokenizer;

public class Main {
    // 1. 2차원 배열 a, -1, 0, 1 개수 카운트를 각각 선언한다.
    public static int[][] a;
    public static int countmone = 0;
    public static int countzero = 0;
    public static int countone = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 행렬의 크기 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 3. N만큼 a를 할당한 뒤 정수가 주어진다.
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
        bw.write(countmone + "\n");
        bw.write(countzero + "\n");
        bw.write(countone + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 5. 재귀함수를 구현하여
    public static void cal(int row, int col, int size) throws IOException{
        // 0 ~ size까지 값이 같은지 확인하는데
        // 첫 번째 값 first, 값 동일 여부 확인 check를 선언하고
        int first = a[row][col];
        boolean check = true;
        for(int i = row ; i < row+size ; i++) {
            for (int j = col; j < col + size; j++) {
                if (a[i][j] != first) {
                    // 값이 틀리다면 check를 false로 만든다.
                    check = false;
                }
            }
        }
        // 값의 동일 여부가 true라면
        if(check){
            // -1일 땐 countmone 증가,
            if(first == -1){
                countmone++;
            }else if(first == 0){
                // 0일 땐 countzero 증가,
                countzero++;
            }else{
                // 1일 땐 countone를 증가시킨다.
                countone++;
            }
            return;
        }

        // 다른 값이 존재한다면 크기를 3등분하여 줄이고
        int halfsize = size / 3;

        // a를 9등분하여 재귀호출한다.
        cal(row, col, halfsize);
        cal(row + halfsize, col, halfsize);
        cal(row + halfsize + halfsize, col, halfsize);

        cal(row, col+halfsize, halfsize);
        cal(row + halfsize, col + halfsize, halfsize);
        cal(row + halfsize + halfsize, col + halfsize, halfsize);

        cal(row, col + halfsize + halfsize, halfsize);
        cal(row + halfsize, col + halfsize + halfsize, halfsize);
        cal(row + halfsize + halfsize, col + halfsize + halfsize, halfsize);
    }
}
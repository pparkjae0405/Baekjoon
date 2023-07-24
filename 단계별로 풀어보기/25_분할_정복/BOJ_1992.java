import java.io.*;

public class Main {
    // 1. 2차원 배열 a, Stringbuilder sb를 선언한다.
    public static int[][] a;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 2. 영상의 크기를 나타내는 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 3. N만큼 a를 할당한 뒤 각 줄의 색을 저장한다.
        a = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            String b = br.readLine();
            for(int j = 0 ; j < N ; j++){
                a[i][j] = Integer.parseInt(String.valueOf(b.charAt(j)));
            }
        }

        // 4. 재귀함수를 호출하여 결과를 출력한다.
        cal(0, 0, N);
        System.out.println(sb);
        br.close();
    }

    // 5. 재귀함수를 구현하여
    public static void cal(int row, int col, int size) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
            // 값을 출력하고,
            sb.append(a[row][col]);
            return;
        }

        // 다른 값이 존재한다면 크기를 반으로 줄이고
        int halfsize = size / 2;

        // a를 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래로 쪼개
        // 재귀호출하는데 시작할 때 (, 끝낼 때 )를 출력한다.
        sb.append("(");
        cal(row, col, halfsize);
        cal(row, col+halfsize, halfsize);
        cal(row + halfsize, col, halfsize);
        cal(row + halfsize, col + halfsize, halfsize);
        sb.append(")");
    }
}
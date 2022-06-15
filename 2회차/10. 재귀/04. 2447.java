import java.io.*;
public class Main {
    // 1. 2차원 배열 arr을 선언한다
    public static char[][] arr;
    // 6. 재귀함수를 구현한다
    public static void star(int n, int x, int y){
        // n이 1일 때 *를 입력 후 리턴
        if(n == 1){
            arr[x][y] = '*';
            return;
        }
        // n을 3으로 나눈 value 선언
        int value = n/3;

        for(int i = 0 ; i < 3 ; i++){
            for(int j = 0 ; j < 3 ; j++){
                // 가운데 위치하면 다음 반복문으로
                if(i == 1 && j == 1) continue;
                // 그 외에는 재귀
                else star(value, x+(value*i), y+(value*j));
            }
        }
    }
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2. 3의 거듭제곱 N을 입력받는다
        int N = Integer.parseInt(br.readLine());
        // 3. arr배열을 N의 크기만큼 할당한다
        arr = new char[N][N];
        // 4. arr배열 안의 값들을 공백으로 할당한다.
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                arr[i][j] = ' ';
            }
        }
        // 5. 함수를 호출하여 배열에 조건에 맞는 *값을 할당한다
        star(N, 0, 0);

        // 7. arr 배열 출력
        for(int i = 0 ; i < N ; i++){
            System.out.println(arr[i]);
        }
    }
}
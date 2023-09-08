import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static int T;
    static int[][] gear;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 톱니바퀴별 정보를 저장할 배열 gear를 선언하고 저장한다.
        T = Integer.parseInt(br.readLine());
        gear = new int[T][8];
        for(int i = 0 ; i < T ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < 8 ; j++){
                gear[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        // 2. 회전횟수 K가 주어지고
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0 ; i < K ; i++){
            // 회전시킬 톱니바퀴 번호, 회전방향(시계1, 반시계 -1)이 주어지면
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            // num이 1이면 오른쪽으로 탐색
            if(num == 1){
                rotateR(num - 1, dir);
            }else if(num == T){
                // num이 4이면 왼쪽으로 탐색
                rotateL(num - 1, dir);
            }else{
                // 이외에는 왼쪽, 오른쪽 탐색
                rotateLR(num - 1, dir);
            }
        }

        // 3. 종료 시 톱니바퀴 별 12시의 극을 확인해 점수를 출력한다.
        int score = 0;
        for(int i = 0 ; i < T ; i++){
            if(gear[i][0] == 1) score += 1;
        }
        bw.write(score + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void rotateL(int num, int dir){
        // 현재 톱니바퀴의 왼쪽을 저장한 뒤
        int left = gear[num][6];

        // 현재 톱니바퀴를 돌리고
        rotateNow(num, dir);

        // 현재 톱니바퀴가 0일 경우 종료
        if(num == 0) return;

        // 아닐 경우 left와 왼쪽 톱니바퀴의 오른쪽을 비교,
        if(left != gear[num - 1][2]){
            // 다를 경우 왼쪽 톱니바퀴를 역방향으로 재귀호출한다.
            rotateL(num - 1, dir * -1);
        }
    }

    static void rotateR(int num, int dir){
        // 현재 톱니바퀴의 오른쪽을 저장한 뒤
        int right = gear[num][2];

        /// 현재 톱니바퀴를 돌리고
        rotateNow(num, dir);

        // 현재 톱니바퀴가 T - 1일 경우 종료
        if(num == T - 1) return;

        // 저장한 값과 오른쪽 톱니바퀴의 왼쪽 값이 다를 경우
        if(right != gear[num + 1][6]) {
            // 오른쪽 톱니바퀴를 역방향으로 재귀호출한다.
            rotateR(num + 1, dir * -1);
        }
    }

    static void rotateLR(int num, int dir){
        // 왼쪽, 오른쪽을 둘 다 비교해야 할 경우
        // rotateL을 호출한 뒤
        rotateL(num ,dir);
        // 다시 역방향으로 돌리고
        rotateNow(num, dir * -1);
        // rotateR을 호출한다.
        rotateR(num ,dir);
    }

    static void rotateNow(int num, int dir){
        // 회전 방향에 따라 현재 톱니바퀴를 돌리고
        if(dir == 1){
            // 시계방향일 경우 맨 뒤를 맨앞으로
            int last = gear[num][7];
            for(int i = 7 ; i > 0 ; i--){
                gear[num][i] = gear[num][i - 1];
            }
            gear[num][0] = last;
        }else{
            // 반시계방향일 경우 맨 앞을 맨 뒤로
            int first = gear[num][0];
            for(int i = 0 ; i < 7 ; i++){
                gear[num][i] = gear[num][i + 1];
            }
            gear[num][7] = first;
        }
    }
}
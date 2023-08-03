import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 방문 순서 count를 선언한다.
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 정수 N, r, c가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // 3. r행 c열을 몇 번째로 방문했는지 출력한다.
        int size = (int) Math.pow(2, N);
        recur(r, c, size);
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void recur(int r, int c, int size){
        // 크기가 1이면 r행 c열을 찾았으므로 종료
        if(size == 1){
            return;
        }

        // 크기를 반으로 나눈 halfsize를 선언하고
        int halfsize = size / 2;

        // r행 c열이
        if(r < halfsize && c < halfsize){
            // 좌상단에 위치한다면 아무데도 방문하지 않았으므로
            // 4등분한 좌상단을 재귀호출
            recur(r, c, halfsize);

        }else if(r < halfsize && c >= halfsize){
            // 우상단에 위치한다면 앞선 좌상단을 모두 방문해야하므로
            // count에 좌상단을 방문한 횟수를 추가한 뒤
            count += size * size / 4;

            // 4등분한 우상단을 재귀호출
            recur(r, c - halfsize, halfsize);

        }else if(r >= halfsize && c < halfsize){
            // 좌하단에 위치한다면 앞선 좌상단, 우상단을 모두 방문해야하므로
            // count에 좌상단, 우상단을 방문한 횟수를 추가한 뒤
            count += (size * size / 4) * 2;

            // 4등분한 좌하단을 재귀호출
            recur(r - halfsize, c, halfsize);
        }else{
            // 우하단에 위치한다면 앞선 좌상단, 우상단, 좌하단을 모두 방문해야하므로
            // count에 좌상단, 우상단, 좌하단을 방문한 횟수를 추가한 뒤
            count += (size * size / 4) * 3;

            // 4등분한 우하단을 재귀호출
            recur(r - halfsize, c - halfsize, halfsize);
        }
    }
}
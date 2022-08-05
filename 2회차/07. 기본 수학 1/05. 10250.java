import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 테스트 케이스 개수 T를 입력받는다
        int T = Integer.parseInt(br.readLine());
        // 2. 층수 H, 방 개수 W, N번째 손님을 입력받는다
        for(int i = 0 ; i < T ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            // 4. N번째 손님의 방 호수를 출력한다.
            int roomH, roomW;
            if(N % H == 0){
                roomH = H * 100;
                roomW = N / H;
            }else{
                roomH = (N % H) * 100;
                roomW = (N / H)+1;
            }
            int roomNumber = roomH + roomW;
            bw.write(roomNumber + "\n");
        }
        bw.flush();
    }
}
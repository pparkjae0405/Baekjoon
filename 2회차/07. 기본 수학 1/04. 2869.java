import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. A, B, V가 공백을 기준으로 주어지고, 달팽이 위치 loc, 일수 day가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        int day = (V-B)/(A-B);
        // 2. 정상에 올라가기까지의 일수를 체크하여 출력한다.
        if((V-B)%(A-B) != 0){
            day++;
        }
        System.out.println(day);
    }
}
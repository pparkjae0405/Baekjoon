import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 현재시각, 필요한 시각을 입력받음
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int h = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        // 2. 두개의 분을 더한 값이 60보다 클 경우
        // 60보다 아래가 될 때까지 분에서 60을 빼고
        // 시간에 1을 더하는 과정을 while문을 통해 반복하는데
        // h가 24보다 크면 0으로 바꾸어 줌
        m = m + n;
        if(m>=60) {
            while(m>=60) {
                m-=60;
                h++;
                if(h>=24) {
                    h=0;
                }
            }
        }
        System.out.println(h+" "+m);
    }
}
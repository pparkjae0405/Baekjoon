import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 정수 N이 주어짐
        int n = Integer.parseInt(br.readLine());
        // 우선 맨 처음 n을 저장함.
        int firstN = n;
        int nten = 0, none = 0, m = 0, mnew = 0, count = 0;
        while(true){
            // 10보다 작으면 앞에 0을 붙이고
            if (n < 10) {
                nten = 0;
                none = n;
            } else {
                // 10보다 크면 그대로 나누어
                nten = n / 10;
                none = n % 10;
            }
            // 각 자리를 더함
            m = nten + none;
            // 주어진 N의 가장 오른쪽 자리 숫자와
            // 각 자리를 더한 숫자의 가장 오른쪽 숫자를 이어붙여 새로운 수를 만드는데
            if(m >= 10){
                m = m%10;
            }
            mnew = (none*10) + m;
            n = mnew;
            count++;
            // 맨 처음 N과 같은 숫자가 되면 탈출하여
            if(mnew == firstN) break;
        }
        // 몇 번의 사이클이 필요한지 출력
        System.out.println(count);
    }
}
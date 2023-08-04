import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 최솟값 min을 선언하고 식이 주어진 뒤 -를 기준으로 자른다.
        int min = Integer.MAX_VALUE;
        StringTokenizer str = new StringTokenizer(br.readLine(), "-");

        // 2. 분리한 토큰들을 모두 비교하는데
        while (str.hasMoreTokens()) {
            int temp = 0;

            // +를 기준으로 잘라 해당하는 값들을 모두 더한 뒤
            StringTokenizer add = new StringTokenizer(str.nextToken(), "+");
            while (add.hasMoreTokens()) {
                temp += Integer.parseInt(add.nextToken());
            }

            // 첫 번째 값인 경우 min값을 첫 번째 수로 설정하고
            if (min == Integer.MAX_VALUE) {
                min = temp;
            } else {
                // 나머지 값은 뺀다.
                min -= temp;
            }
        }

        // 3. 최솟값을 출력한다.
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
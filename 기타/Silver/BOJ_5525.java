import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N, S의 길이 M, S가 주어진다.
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        // 2. 패턴 횟수 count, 패턴 일치 횟수 answer 선언
        int count = 0;
        int answer = 0;

        // 3. OI가 반복되면 count를 증가시키고
        for(int i = 1 ; i < M - 1;) {
            if(S.charAt(i) == 'O' && S.charAt(i+1) == 'I') {
                count++;
                // 패턴 횟수가 N과 같다면
                if(count == N) {
                    // 해당 패턴이 시작하는 지점이 I인지 확인하여
                    if(S.charAt(i - (count * 2 - 1)) == 'I')
                        // 패턴 일치 횟수를 증가시키고
                        answer++;

                    // 패턴 횟수를 감소시킨 뒤 i를 2 증가시킨다.
                    count--;
                }
                i += 2;
            } else {
                // OI가 반복되지 않는다면 패턴 횟수를 0으로 초기화하고 i를 1 증가한다.
                count = 0;
                i++;
            }
        }

        // 4. Pn이 몇 군데 포함되어 있는지 출력한다.
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
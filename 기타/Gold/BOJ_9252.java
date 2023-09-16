import java.io.*;
import java.util.Stack;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 두 문자열 a, b가 주어진다.
        String a = br.readLine();
        String b = br.readLine();

        // 2. 두 문자열의 부분 수열 개수 배열 dp를 선언하고,
        int[][] dp = new int[b.length() + 1][a.length() + 1];

        // 3. b에서 글자를 가져와 a와 비교하는데
        for(int i = 1 ; i <= b.length() ; i++){
            char c = b.charAt(i - 1);
            for(int j = 1 ; j <= a.length() ; j++){
                // c가 a와 일치한다면
                if(c == a.charAt(j - 1)){
                    // 해당 위치를 이전값과 이어지도록 +1
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    // 일치하지 않는다면 이전 비교와 현재 비교 중 큰 값을 저장한다.
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        // 4. 가장 긴 부분수열의 길이를 출력한다.
        bw.write(dp[b.length()][a.length()] + "\n");

        // 5. LCS를 출력하기 위해 스택을 선언하고
        Stack<Character> stack = new Stack<>();
        int alen = a.length();
        int blen = b.length();
        // dp를 돌면서 바뀌는 부분에 해당하는 수를 저장하고
        while(blen >= 1 && alen >= 1){
            if(dp[blen][alen] == dp[blen - 1][alen]){
                blen--;
            }else if(dp[blen][alen] == dp[blen][alen - 1]){
                alen--;
            }else{
                stack.push(b.charAt(blen - 1));
                blen--;
                alen--;
            }
        }
        // 스택을 출력한다.
        while(!stack.isEmpty()){
            bw.write(stack.pop() + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
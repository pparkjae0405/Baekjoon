import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 문자열 S가 주어진다.
        String S = br.readLine();

        // 2. 0의 집합 개수 zero, 1의 집합 개수 one을 선언하고
        int zero = 0;
        int one = 0;
        // 첫 번째 값을 증가시키고
        if(S.charAt(0) == '0') zero++;
        else one++;

        // S를 돌면서
        for(int i = 1 ; i < S.length() ; i++){
            // 연속된 두 값이 다른 곳이 있다면
            if(S.charAt(i - 1) != S.charAt(i)){
                // 현재 first값의 개수를 증가시키고
                if(S.charAt(i) == '0'){
                    zero++;
                }else{
                    one++;
                }
            }
        }

        // 3. zero와 one 중 작은 값을 출력한다.
        int min = Math.min(zero, one);
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
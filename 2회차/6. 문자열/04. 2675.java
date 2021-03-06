import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 테스트 케이스 개수 T가 주어짐
        int T = Integer.parseInt(br.readLine());
        // 2. T만큼 반복하여 문자 반복횟수 R과 문자열 S를 입력받음
        for(int i = 0 ; i < T ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            String S = st.nextToken();
            String P = "";
            // 3. 문자열 S의 인덱스값을 문자열의 길이만큼 반복하여 문자열P에 추가
            for(int j = 0 ; j < S.length() ; j++){
                for(int k = 0 ; k < R ; k++) {
                    P = P + S.charAt(j);
                }
            }
            // 4. 문자열 P 저장
            bw.write(P + "\n");
        }
        // 5. 문자열 P 출력
        bw.flush();
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 테스트 케이스 개수 N, N개의 문자열을 받을 문자열배열 a가 주어짐
        int N = Integer.parseInt(br.readLine());
        String[] a = new String[N];
        // 2. N의 개수만큼 반복하여 O와 X로 이루어진 문자열을 입력
        for(int i = 0 ; i < N ; i++){
            // 3. 점수를 카운트할 sum과 조건에 맞출 b가 주어짐
            int sum = 0;
            int b = 1;
            a[i] = br.readLine();
            // 4. 입력받은 문자열의 길이만큼 반복하여
            for(int j = 0; j < a[i].length() ; j++){
                // 5-1. i번째 문자열의 j번째 문자가 'X'라면
                if(a[i].charAt(j) == 'X'){
                    // 5-1. O로 축적된 점수값을 1로 초기화
                    b = 1;
                }else{
                    // 5-2. 아니라면 점수를 더하고 값 증가
                    sum = sum + b;
                    b++;
                }
            }
            // 6. 한 문자열을 돌린 결과값을 저장
            bw.write(sum + "\n");
        }
        // 7. bw.flush()로 출력하고 종료
        bw.flush();
    }
}
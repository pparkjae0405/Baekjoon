import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 학생의 수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 학생 번호를 num에 저장한다.
        String[] num = new String[N];
        for(int i = 0 ; i < N ; i++){
            num[i] = br.readLine();
        }

        // 3. k의 범위(1 ~ 학생 번호의 길이)만큼 반복하여
        for(int k = 1 ; k <= num[0].length() ; k++){
            // set를 선언하고 자른 값을 추가하여
            Set<String> set = new HashSet<>();
            for(int i = 0 ; i < N ; i++){
                set.add(num[i].substring(num[i].length() - k));
            }

            // set의 크기가 N과 같다면 k를 출력하고 종료한다.
            if(set.size() == N){
                bw.write(k + "\n");
                break;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
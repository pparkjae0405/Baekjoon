import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 주어질 문자열을 저장할 배열과 단어길이의 최댓값을 선언한다.
        char[][] arr = new char[5][15];
        int max = 0;

        // 2. 1~15개의 글자 5줄의 입력이 주어진다.
        for(int i = 0 ; i < 5 ; i++){
            String str = br.readLine();
            // 최댓값 저장
            if(max < str.length()) max = str.length();

            for(int j = 0 ; j < str.length() ; j++){
                arr[i][j] = str.charAt(j);
            }
        }

        // 3. 조건에 맞게 배열을 탐색하여 출력
        for (int i = 0 ; i < max ; i++) {
            for(int j = 0 ; j < 5 ; j++){
                // char 배열의 초기값은 '\0'
                if(arr[j][i] == '\0') continue;
                bw.write(arr[j][i] + "");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 문자열 a, b가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String a = st.nextToken();
        String b = st.nextToken();

        // 2. 차이의 최솟값 min을 선언하고
        int min = a.length();
        // b의길이 - a의길이 만큼 반복하여
        for(int i = 0 ; i <= b.length() - a.length() ; i++){
            // 현재 차이의 개수 count를 선언하고
            int count = 0;

            // a를 돌면서 다를경우 count를 증가시킨다.
            for(int j = 0 ; j < a.length() ; j++){
                if(a.charAt(j) != b.charAt(j + i)){
                    count++;
                }
            }

            // min을 갱신한다.
            if(min > count) min = count;
        }
        // min을 출력한다.
        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
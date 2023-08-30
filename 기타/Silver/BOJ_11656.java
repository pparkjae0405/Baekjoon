import java.io.*;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 문자열 S가 주어진다.
        String s = br.readLine();

        // 2. 문자열 크기만큼의 문자열배열 arr을 설정하고
        String[] arr = new String[s.length()];
        // 한 글자씩 떼서 저장한다.
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = s.substring(i, arr.length);
        }

        // 3. arr을 정렬하고
        Arrays.sort(arr);
        // 출력한다.
        for(int i = 0 ; i < arr.length ; i++){
            bw.write(arr[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
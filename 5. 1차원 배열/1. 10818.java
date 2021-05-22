import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine()); // 반복횟수 a 인식
        int[] b = new int[a]; //그 만큼 1차원 배열 선언
        StringTokenizer st = new StringTokenizer(br.readLine()," "); //공백으로 2번째 줄 구분
        // 2번째 줄 값 인식
        for(int i=0;i<a;i++) {
            b[i] = Integer.parseInt(st.nextToken()); // 값 저장
        }
        Arrays.sort(b);
        bw.write(b[0] + " " + b[a-1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
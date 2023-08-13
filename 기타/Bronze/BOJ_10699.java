import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 서울의 오늘 날짜를 "YYYY-MM-DD" 형식으로 출력한다.
        bw.write("2023-08-13" + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
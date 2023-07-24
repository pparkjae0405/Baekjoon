import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());

        for(int i=a; i>=1; i--){ // 반복횟수, a가 5라고 했을 시
            // i는 5부터 1까지 반복되고,
            for(int j = 1; j<=i-1; j++){ // 공백개수
                // j는 1부터 i-1까지 공백을 넣고
                bw.write(" ");
            }
            for(int k = i; k <= a; k++){ // 별 개수
                // i는 i부터 5까지 별을 삽입
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 별을 출력한다.
        for(int i = 1 ; i <= N ; i++){
            for(int j = N ; j > i ; j--){
                bw.write(" ");
            }
            for(int j = 0 ; j < (i*2)-1 ; j++){
                bw.write("*");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
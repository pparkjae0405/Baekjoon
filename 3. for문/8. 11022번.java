import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int b,c;
        for(int i=1;i<=a;i++){
            st = new StringTokenizer(br.readLine(), " ");
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            bw.write("Case #" + i + ": " + b + " + " + c + " = " +
                    (b+c)+ "\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}
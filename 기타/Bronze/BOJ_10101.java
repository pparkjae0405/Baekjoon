import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 삼각형 각의 크기가 주어진다.
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());


        // 2. 종류를 출력한다.
        if(A == 60 && B == 60 && C == 60){
            bw.write("Equilateral" + "\n");
        }else if(A+B+C == 180){
            if(A == B || B == C || A == C){
                bw.write("Isosceles" + "\n");
            }

            if(A != B && B != C && A != C){
                bw.write("Scalene" + "\n");
            }
        }else if(A+B+C != 180){
            bw.write("Error" + "\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
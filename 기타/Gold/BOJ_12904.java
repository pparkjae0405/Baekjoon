import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. S, T가 주어진다
        String S = br.readLine();
        String T = br.readLine();

        // 2. T의 길이가 더 클때까지 반복
        while(S.length() < T.length()){
            // T의 마지막 값이 A인 경우 마지막값을 제거하고
            if(T.charAt(T.length() - 1) == 'A'){
                T = T.substring(0, T.length() - 1);
            }else if(T.charAt(T.length() - 1) == 'B'){
                // B일 경우 마지막 값을 제거하고 문자열을 뒤집는다.
                T = T.substring(0, T.length() - 1);
                String temp = "";
                for(int i = T.length() - 1 ; i >= 0 ; i--){
                    temp += T.charAt(i);
                }
                T = temp;
            }
        }

        // 3. T의길이와 S의길이가 같아졌을 경우 일치하면 1, 아니면 0을 출력한다.
        if(T.equals(S)) bw.write(1 + "\n");
        else bw.write(0 + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
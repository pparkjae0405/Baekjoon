import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 8진수가 주어지고, 변환할 배열 a, 출력할 sb를 선언한다.
        String str = br.readLine();
        String[] a = {"000", "001", "010", "011", "100", "101", "110", "111"};
        StringBuilder sb = new StringBuilder();

        // 2. str을 하나씩 돌면서 2진수로 변환해 더하고
        for(int i = 0 ; i < str.length() ; i++){
            int number = str.charAt(i) - '0';
            sb.append(a[number]);
        }

        // 3. str이 0이라면 str을 출력,
        if(str.equals("0")){
            System.out.println(str);
        }
        else{
            // 아니라면 맨앞이 0이 아닐때까지 잘라서 출력한다.
            while(sb.charAt(0) == '0'){
                sb = new StringBuilder(sb.substring(1));
            }
            System.out.println(sb);
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 입력
        String a = br.readLine();
        int count = 0;
        for(int i=0;i<a.length();i++){
            if('A'<=a.charAt(i) && a.charAt(i) <= 'C')
                count += 3;
            else if('D'<=a.charAt(i) && a.charAt(i) <= 'F')
                count += 4;
            else if('G'<=a.charAt(i) && a.charAt(i) <= 'I')
                count += 5;
            else if('J'<=a.charAt(i) && a.charAt(i) <= 'L')
                count += 6;
            else if('M'<=a.charAt(i) && a.charAt(i) <= 'O')
                count += 7;
            else if('P'<=a.charAt(i) && a.charAt(i) <= 'S')
                count += 8;
            else if('T'<=a.charAt(i) && a.charAt(i) <= 'V')
                count += 9;
            else if('W'<=a.charAt(i) && a.charAt(i) <= 'Z')
                count += 10;
        }
        System.out.println(count);
    }
}
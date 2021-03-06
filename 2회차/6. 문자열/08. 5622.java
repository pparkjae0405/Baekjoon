import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 문자열을 입력받고 최소 시간 sum 선언
        String a = br.readLine();
        int b = a.length();
        int sum = 0;
        // 2. 2~0 중 어디에 위치하는지 확인하고 맞다면 sum에 추가
        for(int i = 0 ; i < b ; i++){
            if('A'<=a.charAt(i) && a.charAt(i) <= 'C'){
                sum += 3;
            }else if('D'<=a.charAt(i) && a.charAt(i) <= 'F'){
                sum += 4;
            }else if('G'<=a.charAt(i) && a.charAt(i) <= 'I'){
                sum += 5;
            }else if('J'<=a.charAt(i) && a.charAt(i) <= 'L'){
                sum += 6;
            }else if('M'<=a.charAt(i) && a.charAt(i) <= 'O'){
                sum += 7;
            }else if('P'<=a.charAt(i) && a.charAt(i) <= 'S'){
                sum += 8;
            }else if('T'<=a.charAt(i) && a.charAt(i) <= 'V'){
                sum += 9;
            }else if('W'<=a.charAt(i) && a.charAt(i) <= 'Z'){
                sum += 10;
            }
        }
        // 3. 최소 시간 출력
        System.out.println(sum);
    }
}
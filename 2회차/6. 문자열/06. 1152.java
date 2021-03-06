import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 입력받을 문자열 a, 그 전 문자 판단 left, 단어 개수 count 선언
        String a = br.readLine();
        int left = 32;
        int count = 0;
        // 2. 문자열의 길이만큼 반복하여
        for(int i = 0 ; i < a.length() ; i++){
            // a 문자열의 i번째 문자가 공백이고 그 전 문자가 공백이 아니라면 count값 증가
            if(a.charAt(i) == 32 && left != 32){
                count++;
            }
            left = a.charAt(i);
        }
        // 문자열 a 마지막 문자가 공백이 아니라면 count를 1 더해준다.
        if(a.charAt(a.length()-1) != 32){
            count++;
        }
        // 3. count값 출력
        System.out.println(count);
    }
}
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 문자열 a를 입력받고 소문자로 변환, 최다 알파벳 위치 where, 알파벳값 value, 복수 최댓값 인식 Manymax 선언
        String a = br.readLine();
        a = a.toLowerCase();
        int value = 0;
        int where = 0;
        boolean manyMax = false;
        // 2. 알파벳 배열 선언, 입력받은 문자열을 배열에 카운트
        int[] b = new int[26];
        for(int i = 0 ; i < a.length(); i++){
            for(int j = 97 ; j < 123 ; j++){
                // 문자열 a의 i번째 문자가 j와 같으면 알파벳 배열 b의 카운트를 증가
                if(a.charAt(i) == j)
                    b[j - 97]++;
            }
        }
        // 3. 배열 중 최댓값과 알파벳의 위치 인식
        for(int i = 0 ; i < 26 ; i++){
            if(value < b[i]) {
                value = b[i];
                where = i;
            }
        }
        // 4. i가 where 위치가 아닌데 value값이 같다면 ? 출력
        for(int i = 0 ; i < 26 ; i++){
            // i가 where의 위치가 아닌데 최댓값과 같다면
            if(where != i && value == b[i]){
                System.out.println("?");
                manyMax = true;
                break;
            }
        }
        // 5. 최댓값이 여러개가 아니라면 해당 알파벳을 대문자로 출력
        if(manyMax == false) {
            System.out.println((char)(where + 65));
        }
    }
}
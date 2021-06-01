import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 a를 입력받음
        String a = br.readLine();
        // 0~26까지(a~z) 개수를 카운트하기 위한 b배열
        int[] b = new int[26];
        char location = '?';
        int max = 0;
        // 문자열 a를 비교함
        for(int i=0;i<a.length();i++){
            int c = a.charAt(i);
            // 대문자이면 소문자로 바꿔서 저장
            if(64 < c && c < 91){
                c = a.charAt(i)+32;
            }
            // 바꾸거나 안바꾼 c가 a~z인지 체크하여 그 알파벳 개수 저장
            for(int j=0;j<=26;j++){
                if(c == j+97)
                    b[j] = b[j]+1;
            }
        }
        //0~26까지(a-z 개수) 중 max값 출력, max값이 중복되면 ?를 출력
        for(int k=0;k<26;k++){
            if(b[k] > max){
                max = b[k]; // max값 지정
                location = (char)(k+65); // b[k]가 max보다 크면 그 위치를 location에 저장
            }
            else if(b[k] == max){
                location = '?';
            }
        }
        //최댓값이 나온 위치를 대문자로 변환하여 출력
        System.out.println(location);
    }
}
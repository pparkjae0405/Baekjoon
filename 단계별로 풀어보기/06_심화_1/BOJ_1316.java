import java.io.*;
public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        // 그룹 단어 카운트
        int count = 0;
        // 반복 횟수 a 입력
        int a = Integer.parseInt(br.readLine());
        // a번 반복하여 그룹단어이면 count++
        for (int i = 0; i < a; i++) {
            if (check() == true) {
                count++;
            }
        }
        // count 출력
        System.out.println(count);
    }
    // 그룹단어인지 확인할 check()함수
    public static boolean check() throws IOException {
        // a~z까지 하나씩 비교하여 연속되는지 확인하는 boolean 배열(기본값 false)
        boolean[] check = new boolean[26];
        // 그 전 단어의 ascii값을 저장할 prev
        int prev = 0;
        // 단어 입력
        String str = br.readLine();
        // 단어의 크기만큼 반복
        for(int i = 0; i < str.length(); i++) {
            // i번째 문자를 now에 저장
            int now = str.charAt(i);
            // prev와 now가 같지 않다면
            if (prev != now) {
                // 해당 문자가 처음 나왔다면 (now-'a'는 알파벳 몇 번째인지)
                if ( check[now - 'a'] == false ) {
                    // true 로 바꿔주고
                    check[now - 'a'] = true;
                    // 다음 문자와 비교하기 위해 prev값에 now를 넣어줌
                    prev = now;
                }
                // check[now - 'a']가 true일 경우
                else
                    // 해당 문자가 이미 나온 적이 있는 것이므로 false 리턴
                    return false;
            }
        }
        // 끝까지 다 돌았는데도 return false로 빠지지 않았다면 그룹함수이므로 true 리턴
        return true;
    }
}
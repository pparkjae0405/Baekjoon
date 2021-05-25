import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //입력받을 버퍼리더
        int a = Integer.parseInt(br.readLine()); // 케이스 갯수
        String[] b = new String[a]; // 0~80까지 넣을 수 있는 배열 크기 지정
        int score[] = new int[a];// 총 점수배열
        int count = 0;
        for(int i=0;i<a;i++){  // 테스트 케이스 입력
            b[i] = br.readLine();
        }
        for(int j = 0; j < a ; j++){ // 케이스 갯수만큼 반복
            count = 0; //케이스 시작 시 카운트 초기화
            for(int k=0;k<b[j].length();k++) {//문자가 O이면 카운트+1해서 스코어에 추가, 그 외에는 카운트 초기화
                if (b[j].charAt(k) == 'O') { // O이면 score값 증가
                    count++;
                    score[j] = score[j] + count;
                } else { // X이면 카운트 초기화
                    count = 0;
                }
            }
        }
        for(int n = 0; n < a; n++) {
            System.out.println(score[n]);
        }
    }
}
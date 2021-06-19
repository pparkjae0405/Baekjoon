import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[3]; //배열 선언
        for(int i=0;i<3;i++) {
            a[i] = Integer.parseInt(br.readLine()); // 값 저장
        }
        String b = String.valueOf(a[0]*a[1]*a[2]); //배열 값 끼리 곱한 값 String 변환
        int[] c = new int[10]; // 0~9까지 횟수 잴 배열c
        for(int j=0;j<b.length();j++) { // 자릿수 구분
            c[(b.charAt(j)-'0')]++;
        }
        for(int k : c) { // 0~9까지 횟수 출력
            System.out.println(k);
        }
        br.close();
    }
}
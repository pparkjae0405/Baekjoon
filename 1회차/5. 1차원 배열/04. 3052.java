import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] a = new int[10]; //배열 선언
        int result = 0;
        for(int i=0;i<10;i++) {
            a[i] = Integer.parseInt(br.readLine())%42; // 읽어온 값 42로 나눠 저장
        }
        for(int j=0;j<10;j++){ // b 배열값들이 서로 다른 값이 몇 개인지 구분하여 count++
            int count = 0;
            for(int j1=j+1;j1<10;j1++) {
                if (a[j] == a[j1]) // 서로 같은 값이면 count값 증가
                    count++;
            }
            if(count==0) //서로 같은 숫자가 없으면 결과값 증가
                result++;
        }
        System.out.println(result); //결과값 출력
        br.close();
    }
}
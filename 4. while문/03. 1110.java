import java.io.*;
public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());//원본숫자를 입력받음
        if(a<10)//10보다 작으면 뒤에 0을 붙임
            a = a * 10;
        int a1 = a; //원본숫자랑 비교할 값
        int b,c; // 1번째,2번째 연산 값
        int cycle = 0;
        while(true){
            b = (a1/10) + (a1%10);//주어진 수의 첫번째 + 두번째 = 결과
            if(b<10)
                c = (a1%10*10) + b; //주어진 수의 가장 오른쪽 자리 수 + 가장 오른쪽 자리수 = 새로운 수
            else
                c = (a1%10*10) + b%10;
            cycle++;//사이클 ++
            if(a == c) //맨 처음 주어진 수랑 새로운 수랑 같으면 탈출
                break;
            else
                a1 = c; //새로운 수로 사이클 다시 반복
        }
        bw.write(cycle+"\n");//사이클 수 출력
        br.close();
        bw.flush();
        bw.close();
    }
}
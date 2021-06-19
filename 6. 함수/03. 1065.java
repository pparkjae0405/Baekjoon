import java.io.*;
public class Main {
    //한수 카운트 함수
    private static int hansu(int n) {
        int count = 0;
        // 1~99까지는 비교할 대상이 없기 때문에 전부 한수이고,
        // 100부터는 비교할 대상이 있지만 1000보다 작은 수까지 비교하므로
        // 1000일 시 999로 바꿔줌
        if (n < 100) {
            return n;
        } else {
            count = 99;
            if (n == 1000) {
                n = 999;
            }
        }
        // 100부터 입력받은 수까지 비교하는데
        // 100의자리 h, 10의자리 t, 1의자리 u로 나누어
        // 각각의 자릿수 별 숫자를 선언하고,
        // (100의자리 - 10의자리) 와 (10의자리 - 1의자리) 를 비교하여
        // 두 값이 같을 경우 한수이므로 count를 증가시켜주는 반복문
        for (int i = 100; i <= n; i++) {
            int h = i / 100;
            int t = (i / 10) % 10;
            int u = i % 10;

            if ((h - t) == (t - u)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(hansu(Integer.parseInt(br.readLine())));
    }
}
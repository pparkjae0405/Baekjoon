public class Main {
    private static int remain(int n) {
        // 4. 자릿수를 더할 sum 선언
        int sum = 0;
        // 5. 조건을 만족할 때 까지 자릿수를 sum에 더하고, 10으로 나눔
        while(n > 0) {
            sum += n % 10;
            n /= 10;
        }
        // 6. sum을 리턴함
        return sum;
    }
    public static void main(String[] args) {
        // 1. 체크 배열 선언
        boolean[] check = new boolean[10001];
        // 2. 반복하여 조건에 따라 출력
        for (int i = 1; i < check.length; i++) {
            // 3. 조건에 맞는 수를 구함(함수 호출)
            int n = i + remain(i);
            // 7. 더한 값에 대한 체크 배열을 true로 설정
            if(n < 10001) check[n] = true;
            // 8. 만약 i번째 체크 배열이 false라면 셀프넘버이므로 i 출력
            if(!check[i]) System.out.println(i);
        }
    }
}
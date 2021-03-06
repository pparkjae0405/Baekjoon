import java.io.*;
public class Main {
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 숫자 N이 주어진다.
        int N = Integer.parseInt(br.readLine());
        // 2. 첫번째 영화 제목 title을 선언한다.
        int title = 666;
        // 3. N번째 영화 제목을 찾는데,
        while(true){
            // title을 String 형태로 변환한 a를 선언하고
            String a = String.valueOf(title);
            // 666이 들어갔다면 N을 감소시키고
            for(int i = 0 ; i < a.length() -2 ; i++) {
                if (a.charAt(i) == '6' && a.charAt(i+1) == '6' && a.charAt(i+2) == '6') {
                    N--;
                    break;
                }
            }
            // N이 0이 된 순간이 N번째 영화 제목이므로
            if(N == 0) break;
            title++;
        }
        // 4. 그 때의 title 값을 출력한다.
        bw.write(title + "\n");
        bw.flush();
   }
}
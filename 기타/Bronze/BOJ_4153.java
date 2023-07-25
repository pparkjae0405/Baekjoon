import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            // 1. 0 0 0이 나올때까지 수를 입력받는다.
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[3];
            for(int i = 0 ; i < 3 ; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            if(arr[0] == 0 && arr[1] == 0 && arr[2] == 0) break;

            // 2. 배열을 정렬한다.
            Arrays.sort(arr);

            // 3. 직각삼각형의 조건을 만족하는지 확인하여 결과를 출력한다.
            String result = "right";
            if((arr[0] * arr[0]) + (arr[1] * arr[1]) != (arr[2]*arr[2])){
                result = "wrong";
            }
            bw.write(result + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
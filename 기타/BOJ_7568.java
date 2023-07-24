import java.io.*;
import java.util.*;
public class Main {
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 전체 사람의 수 N이 주어진다
        int N = Integer.parseInt(br.readLine());
        // 2. 2차원 배열을 선언하고,
        int[][] a = new int[N][2];
        for(int i = 0 ; i < N ; i++) {
            // 몸무게와 키를 나타내는 x, y를 공백을 두고 입력받아
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            // a 배열에 저장한다.
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        // 3. 저장한 값을 비교하여 등수를 구한다.
        for(int i = 0 ; i < N ; i++){
            // count를 선언하고
            int count = 1;
            // 기준과 나머지를 비교하는데
            for(int j = 0 ; j < N ; j++){
                // i와 j가 같지 않을 때만 비교해서
                if(i!=j) {
                    // 조건을 만족하면 나보다 덩치가 큰 사람이 있으므로 count++를 하고
                    if(a[i][0] < a[j][0] && a[i][1] < a[j][1]){
                        count++;
                    }
                }
            }
            // 루프문 탈출 시 등수를 저장한다.
            bw.write(count + " ");
        }
        // 4. 저장한 등수를 출력한다.
        bw.flush();
    }
}
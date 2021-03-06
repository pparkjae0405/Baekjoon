import java.io.*;
public class Main {
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 수의 개수 N을 입력받는다.
        int N = Integer.parseInt(br.readLine());
        // 2. 크기 N을 지닌 배열 a를 선언하고 수 N개를 입력받는다.
        int[] a = new int[N];
        for(int i = 0 ; i < N ; i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        // 3. 기준값과 나머지값을 비교하여 정렬하는데
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                // 기준값이 나머지값보다 작으면 두 수의 위치를 변경하여
                // 작은 값이 앞으로 오도록 정렬하고,
                if(a[i] < a[j]){
                    int temp = a[j];
                    a[j] = a[i];
                    a[i] = temp;
                }
            }
        }
        // 4. 3번의 반복문을 탈출하였을 때의 배열 순서를 출력한다.
        for(int i = 0 ; i < N ; i++){
            bw.write(a[i] + "\n");
        }
        bw.flush();
   }
}
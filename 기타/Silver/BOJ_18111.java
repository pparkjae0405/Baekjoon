import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 출력할 최소 시간 time, 그때의 땅의 높이 height를 선언
        int time = Integer.MAX_VALUE;
        int height = 0;

        // 2. 세로N, 가로M 크기의 집터, 인벤토리에 있는 블럭 개수 B가 주어짐
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 3. 세로 가로 크기의 2차원 배열 선언
        int[][] arr = new int[N][M];

        // 4. 땅의 높이가 주어지면 배열에 저장하고
        // 땅 높이의 최댓값과 최솟값을 저장해놓는다.
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] < min) min = arr[i][j];
                if(arr[i][j] > max) max = arr[i][j];
            }
        }

        // 5. 땅 높이의 최솟값과 최댓값을 모두 만들어보면서
        // 그때의 시간과 높이를 비교하여 최소시간, 최대높이를 출력한다.
        for(int i = min ; i <= max ; i++){
            int count = 0;
            int inventory = B;

            // 높이가 i가 되도록 만든다.
            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < M ; k++){
                    if(arr[j][k] > i){
                        // 블럭을 제거하여 인벤토리에 추가, 시간 증가
                        inventory += (arr[j][k] - i);
                        count += ((arr[j][k] - i) * 2);
                    }else{
                        // 작다면 인벤토리에서 블럭을 꺼내 블럭 추가, 시간 증가
                        inventory -= (i - arr[j][k]);
                        count += (i - arr[j][k]);
                    }
                }
            }

            // 만들었을 때 아이템이 부족하지 않고 만든 시간이 최솟값이라면
            if(inventory >= 0 && count <= time){
                // 그때의 시간과 높이를 저장한 뒤
                time = count;
                height = i;
            }
        }

        // 6. 결과를 출력한다.
        bw.write(time + " " + height);
        bw.flush();
        br.close();
        bw.close();
    }
}
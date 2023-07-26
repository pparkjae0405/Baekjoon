import java.io.*;
import java.util.StringTokenizer;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 영역의 넓이 area, 색종이의 수 n, 도화지 arr을 선언한다.
        int area = 0;
        int n = Integer.parseInt(br.readLine());
        boolean[][] arr = new boolean[101][101];

        // 2. n만큼 색종이를 입력받고,
        StringTokenizer st;
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 이미 있는 색종이 범위를 제외한
            // (x, y)부터 (x+9, y+9) 까지 도화지를 true로 바꿔주고
            // 넓이를 증가시킨다.
            for(int j = x ; j < x+10 ; j++){
                for(int k = y ; k < y+10 ; k++){
                    if(!arr[j][k]){
                        arr[j][k] = true;
                        area++;
                    }
                }
            }
        }

        bw.write(area + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
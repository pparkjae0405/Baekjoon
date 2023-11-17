import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 정점의 개수 N이 주어지면
        int N = Integer.parseInt(br.readLine());
        // 그래프의 크기를 설정하고 정보를 저장한다.
        int[][] info = new int[N][N];
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 플로이드 워셜을 사용해
        for(int b = 0 ; b < N ; b++){
            for(int a = 0 ; a < N ; a++){
                for(int c = 0 ; c < N ; c++){
                    // a에서 b를 거쳐 c로 가는 경로가 존재한다면
                    if(info[a][b] == 1 && info[b][c] == 1){
                        // 해당 경로를 1로 변경한다.
                        info[a][c] = 1;
                    }
                }
            }
        }

        // 3. 결과를 출력한다.
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                bw.write(info[i][j] + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
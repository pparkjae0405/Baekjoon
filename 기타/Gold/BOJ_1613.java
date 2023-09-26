import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 사건의 개수 N, 관계의 개수 K가 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 2. 사건 정보 info를 저장하고
        boolean[][] info = new boolean[N + 1][N + 1];
        for(int i = 0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            info[start][end] = true;
        }

        // 3. 플로이드 워셜을 통해
        for(int b = 1 ; b <= N ; b++){
            for(int a = 1 ; a <= N ; a++){
                for(int c = 1 ; c <= N ; c++){
                    // A에서 B를 거쳐 C로 가는 경우가 있다면
                    if(info[a][b] && info[b][c]) {
                        // A -> C 경로를 true로 저장한다.
                        info[a][c] = true;
                    }
                }
            }
        }

        // 4. 사건의 전후 관계를 알고 싶은 사건 쌍의 수 S가 주어지고
        int S = Integer.parseInt(br.readLine());
        // S만큼 돌면서
        for(int i = 0 ; i < S ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            // 해당 사건번호가 존재하지 않을 경우 0,
            if(start < 1 || start > N || end < 1 || end > N){
                bw.write(0 + "\n");
            }else{
                // start -> end가 있을 경우 -1
                if(info[start][end]){
                    bw.write(-1 + "\n");
                }else{
                    // 없을 경우 end -> start가 있을 경우 1,
                    if(info[end][start]){
                        bw.write(1 + "\n");
                    }else {
                        // 이외에는 0을 출력한다.
                        bw.write(0 + "\n");
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
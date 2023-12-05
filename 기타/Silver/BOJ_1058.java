import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 친구 정보 info, 가장 유명한 사람의 2-친구 수 count를 선언한다.
        int[][] info;
        int count = -1;

        // 2. N이 주어지고 정보를 info에 저장한다.
        int N = Integer.parseInt(br.readLine());
        info = new int[N][N];
        for(int i = 0 ; i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < N ; j++){
                if(str.charAt(j) == 'Y'){
                    info[i][j] = 1;
                }else if(i != j){
                    // N의 최댓값이 50이므로 INF를 51로 설정
                    info[i][j] = 51;
                }
            }
        }

        // 3. 플로이드 워셜을 통해 info를 돌면서
        for(int b = 0 ; b < N ; b++){
            for(int a = 0 ; a < N ; a++){
                for(int c = 0 ; c < N ; c++){
                    // a -> c 보다 a -> b + b -> c가 더 짧다면
                    if(info[a][c] > info[a][b] + info[b][c]){
                        // 거리를 갱신한다.
                        info[a][c] = info[a][b] + info[b][c];
                    }
                }
            }
        }

        // 4. 갱신된 정보를 돌면서 가장 유명한 사람의 count를 갱신한다.
        for(int i = 0 ; i < N ; i++){
            int temp = 0;
            for(int j = 0 ; j < N ; j++){
                if(i != j && info[i][j] <= 2) temp++;
            }
            count = Math.max(count, temp);
        }

        // 5. count를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 출발지점 x, 도착지점 y가 주어지고
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            // 두 지점 사이의 거리를 찾아
            int dis = y - x;

            // 제곱근에 가장 가까운 정수를 계산하여
            int max = (int)Math.sqrt(dis);

            // 그에 해당하는 값을 출력한다.
            if(max == Math.sqrt(dis)){
                bw.write(max * 2 - 1 + "\n");
            }else if(dis <= max * max + max){
                bw.write(max * 2 + "\n");
            }else{
                bw.write(max * 2 + 1 + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
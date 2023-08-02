import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 회의의 수 N이 주어지고, 2차원 배열 meeting의 크기를 설정한다.
        int N = Integer.parseInt(br.readLine());
        int[][] meeting = new int[N][2];

        // 2. N만큼 회의의 정보가 주어지고 저장한다.
        StringTokenizer st;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meeting[i][0] = start;
            meeting[i][1] = end;
        }

        // 3. 회의를 종료 시간을 기준으로(같을 경우 시작시간 기준) 정렬한다.
        Arrays.sort(meeting, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return o1[0] - o2[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });

        // 4. 회의의 최대 개수 count, 시간 time을 선언하고
        int count = 0;
        int time = 0;
        for(int i = 0 ; i < N ; i++){
            // 다음 회의의 시작 시간이 전 회의 종료 시간 뒤일 경우
            if(time <= meeting[i][0]){
                // 가장 빨리 끝나는 회의의 종료 시간을 time에 저장하고
                time = meeting[i][1];

                // 회의 개수를 증가시켜
                count++;
            }
        }

        // 5. 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
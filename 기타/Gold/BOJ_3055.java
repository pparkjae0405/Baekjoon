import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    // 1. 지도의 가로크기 R, 세로크기 C,
    static int R, C;
    // 지도를 표현할 map, 이동시간을 저장할 time,
    static char[][] map;
    static int[][] time;
    // 이동방향 dx, dy, 물의 이동 w, 고슴도치의 이동 s,
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<int[]> w = new LinkedList<>();
    static Queue<int[]> s = new LinkedList<>();
    // 최소 시간 min을 선언한다.
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. R, C가 주어지고
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        // map, time의 크기를 설정한다.
        map = new char[R][C];
        time = new int[R][C];

        // 3. 지도 정보를 저장하는데
        for(int i = 0 ; i < R ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                map[i][j] = str.charAt(j);

                // 해당 위치가 '*'이면 w에 추가,
                if(map[i][j] == '*') w.add(new int[]{i, j});
                // S면 s에 추가한다.
                if(map[i][j] == 'S') s.add(new int[]{i, j, 0});
            }
        }

        // 4. bfs를 호출하여 탐색한 뒤
        bfs();
        // 최소 거리를 출력한다.
        if(min == Integer.MAX_VALUE){
            bw.write("KAKTUS" + "");
        }else{
            bw.write(min + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void bfs(){
        // 고슴도치 큐가 빌 때 까지 반복하여
        while(!s.isEmpty()){
            // 물을 퍼트리고
            water(w.size());
            // 고슴도치를 이동시킨다.
            hedgehog(s.size());
        }
    }

    static void water(int len){
        for(int i = 0 ; i < len ; i++){
            // 현재 위치를 가져와
            int[] now = w.poll();
            int nowY = now[0];
            int nowX = now[1];

            // 인접 위치로 이동하는데
            for(int j = 0 ; j < 4 ; j++){
                int nextY = nowY + dy[j];
                int nextX = nowX + dx[j];

                // 해당 위치가 지도 안에 있고
                if(nextY >= 0 && nextY < R && nextX >= 0 && nextX < C){
                    // 비어있거나 S라면
                    if(map[nextY][nextX] == '.' || map[nextY][nextX] == 'S') {
                        // '*'으로 바꾸고 w에 추가한다.
                        map[nextY][nextX] = '*';
                        w.add(new int[]{nextY, nextX});
                    }
                }
            }
        }
    }

    static void hedgehog(int len){
        for(int i = 0 ; i < len ; i++){
            // 현재 위치를 가져와
            int[] now = s.poll();
            int nowY = now[0];
            int nowX = now[1];
            int nowT = now[2];

            // 인접 위치로 이동하는데
            for(int j = 0 ; j < 4 ; j++){
                int nextY = nowY + dy[j];
                int nextX = nowX + dx[j];

                // 해당 위치가 지도 안에 있고
                if(nextY >= 0 && nextY < R && nextX >= 0 && nextX < C){
                    // 'D'라면 소요시간을 저장하고
                    if(map[nextY][nextX] == 'D'){
                        min = Math.min(min, nowT + 1);
                    }else if(map[nextY][nextX] == '.'){
                        // 비어있다면 S로 바꾸고 현재시간 + 1하여 s에 추가한다.
                        map[nextY][nextX] = 'S';
                        s.add(new int[]{nextY, nextX, nowT + 1});
                    }
                }
            }
        }
    }
}
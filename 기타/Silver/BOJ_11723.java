import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 수행해야 하는 연산의 수 M이 주어진다.
        int M = Integer.parseInt(br.readLine());

        // 2. 집합 S를 선언하고 M만큼 주어진 연산을 수행한다.
        HashSet<Integer> S = new HashSet<>();
        StringTokenizer st;
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            int value;
            switch(command){
                case "add":
                    value = Integer.parseInt(st.nextToken());
                    if(!S.contains(value)) S.add(value);
                    break;

                case "remove":
                    value = Integer.parseInt(st.nextToken());
                    if(S.contains(value)) S.remove(value);
                    break;

                case "check":
                    value = Integer.parseInt(st.nextToken());
                    if(S.contains(value)){
                        bw.write(1 + "\n");
                    }else{
                        bw.write(0 + "\n");
                    }
                    break;

                case "toggle":
                    value = Integer.parseInt(st.nextToken());
                    if(S.contains(value)){
                        S.remove(value);
                    }else{
                        S.add(value);
                    }
                    break;

                case "all":
                    S.clear();
                    for(int j = 1 ; j <= 20 ; j++){
                        S.add(j);
                    }
                    break;

                case "empty":
                    S.clear();
                    break;

            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
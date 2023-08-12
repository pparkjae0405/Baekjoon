import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 저장된 사이트 수 N, 비밀번호를 찾으려는 사이트 주소의 수 M이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 2. 해시맵을 선언하고, N만큼 사이트를 받아 key:value로 저장한다.
        HashMap<String, String> hashMap = new HashMap<>();
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String key = st.nextToken();
            String value = st.nextToken();

            hashMap.put(key, value);
        }

        // 3. M만큼 사이트가 주어지고 그에 맞는 비밀번호를 출력한다.
        for(int i = 0 ; i < M ; i++){
            String site = br.readLine();
            bw.write(hashMap.get(site) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
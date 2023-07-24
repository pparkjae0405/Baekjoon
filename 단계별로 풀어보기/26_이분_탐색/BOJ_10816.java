import java.io.*;
import java.util.*;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 상근이가 가지고 있는 카드 개수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 숫자 카드에 적혀있는 정수가 주어지는데
        // 같은 카드가 여러 개 있을 수 있기 때문에
        // 해시맵을 사용하여 각 카드 별 개수 cardN을 선언하고
        HashMap<Integer, Integer> cardN = new HashMap<>();
        // 카드의 숫자와 그 개수를 추가한다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            // 숫자 카드와 카드 개수
            int key = Integer.parseInt(st.nextToken());
            int count = 1;

            // 해당 숫자 카드가 해시맵에 존재하는지 확인하여
            // 존재하면 해당 value에 1을 더하여 저장
            if(cardN.containsKey(key)){
                count = cardN.get(key) + 1;
            }
            // 존재하지 않으면 (key, count)로 해시맵에 저장
            cardN.put(key, count);
        }

        // 3. M이 주어지고
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        // 4. M만큼 반복하여 M이 적힌 카드를 몇 개 가지고 있는지 출력하는데
        for(int i = 0 ; i < M ; i++){
            int cardM = Integer.parseInt(st.nextToken());
            // cardM을 상근이가 가지고 있다면
            if(cardN.containsKey(cardM)){
                // 그 value를 출력하고
                bw.write(cardN.get(cardM) + " ");
            }else{
                // 없다면 0 출력
                bw.write(0 + " ");
            }

        }

        bw.flush();
        br.close();
        bw.close();
    }
}
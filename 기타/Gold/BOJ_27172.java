import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 플레이어의 수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 카드에 적힌 정수 card, 카드 존재 여부 visited, 점수 score를 선언하고
        int[] card = new int[N];
        boolean[] visited = new boolean[1000001];
        int[] score = new int[1000001];
        // card 정보를 저장, visited 여부를 설정한다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            card[i] = Integer.parseInt(st.nextToken());
            visited[card[i]] = true;
        }

        // 3. 카드의 배수에 해당하는 카드가 있는지 확인한다.
        for(int i = 0 ; i < card.length ; i++){
            int num = card[i];
            for(int j = num * 2 ; j < 1000001 ; j += num){
                if(visited[j]){
                    ++score[num];
                    --score[j];
                }
            }
        }

        // 4. 플레이어의 점수를 출력한다.
        for(int i = 0 ; i < card.length ; i++){
            bw.write(score[card[i]] + " ");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
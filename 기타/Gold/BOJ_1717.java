import java.io.*;
import java.util.StringTokenizer;

public class Main{
    // 1. 집합을 표현할 parent를 선언한다.
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 2. 집합의 개수 n, 연산 수행 횟수 m이 주어진다.
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 3. parent의 크기를 선언하고
        parent = new int[n + 1];
        // 각각 해당하는 번호로 저장한다.
        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
        }

        // 4. m만큼 연산이 주어지고,
        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a와 b가 속한 집합을 가져와
            int setA = find(a);
            int setB = find(b);

            // type가 0이고 같은 집합에 존재하지 않으면 합치고
            if(type == 0 && setA != setB){
                combine(setA, setB);
            }else if(type == 1 && setA != setB){
                // 1이고 같은 집합에 존재하지 않으면 NO,
                bw.write("NO" + "\n");
            }else if(type == 1 && setA == setB){
                // 1이고 같은 집합이라면 YES를 출력한다.
                bw.write("YES" + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
    static void combine(int a, int b){
        // a의 부모를 b로 설정한다.
        parent[a] = b;
    }

    static int find(int a) {
        // a의 부모가 a이면 a 리턴
        if(parent[a] == a) return a;
            // 이외에는 해당하는 번호로 이동한다.
        else return parent[a] = find(parent[a]);
    }
}
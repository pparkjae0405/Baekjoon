import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스의 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 테스트 케이스가 주어지는데
        StringTokenizer st;
        for(int i = 0 ; i < T ; i++){
            // 적용할 연산의 개수 k가 주어지고, <값, 개수>를 가지는 트리맵 tm 선언
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> tm = new TreeMap<>();

            // k만큼 연산이 주어지고
            for(int j = 0 ; j < k ; j++){
                st = new StringTokenizer(br.readLine(), " ");
                String command = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                // 커맨드가 D이고
                if(command.equals("D")){
                    // 비어있다면 무시
                    if(tm.isEmpty()){
                        continue;
                    }else if(value == 1){
                        // 값이 1일 경우 제일 작은 값 min을 가져오고
                        // 그 수가 몇 개 있는지 확인한 뒤
                        int min = tm.lastKey();
                        int minCount = tm.get(min);

                        // 1개만 있으면 삭제하고, 2 이상이면 숫자를 1 줄인다.
                        if(minCount == 1){
                            tm.remove(min);
                        }else{
                            tm.put(min, minCount - 1);
                        }
                    }else{
                        // 값이 -1일 경우에는 가장 큰 값 max를 가져오고
                        // 그 수가 몇 개 있는지 확인한 뒤
                        int max = tm.firstKey();
                        int maxCount = tm.get(max);

                        // 1개만 있으면 삭제하고, 2 이상이면 숫자를 1 줄인다.
                        if(maxCount == 1){
                            tm.remove(max);
                        }else{
                            tm.put(max, maxCount - 1);
                        }
                    }
                }else{
                    // I이면 현재 수를 입력하는데 수가 없으면 생성, 있으면 수를 1 늘린다.
                    tm.put(value, tm.getOrDefault(value, 0) + 1);
                }
            }

            // 모든 연산을 처리한 후 비어있다면 EMPTY 출력, 최댓값과 최솟값을 출력한다.
            if(tm.isEmpty()){
                bw.write("EMPTY" + "\n");
            }else{
                bw.write(tm.lastKey() + " " + tm.firstKey() + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
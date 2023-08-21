import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 방 번호 N이 주어진다.
        String N = br.readLine();

        // 2. 0 ~ 9가 하나씩 있는 배열 set, 세트 개수 count를 선언하고
        int[] set = new int[10];
        int count = 0;
        // 방 번호를 하나씩 떼서 확인하는데
        for(int i = 0 ; i < N.length() ; i++){
            int number = N.charAt(i) - '0';

            // 해당 번호가 있을 경우 해당 번호를 사용하고,
            if(set[number] != 0){
                set[number] -= 1;
            }else{
                // 없을 경우 해당 번호가 6이라면
                if(number == 6){
                    // 9가 있을 경우 9를 사용하고
                    if(set[9] != 0){
                        set[9] -= 1;
                        continue;
                    }
                }else if(number == 9){
                    // 해당 번호가 9일 경우
                    // 6이 있을 경우 6을 사용한다.
                    if(set[6] != 0){
                        set[6] -= 1;
                        continue;
                    }
                }

                // 그 외에는 세트 개수를 추가하고 전체 번호를 1 증가시킨 뒤
                count++;
                for(int j = 0 ; j < 10 ; j++){
                    set[j] += 1;
                }
                // 해당 번호를 1 감소시킨다.
                set[number] -= 1;
            }
        }

        // 3. count를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
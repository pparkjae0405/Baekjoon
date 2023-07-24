import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 학생 수만큼의 배열을 선언한다.
        boolean[] arr = new boolean[30];

        // 2. 28번 입력받는 학생의 제출여부를 true로 변경한다.
        for(int i = 0 ; i < 28 ; i++){
            int person = Integer.parseInt(br.readLine());
            arr[person-1] = true;
        }

        // 3. false인 학생을 출력하고, 2명이 되었을 시 탈출한다.
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == false){
                bw.write(i+1 + "\n");
                count++;
            }
            if(count == 2) break;
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 1~8까지 담긴 배열 선언
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};

        // 2. 맨처음 들어오는 숫자 확인
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");;
        int first = Integer.parseInt(st.nextToken());

        // 들어온 숫자에 따라 조건 확인
        boolean correct = true;
        if(first == 1){
            // 1이면 2~8인지 확인
            for(int i = 1 ; i < 8 ; i++){
                int next = Integer.parseInt(st.nextToken());
                if(next != arr[i]){
                    correct = false;
                    break;
                }
            }
            if(correct == true){
                bw.write("ascending");
            }else{
                bw.write("mixed");
            }
        }else if(first == 8){
            // 8이면 7~1인지 확인
            for(int i = 6 ; i > 0 ; i--){
                int next = Integer.parseInt(st.nextToken());
                if(next != arr[i]){
                    correct = false;
                    break;
                }
            }
            if(correct == true){
                bw.write("descending");
            }else{
                bw.write("mixed");
            }
        }else{
            // 이외에는 mixed
            bw.write("mixed");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
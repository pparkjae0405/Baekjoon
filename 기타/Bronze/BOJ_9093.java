import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 테스트 케이스 개수 T가 주어진다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 문장이 주어지고
        for(int i = 0 ; i < T ; i++){
            String str = br.readLine();
            // 공백의 개수를 구해
            int blankNum = 0;
            for(int j = 0 ; j < str.length() ; j++){
                if(str.charAt(j) == ' '){
                    blankNum++;
                }
            }

            // 공백개수 + 1만큼의 문자열 배열을 선언하여 저장하고
            String[] arr = new String[blankNum + 1];
            StringTokenizer st = new StringTokenizer(str, " ");
            for(int j = 0 ; j < blankNum + 1 ; j++){
                arr[j] = st.nextToken();
            }

            // arr을 돌면서
            for(int j = 0 ; j < arr.length ; j++){
                String temp = arr[j];

                // 단어의 역순 + 공백을 출력한 뒤
                for(int k = temp.length() - 1 ; k >= 0 ; k--){
                    bw.write(temp.charAt(k) + "");
                }
                bw.write(" ");
            }
            // 케이스가 끝났을 경우 줄바꿈해준다.
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}
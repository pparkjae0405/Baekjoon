import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 파일의 개수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 2. 크기가 N인 문자열 배열이 주어지고, 파일 이름을 저장한다.
        String[] arr = new String[N];
        for(int i = 0 ; i < N ; i++){
            arr[i] = br.readLine();
        }

        // 3. 출력 문자열 배열 answer를 선언하고 arr을 돌면서
        int length = arr[0].length();
        String[] answer = new String[length];
        for(int i = 0 ; i < length ; i++){
            char first = arr[0].charAt(i);
            for(int j = 0 ; j < N ; j++){
                char next = arr[j].charAt(i);

                // 일치할 경우 해당 글자를,
                if(first == next){
                    answer[i] = String.valueOf(first);
                }else{
                    // 일치하지 않을 경우 "?"를 저장하여
                    answer[i] = "?";
                    break;
                }
            }
        }

        // 4. answer 배열을 출력한다.
        for(int i = 0 ; i < answer.length ; i++){
            bw.write(answer[i] + "");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 찾고자 하는 문자열이 주어진다.
        String find = br.readLine();

        // 2. 반지 개수 N이 주어지고,
        int count = 0;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N ; i++){
            // 반지에 새겨진 문자열이 주어진 뒤
            String compare = br.readLine();

            // 반지를 돌면서 찾고자 하는 문자열이 있는지 확인해
            for(int j = 0 ; j < compare.length() ; j++){
                String split = "";
                for(int k = j ; k < j + find.length() ; k++){
                    if(k >= compare.length()){
                        split += compare.charAt(k - compare.length());
                    }else{
                        split += compare.charAt(k);
                    }
                }

                // 있을 경우 count를 증가시키고 탈출한다.
                if(split.equals(find)){
                    count++;
                    break;
                }
            }
        }

        // 3. count를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
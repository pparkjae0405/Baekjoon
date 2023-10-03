import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 문서와 검색하고 싶은 단어가 주어진다.
        String text = br.readLine();
        String search = br.readLine();

        // 2. 0 ~ text 길이 - search길이까지 돌면서
        int count = 0;
        for(int i = 0 ; i <= text.length() - search.length() ; i++){
            // i ~ i + search의 길이까지의 값을 가져와
            String compare = text.substring(i, i + search.length());
            // search와 같을 경우
            if(compare.equals(search)){
                // count를 증가시키고
                count++;
                // i를 해당 길이 - 1만큼 증가시킨다.
                i += compare.length() - 1;
            }
        }

        // 3. count를 출력한다.
        bw.write(count + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
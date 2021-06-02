import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 문자열 a를 입력받아서 띄어쓰기로 구분
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int count = st.countTokens();
        System.out.println(count);
    }
}
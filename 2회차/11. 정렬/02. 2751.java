import java.io.*;
import java.util.*;
public class Main {
   public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 1. 수의 개수 N을 입력받는다.
        int N = Integer.parseInt(br.readLine());
        // 2. ArrayList a를 선언한다.
        ArrayList<Integer> a = new ArrayList<>();
        // 3. N개의 숫자를 입력받고 a에 추가한 뒤,
        for(int i = 0 ; i < N ; i++){
            a.add(Integer.parseInt(br.readLine()));
        }
        // 4. a를 정렬하고
        Collections.sort(a);
        // 5. 정렬한 a의 값을 불러와 출력한다.
        for(int i = 0 ; i < N ; i++){
            bw.write(a.get(i) + "\n");
        }
        bw.flush();
   }
}
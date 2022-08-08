import java.io.*;
import java.util.*;
public class Main {
     public static void main(String[] args) throws IOException{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 단어 개수 N을 입력받는다.
          int N = Integer.parseInt(br.readLine());
          // 2. N개만큼의 문자열 배열 a를 선언하고
          String[] a = new String[N];
          // 3. N만큼 반복하여 단어를 입력받아
          for(int i = 0 ; i < N ; i++){
               // a배열에 저장한 뒤
               a[i] = br.readLine();
          }
          // 4. a배열을 정렬하고
          Arrays.sort(a, new Comparator<String>() {
               @Override
               public int compare(String o1, String o2) {
                    if(o1.length() == o2.length()){
                         return o1.compareTo(o2);
                    }
                    else{
                         return o1.length() - o2.length();
                    }
               }
          });

          bw.write(a[0] + "\n");

          // 5. 중복되지 않도록 출력한다.
          for(int i = 1 ; i < N ; i++){
               if(!a[i].equals(a[i-1])){
                    bw.write(a[i] + "\n");
               }
          }
          br.close();
          bw.flush();
          bw.close();
     }
}
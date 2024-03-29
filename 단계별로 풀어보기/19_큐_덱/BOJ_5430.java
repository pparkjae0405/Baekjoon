import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 테스트 케이스 개수 T가 주어진다.
          int T = Integer.parseInt(br.readLine());

          // 2. T만큼 반복하여
          for(int i = 0 ; i < T ; i++) {
               // 수행할 함수 p,
               String p = br.readLine();

               // 배열에 들어있는 수의 개수 n이 주어지고
               int n = Integer.parseInt(br.readLine());

               // 덱 a를 선언한 뒤 배열을 받아온 다음
               LinkedList<Integer> a = new LinkedList<Integer>();
               // ,[]를 구분자로 하여 받아와 a에 추가한 뒤
               StringTokenizer st = new StringTokenizer(br.readLine(), ",[]");
               for(int j = 0 ; j < n ; j++){
                    a.add(Integer.parseInt(st.nextToken()));
               }

               // 3. 각 테스트 케이스에 대해 함수 p를 수행한 결과를 출력하는데
               // 먼저 수행 중 에러를 감지할 isError,
               // 앞과 뒤 중 어디부터인지 체크할 isFront를 true로 선언하고
               boolean isError = false;
               boolean isFront = true;

               for(int j = 0 ; j < p.length() ; j++){
                    if(p.charAt(j) == 'R'){
                         // R의 경우에는 isFront를 변환시키고
                         isFront = !isFront;
                    }else{
                         // D의 경우에는 비어있다면 isError를 true로 변환한 뒤 error를 출력하고 탈출,
                         if(a.isEmpty() == true){
                              isError = true;
                              bw.write("error" + "\n");
                              break;
                         }else{
                              // 아니라면 첫 글자를 삭제하는데
                              if(isFront == true) {
                                   // isFront가 true라면 첫 원소를 제거하고,
                                   a.pollFirst();
                              }else{
                                   // false라면 뒷 원소를 제거한다.
                                   a.pollLast();
                              }
                         }
                    }
               }

               // 4. 3번을 수행한 결과 에러가 없다면 현재 a의 값을 출력하는데
               if(isError == false){
                    // a의 사이즈를 저장할 변수 sizeOfa를 선언하고
                    int sizeOfa = a.size();
                    // 출력할 원소가 있을 경우 출력하는데
                    bw.write("[");
                    if(a.size() > 0) {
                         // isFront가 true라면 앞부터,
                         if (isFront == true) {
                              for (int j = 0; j < sizeOfa - 1; j++) {
                                   bw.write(a.pollFirst() + ",");
                              }
                              bw.write(a.pollFirst() + "");
                         } else {
                              // false라면 뒤부터 형식에 맞게 출력한다.
                              for (int j = 0; j < sizeOfa - 1; j++) {
                                   bw.write(a.pollLast() + ",");
                              }
                              bw.write(a.pollLast() + "");
                         }
                    }
                    bw.write("]" + "\n");
               }
          }

          bw.flush();
          bw.close();
          br.close();
     }
}
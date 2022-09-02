import java.io.*;
import java.util.*;

public class Main {

     public static void main(String[] args) throws IOException {
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
          // 1. 명령 개수 N이 주어지고, 큐를 선언한다.
          int N = Integer.parseInt(br.readLine());
          Queue<Integer> a = new LinkedList<Integer>();

          // 2. N만큼 명령이 주어지는데
          int lastCount = 0;
          for(int i = 0 ; i < N ; i++){
               StringTokenizer st = new StringTokenizer(br.readLine(), " ");
               // 처음 들어오는 값 first가 push이면
               String first = st.nextToken();
               if(first.equals("push")){
                    // 그 다음 들어오는 정수를 lastCount에 저장한 뒤 스택에 추가하고
                    lastCount = Integer.parseInt(st.nextToken());
                    a.add(lastCount);
               }else if(first.equals("pop")){
                    // pop일 때 a가 비어있지 않다면 그 값을 빼고 출력하고
                    if(!a.isEmpty()){
                         bw.write(a.poll() + "\n");
                    }else{
                         // 비어있다면 -1을 출력,
                         bw.write("-1" + "\n");
                    }
               }else if(first.equals("size")){
                    // size이면 a에 들어있는 정수 개수를 출력하고,
                    bw.write(a.size() + "\n");
               }else if(first.equals("empty")){
                    // empty일 때 a가 비어있지 않다면 0 출력,
                    if(!a.isEmpty()){
                         bw.write("0" + "\n");
                    }else{
                         // 비어있다면 1 출력,
                         bw.write("1" + "\n");
                    }
               }else if(first.equals("front")){
                    // front일 때 a가 비어있지 않다면 가장 앞의 수 출력,
                    if(!a.isEmpty()){
                         bw.write(a.peek() + "\n");
                    }else{
                         // 비어있다면 -1을 출력,
                         bw.write("-1" + "\n");
                    }
               }else if(first.equals("back")){
                    // back일 때 a가 비어있지 않다면 lastCount 출력,
                    if(!a.isEmpty()){
                         bw.write(lastCount + "\n");
                    }else{
                         // 비어있다면 -1을 출력한다.
                         bw.write("-1" + "\n");
                    }
               }
          }
          bw.flush();
          bw.close();
          br.close();
     }
}
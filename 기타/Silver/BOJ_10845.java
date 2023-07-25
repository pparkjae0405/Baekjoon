import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. 정수형 큐를 선언한다.
        Queue<Integer> queue = new LinkedList<>();

        // 2. 명령의 수 N이 주어진다.
        int N = Integer.parseInt(br.readLine());

        // 3. N개의 명령이 주어진다.
        StringTokenizer st;
        int last = 0;
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();

            switch(command){
                case "push":
                    int value = Integer.parseInt(st.nextToken());
                    last = value;
                    queue.offer(value);
                    break;
                case "pop":
                    if(queue.isEmpty()){
                        bw.write("-1" + "\n");
                    }else{
                        bw.write(queue.poll() + "\n");
                    }
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if(queue.isEmpty()){
                        bw.write("1" + "\n");
                    }else{
                        bw.write("0" + "\n");
                    }
                    break;
                case "front":
                    if(queue.isEmpty()){
                        bw.write("-1" + "\n");
                    }else{
                        bw.write(queue.peek() + "\n");
                    }
                    break;
                case "back":
                    if(queue.isEmpty()){
                        bw.write("-1" + "\n");
                    }else{
                        bw.write(last + "\n");
                    }
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
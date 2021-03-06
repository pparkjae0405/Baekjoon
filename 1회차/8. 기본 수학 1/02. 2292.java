import java.io.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 주어지는 정수 a
        int a = Integer.parseInt(br.readLine());
        int count = 1;
        // a가 2~7이면 count = 2, 8~19이면 count = 3, 20~37이면 count = 4 가 되야하므로
        // 최솟값들을 이용하여 count를 세도록 하기 위해 b를 1 다음의 최솟값인 2로 지정하고,
        int b = 2;
        // a가 1이면 count = 1
        if(a == 1){
            System.out.print(count);
        }
        else{
            // b가 a보다 커지는 시점이 최소 이동거리이므로 while문 사용
            while(b <= a){
                // b+(6*count)로 b가 그 다음 최솟값이 되도록 설정한 뒤
                b += 6*count;
                // count를 1 늘려줌
                count++;
            }
            // count를 출력 해 주는 것으로 마무리함.
            System.out.println(count);
        }
    }
}
import java.io.*;
import java.util.*;
class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 재산세, 보험료, 급여 등 고정비용 a
        int a = Integer.parseInt(st.nextToken());
        // 재료비,인건비 등 가변비용 b
        int b = Integer.parseInt(st.nextToken());
        // 팔 상품의 가격 c
        int c = Integer.parseInt(st.nextToken());
        // 판매 비용이 총 비용 보다 많아지게 되는 지점을 손익분기점이라고 함.
        // 재료비가 팔 가격보다 비싸다면 절대 손익분기점이 나올 수 없으므로 -1
        if(b>=c){
            System.out.println(-1);
        }else{
            // 고정비용을 상품가격-가변비용인 순수익으로 나누면 손익분기점 직전의 판매개수를 알 수 있으므로 +1을 하여
            // 손익분기점을 알 수 있음.
            System.out.println(a/(c-b)+1);
        }
    }
}
import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 1. L1의 양 끝 점 a, b, L2의 양 끝 점 c, d를 선언하고
        long[] a = new long[2];
        long[] b = new long[2];
        long[] c = new long[2];
        long[] d = new long[2];

        // 2. (x1, y1), (x2, y2),
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a[0] = Long.parseLong(st.nextToken());
        a[1] = Long.parseLong(st.nextToken());
        b[0] = Long.parseLong(st.nextToken());
        b[1] = Long.parseLong(st.nextToken());
        // (x3, y3), (x4, y4)를 저장한다.
        st = new StringTokenizer(br.readLine(), " ");
        c[0] = Long.parseLong(st.nextToken());
        c[1] = Long.parseLong(st.nextToken());
        d[0] = Long.parseLong(st.nextToken());
        d[1] = Long.parseLong(st.nextToken());

        // 3. CCW 공식을 통해 L1과 L2가 교차하는지 여부를 출력한다.
        // CCW(A, B, C) * CCW(A, B, D) == 0 && CCW(C, D, A) * CCW(C, D, B) == 0
        // 일 경우 c가 b보다 작고 a가 d보다 커야 하고,
        int result = 0;
        boolean isCross = false;
        if(ccw(a, b, c) * ccw(a, b, d) == 0 &&
                ccw(c, d, a) * ccw(c, d, b) == 0){
            boolean case1 = Math.min(a[0], b[0]) <= Math.max(c[0], d[0]);
            boolean case2 = Math.min(c[0], d[0]) <= Math.max(a[0], b[0]);;
            boolean case3 = Math.min(a[1], b[1]) <= Math.max(c[1], d[1]);;
            boolean case4 = Math.min(c[1], d[1]) <= Math.max(a[1], b[1]);;
            isCross = true;
            if(case1 && case2 && case3 && case4){
                result = 1;
            }
        }
        // CCW(A, B, C) * CCW(A, B, D) <= 0 && CCW(C, D, A) * CCW(C, D, B) <= 0
        // 일 경우 교차하지 않는다.
        if(ccw(a, b, c) * ccw(a, b, d) <= 0 &&
                ccw(c, d, a) * ccw(c, d, b) <= 0){
            if(!isCross) {
                result = 1;
            }
        }

        // 4. result를 출력한다.
        bw.write(result + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static int ccw(long[] x, long[] y, long[] z){
        long result = x[0] * y[1] + y[0] * z[1] + z[0] * x[1] -
                x[1] * y[0] - y[1] * z[0] -
                z[1] * x[0];

        if(result > 0){
            return 1;
        }else if(result == 0){
            return 0;
        }else{
            return -1;
        }
    }
}
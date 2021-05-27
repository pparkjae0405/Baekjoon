class Self{
    void d() {
        boolean[] a = new boolean[20000];
        for (int n = 1; n <= 10000; n++) { // 숫자 개수만큼 반복
            int sum = 0;
            int m = (int) (Math.log10(n) + 1);
            switch(m){
                default :
                    sum = sum + n + n; // sum에 맨 처음 n값 추가
                    break;
                case 2:
                    sum = sum + n + (n%10) + ((n/10)%10);
                    break;
                case 3:
                    sum = sum + n + (n%10) + ((n/10)%10) + ((n/100)%10);
                    break;
                case 4:
                    sum = sum + n + (n%10) + ((n/10)%10) + ((n/100)%10) + ((n/1000)%10);
                    break;
            }
            a[sum-1] = true; // sum 위치에 있는 수를 true로 변경
        }

        for(int j=0;j<10000;j++){
            if(a[j] == false)
                System.out.println(j+1);
        }

    }
}
public class Main {
    public static void main(String args[]){
        Self s = new Self();
        s.d();
    }
}
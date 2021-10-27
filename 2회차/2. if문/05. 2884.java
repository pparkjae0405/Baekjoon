import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // 45분 일찍 알람 설정하는데
        b = b - 45;
        // b가 음수가 되면
        if(b<0){
            // 1. a가 0이면 23
            if(a == 0)
                a = 23;
            // 2. 아니면 a-1 하여 a 설정
            else
                a = a - 1;

            // b가 음수이므로 +60
            b = b + 60;
        }
        // b가 음수이면 if문을 돌고 나와 a, b가 설정되고,
        // b가 양수이면 if문을 건너 뛰어 a, b가 설정됨.
        System.out.println(a + " " + b);
    }
}
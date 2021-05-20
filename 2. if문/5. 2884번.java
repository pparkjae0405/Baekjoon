import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        int a,b,b1;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        b = b - 45;
        if(b <0) {
            if(a == 0)
                a = 23;
            else
                a = a - 1;
            b1 = 60 + b;
            System.out.println(a +" "+ b1);
        }
        else{
            System.out.println(a +" "+ b);
        }

    }
}
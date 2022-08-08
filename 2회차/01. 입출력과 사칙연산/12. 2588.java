import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println((b%10)*a);
        System.out.println((b/10)%10*a);
        System.out.println((b/100)*a);
        System.out.println(a*b);
    }
}
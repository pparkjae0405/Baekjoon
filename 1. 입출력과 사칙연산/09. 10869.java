import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        int a,b, c1, c2, c3, c4, c5;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c1 = a+b; c2 = a-b; c3 = a*b; c4 = a/b; c5 = a%b;
        System.out.print(c1 + "\n" + c2 + "\n" + c3 + "\n" + c4 + "\n" + c5 );
    }
}
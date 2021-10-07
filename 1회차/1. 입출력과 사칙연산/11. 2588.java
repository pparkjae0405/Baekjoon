import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        int a1,a2,b1,b2,b3,b4;
        Scanner sc = new Scanner(System.in);
        a1 = sc.nextInt();
        a2 = sc.nextInt();
        b1 = a1*((a2%100)%10);
        b2 = a1*((a2%100)/10);
        b3 = a1*(a2/100);
        b4 = a1*a2;
        System.out.println(b1 + "\n" + b2 + "\n" + b3 + "\n" + b4);
    }
}
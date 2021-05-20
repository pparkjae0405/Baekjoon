import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        int a,b,c,d;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        for(b = 1; b<=a; b++){
            c = sc.nextInt();
            d = sc.nextInt();
            System.out.println(c+d);
        }
    }
}
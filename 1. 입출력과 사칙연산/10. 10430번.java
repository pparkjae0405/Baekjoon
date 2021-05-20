import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        int a,b,c, d1,d2,d3,d4;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        d1=(a+b)%c; d2=((a%c)+(b%c))%c; d3=(a*b)%c; d4= ((a%c)*(b%c))%c;
        System.out.println(d1 + "\n" + d2 + "\n" + d3 + "\n" + d4);
    }
}
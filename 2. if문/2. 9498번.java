import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        int a;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        switch(a/10){
            case 10:
            case 9:
                System.out.println("A");
                break;
            case 8:
                System.out.println("B");
                break;
            case 7:
                System.out.println("C");
                break;
            case 6:
                System.out.println("D");
                break;
            default:
                System.out.println("F");
                break;
        }
    }
}
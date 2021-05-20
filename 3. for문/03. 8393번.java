import java.util.Scanner;
public class Main {
    public static void main(String args[]){
        int a,c = 0;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        for(int b = 1; b<=a; b++){
            c = c + b;
        }
        System.out.println(c);
    }
}
import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int a1 = a;
        for(int i=1;i<=a;i++) { // 반복횟수
            for (int j=a1;j>1;j--) // 공백개수
                System.out.print(" ");
            a1--;
            for(int j1=1;j1<=i;j1++) // *개수
                System.out.print("*");
            System.out.print("\n");
        }
    }
}
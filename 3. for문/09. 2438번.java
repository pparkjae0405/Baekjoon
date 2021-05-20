import java.util.*;
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for(int i=1;i<=a;i++) { //반복횟수
            for (int j = 1; j <= i; j++) { //* 개수
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
}
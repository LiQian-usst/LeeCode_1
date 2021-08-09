package test.Test;

import java.util.Scanner;

public class Demo1 {
    static int n, k =2;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        System.out.print(n+"=");
        f(n);
    }

    public static void f(int n){
        while(k<=n){
            if(k==n){
                System.out.print(n);
                break;
            }else if(n>k && n%k==0){
                System.out.print(k+"*");
                n = n/k;
                f(n);
                break;
            }else if(n>k && n%k!=0){
                k++;
                f(n);
                break;
            }
        }
    }
}

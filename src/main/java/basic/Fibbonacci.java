package basic;

import java.util.Scanner;

public class Fibbonacci {

    static void fib(int n)
    {
        int []fib = new int[n+1];
        fib[0]=0;
        fib[1]=1;

        for (int i = 2; i <= n; i++) {

            fib[i]=fib[i-1]+fib[i-2];
            System.out.println(fib[i]);
        }
    }
    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);
        fib(scanner.nextInt());
    }
}

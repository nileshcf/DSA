package basic;

import java.util.Scanner;

public class SieveOfErathosthenes {

    static void sieve(int n)
    {
        boolean[] sieve = new boolean[n+1];
        for (int i = 0; i < n; i++) {

            sieve[i]=true;
        }

        for (int i=2;i<=n;i++)
        {
            if(sieve[i])
            {
                System.out.println(i);
                for (int p = i*i;p<=n;p+=i)
                {
                    sieve[p]=false;
                }

            }
        }
        return;

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        sieve(scanner.nextInt());
        
    }
}

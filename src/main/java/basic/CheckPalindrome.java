package basic;

import java.util.Scanner;

public class CheckPalindrome {

    static boolean palindrome(String s)
    {

        int n = s.length();
        for (int i = 0; i < n/2; i++) {

            if(s.charAt(i)!=s.charAt(n-i-1))
             return false;

        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println(palindrome(scanner.next()));


    }
}

package basic;

import java.util.Scanner;

public class ReverseString {

    static void reverse(String s)
    {

        String sb = new StringBuilder(s).reverse().toString();
        System.out.println(sb);
    }

    public static void main(String[] args) {
        String str = "nilesh";
        Scanner sc = new Scanner(System.in);

         String inp=sc.next();

        reverse(str);
        reverse(inp);


    }
}

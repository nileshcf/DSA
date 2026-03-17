package basic;

import java.util.Scanner;

public class ConsonantAndVowel {

    static void count(String s)
    {
        int n = s.length();
        int vowel=0,consonants=0;
        for (int i=0;i<n;i++)
        {
            if("aeiouAEIOU".indexOf(s.charAt(i))!=-1)
            {
                vowel++;
            } else if (Character.isLetter(s.charAt(i))) {

                consonants++;
            }
        }

        System.out.println("Vowels are : "+vowel+" Consonants are : "+ consonants);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        count(scanner.next());
    }
}

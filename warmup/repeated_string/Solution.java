package warmup.repeated_string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 Warm Up: Repeated String
 https://www.hackerrank.com/challenges/repeated-string/problem

 Lilah has a string, s, of lowercase English letters that she repeated infinitely many times.
 Given an integer, n, find and print the number of letter a's in the first n letters of Lilah's infinite string.

 For example, if the string 'abcac' and n=10, the substring we consider is abcacabcac, the first 10 characters of her infinite string. There are 4 occurrences of a in the substring.

 Function Description
 Complete the repeatedString function in the editor below. It should return an integer representing the number of occurrences of a in the prefix of length n in the infinitely repeating string.

 repeatedString has the following parameter(s):
 s: a string to repeat
 n: the number of characters to consider

 Input Format
 The first line contains a single string, s.
 The second line contains an integer, n.

 Output Format
 Print a single integer denoting the number of letter a's in the first n letters of the infinite string created by repeating s infinitely many times.

 Sample Input 0
 aba
 10

 Sample Output 0
 7

 Explanation 0
 The first  letters of the infinite string are abaabaabaa. Because there are 7 a's, we print 7 on a new line.

 Sample Input 1
 a
 1000000000000

 Sample Output 1
 1000000000000
 */

public class Solution {

    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        long occurrences = checkOccurencesWithLimit(s, s.length());
        occurrences = occurrences * (long) Math.floor(n / s.length());

        occurrences += checkOccurencesWithLimit(s, n%s.length());

        return occurrences;
    }

    private static long checkOccurencesWithLimit(String s, long limit) {
        long occurrences = 0;
        for (int i = 0; i < limit; i++) {
            if (s.charAt(i) == 'a') {
                occurrences++;
            }
        }
        return occurrences;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s = scanner.nextLine();

        long n = scanner.nextLong();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long result = repeatedString(s, n);

        System.out.println(result);

        scanner.close();
    }
}


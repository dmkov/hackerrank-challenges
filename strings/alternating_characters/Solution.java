package strings.alternating_characters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 Sorting: Alternating Characters
 https://www.hackerrank.com/challenges/alternating-characters/problem

 You are given a string containing characters A and B only. Your task is to change it into a string such that there are no matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.

 Your task is to find the minimum number of required deletions.

 For example, given the string s=AABAAB, remove an A at positions 0 and 3 to make s=ABAB in 2 deletions.

 Function Description
 Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum number of deletions to make the alternating string.

 alternatingCharacters has the following parameter(s):
 s: a string

 Input Format
 The first line contains an integer q, the number of queries.
 The next q lines each contain a string s.

 Output Format
 For each query, print the minimum number of deletions required on a new line.

 Sample Input
 5
 AAAA
 BBBBB
 ABABABAB
 BABABA
 AAABBB

 Sample Output
 3
 4
 0
 0
 4
 */

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
        int deletions = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                deletions++;
            }
        }
        return deletions;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            System.out.println(result);
        }

        scanner.close();
    }
}

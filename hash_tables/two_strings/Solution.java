package hash_tables.two_strings;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 Hash Tables: Two Strings
 https://www.hackerrank.com/challenges/two-strings/problem

 Given two strings, determine if they share a common substring. A substring may be as small as one character.
 For example, the words "a", "and", "art" share the common substring . The words "be" and "cat" do not share a substring.

 Function Description
 Complete the function twoStrings in the editor below. It should return a string, either YES or NO based on whether the strings share a common substring.

 twoStrings has the following parameter(s):
 s1, s2: two strings to analyze .

 Input Format
 The first line contains a single integer p, the number of test cases.

 The following p pairs of lines are as follows:
 The first line contains string s1.
 The second line contains string s2.

 Output Format
 For each pair of strings, return YES or NO.

 Sample Input
 2
 hello
 world
 hi
 world

 Sample Output
 YES
 NO
 */

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
        Set<Character> chars1 = computeCharactersFromString(s1);
        boolean check = false;

        for (int i = 0; i < s2.length(); i++) {
            if (chars1.contains(s2.charAt(i))) {
                check = true;
                break;
            }
        }

        if (check) {
            return "YES";
        } else {
            return "NO";
        }
    }

    private static Set<Character> computeCharactersFromString(String str) {
        Set<Character> result = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            result.add(str.charAt(i));
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
        }
    }
}

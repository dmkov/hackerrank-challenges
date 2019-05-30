package hash_tables.sherlock_and_anagrams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 Hash Tables: Sherlock and Anagrams
 https://www.hackerrank.com/challenges/sherlock-and-anagrams/problem

 Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

 For example s = mom, the list of all anagrammatic pairs is [m,m], [mo,om] at positions [[0],[2]],[[0,1],[1,2]] respectively.

 Function Description
 Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in s.

 sherlockAndAnagrams has the following parameter(s):
 s: a string .
 Input Format

 The first line contains an integer q, the number of queries.
 Each of the next q lines contains a string s to analyze.

 Output Format
 For each query, return the number of unordered anagrammatic pairs.

 Sample Input 0
 2
 abba
 abcd

 Sample Output 0
 4
 0

 Sample Input 1
 2
 ifailuhkqq
 kkkk

 Sample Output 1
 3
 10

 Sample Input 2
 1
 cdcd

 Sample Output 2
 5
 */

public class Solution {

    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        HashMap<String, Integer> anagrams = new HashMap<>();
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                char[] chars = substring.toCharArray();
                Arrays.sort(chars);

                String check = String.valueOf(chars);
                Integer value = anagrams.get(check);
                if (value != null && value > 0) {
                    total += value;
                    anagrams.put(check, value + 1);
                } else {
                    anagrams.put(check, 1);
                }
            }
        }

        return total;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
        }

        scanner.close();
    }
}

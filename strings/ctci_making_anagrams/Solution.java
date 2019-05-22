package strings.ctci_making_anagrams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 Strings: Making Anagrams
 https://www.hackerrank.com/challenges/ctci-making-anagrams/problem

 Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

 Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?

 Given two strings, a and b, that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

 For example, if a = cde and b = dcf, we can delete e from string a and f from string b so that both remaining strings are cd and dc which are anagrams.

 Function Description
 Complete the makeAnagram function in the editor below. It must return an integer representing the minimum total characters that must be deleted to make the strings anagrams.

 makeAnagram has the following parameter(s):
 a: a string
 b: a string

 Input Format
 The first line contains a single string, a.
 The second line contains a single string, b.

 Constraints
 The strings a and b consist of lowercase English alphabetic letters ascii[a-z].

 Output Format
 Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.

 Sample Input
 cde
 abc

 Sample Output
 4

 Solution: https://www.hackerrank.com/challenges/ctci-making-anagrams/editorial -- can be done with arrays instead of HashMaps.
 Short simple approach: https://www.hackerrank.com/challenges/ctci-making-anagrams/forum/comments/221768?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=strings
 */
public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int total = 0;
        Map<Character, Integer>mapA = convertStringToMap(a);
        Map<Character, Integer>mapB = convertStringToMap(b);

        for (Entry<Character, Integer> entry : mapA.entrySet()) {
            Integer valueB = mapB.get(entry.getKey());
            if (valueB != null) {
                total += Math.abs(entry.getValue() - valueB);
                mapB.remove(entry.getKey());
            } else {
                total += entry.getValue();
            }
        }
        for (Integer value: mapB.values()) {
            total += value;
        }

        return total;
    }

    private static Map<Character, Integer> convertStringToMap(String a) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            Character character = a.charAt(i);
            Integer value = map.getOrDefault(character, 0);
            value++;
            map.put(character, value);
        }

        return map;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);
        System.out.println(res);

        scanner.close();
    }
}

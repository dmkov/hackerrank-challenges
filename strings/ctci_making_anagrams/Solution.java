package strings.ctci_making_anagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 Arrays: Left Rotation
 https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem

 Given two strings, a and b, that may or may not be of the same length,
 determine the minimum number of character deletions required to make a and b anagrams.
 Any characters can be deleted from either of the strings.

 Sample Input:
 cde
 abc

 Sample Output:
 4

 Solution: https://www.hackerrank.com/challenges/ctci-making-anagrams/editorial -- can be done with arrays instead of HashMaps.
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();

        HashMap<Character, Integer> first = splitStringIntoMap(a);
        HashMap<Character, Integer> second = splitStringIntoMap(b);

        System.out.println(numberNeeded(first, second));
    }

    private static HashMap<Character, Integer> splitStringIntoMap(String str) {
        HashMap<Character, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            Integer counter = result.get(ch);
            if (counter == null) {
                result.put(ch, 1);
            } else {
                result.put(ch, counter + 1);
            }
        }

        return result;
    }

    private static int calculateDiff(HashMap<Character, Integer> first, HashMap<Character, Integer> second) {
        int result = 0;

        for (Map.Entry<Character, Integer> entry : first.entrySet()) {
            Integer counter = second.get(entry.getKey());
            if (counter == null) {
                result += entry.getValue();
            } else if (entry.getValue() > counter) {
                //If counter is greater, it will be calculated in next function call
                result += entry.getValue() - counter;
            }
        }

        return result;
    }

    private static int numberNeeded(HashMap<Character, Integer> first, HashMap<Character, Integer> second) {
        return calculateDiff(first, second) + calculateDiff(second, first);
    }
}

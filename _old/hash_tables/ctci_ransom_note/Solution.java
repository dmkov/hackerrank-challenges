package hash_tables.ctci_ransom_note;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 Hash Tables: Ransom Note
 https://www.hackerrank.com/challenges/ctci-ransom-note/problem

 A kidnapper wrote a ransom note but is worried it will be traced back to him.
 He found a magazine and wants to know if he can cut out whole words from it and use them to create an untraceable
 replica of his ransom note. The words in his note are case-sensitive and he must use whole words available in
 the magazine, meaning he cannot use substrings or concatenation to create the words he needs.

 Given the words in the magazine and the words in the ransom note, print Yes if he can replicate his ransom
 note exactly using whole words from the magazine; otherwise, print No.

 Input Format:
 The first line contains two space-separated integers describing the respective values of m (the number of words
 in the magazine) and n (the number of words in the ransom note).
 The second line contains m space-separated strings denoting the words present in the magazine.
 The third line contains n space-separated strings denoting the words present in the ransom note.

 Output Format:
 Print Yes if he can use the magazine to create an untraceable replica of his ransom note; otherwise, print No.

 Sample Input 0:
 6 4
 give me one grand today night
 give one grand today

 Sample Output 0:
 Yes

 Sample Input 1:
 6 5
 two times three is not four
 two times two is four

 Sample Output 1
 No

 Solution: https://www.hackerrank.com/challenges/ctci-ransom-note/editorial
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }

        HashMap<String, Integer> magazineMap = convertArrayToMap(magazine);
        HashMap<String, Integer> ransomMap = convertArrayToMap(ransom);

        if (checkOccurrences(magazineMap, ransomMap)) {
            System.out.print("Yes");
        } else {
            System.out.print("No");
        }

    }

    private static HashMap<String, Integer> convertArrayToMap(String[] strings) {
        HashMap <String, Integer> result = new HashMap<>();
        for (String string : strings) {
            Integer counter = result.get(string);
            if (counter == null) {
                result.put(string, 1);
            } else {
                result.put(string, counter + 1);
            }
        }

        return result;
    }

    private static boolean checkOccurrences(HashMap<String, Integer> magazineMap, HashMap<String, Integer> ransomMap) {
        boolean result = true;

        for (Map.Entry<String, Integer> entry : ransomMap.entrySet()) {
            if (magazineMap.get(entry.getKey()) - entry.getValue() < 0) {
                result = false;
            }
        }

        return result;
    }


}

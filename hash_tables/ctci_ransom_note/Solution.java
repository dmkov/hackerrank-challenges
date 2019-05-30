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

    // Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
        Map<String, Integer> magazineWords = convertArrayToMap(magazine);
        boolean check = true;

        for (String word: note) {
            Integer match = magazineWords.get(word);
            if (match != null && match >= 1) {
                match--;
                magazineWords.put(word, match);
            } else {
                check = false;
                break;
            }
        }

        if (check) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static Map<String, Integer> convertArrayToMap(String[] strings) {
        Map<String, Integer> result = new HashMap<>();
        for (String word: strings) {
            Integer match = result.getOrDefault(word, 0);
            match++;
            result.put(word, match);
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}

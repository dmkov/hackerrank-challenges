package tries.ctci_contacts;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 Tries: Contacts
 https://www.hackerrank.com/challenges/ctci-contacts/problem

 We're going to make our own Contacts application! The application must perform two types of operations:

 1. add name, where name is a string denoting a contact name. This must store name as a new contact in the application.
 2. find partial, where partial is a string denoting a partial name to search the application for.
 It must count the number of contacts starting with partial and print the count on a new line.

 Given n sequential add and find operations, perform each operation in order.

 Input Format

 The first line contains a single integer, n, denoting the number of operations to perform.
 Each line i of the n subsequent lines contains an operation in one of the two forms defined above.

 Output Format

 For each find partial operation, print the number of contact names starting with  on a new line.

 Sample Input
 4
 add hack
 add hackerrank
 find hac
 find hak

 Sample Output
 2
 0

 Explanation
 We perform the following sequence of operations:
 1. Add a contact named hack.
 2. Add a contact named hackerrank.
 3. Find and print the number of contact names beginning with hac. There are currently two contact names in
 the application and both of them start with hac, so we print 2 on a new line.
 4. Find and print the number of contact names beginning with hak. There are currently two contact names in
 the application but neither of them start with hak, so we print 0 on a new line.

 */

public class Solution {

    static class Char {
        HashMap <Character, Char> children = new HashMap<>();
        Integer count = 0;
    }

    private static final Scanner scanner = new Scanner(System.in);
    private static final Char start = new Char();

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int nItr = 0; nItr < n; nItr++) {
            String[] opContact = scanner.nextLine().split(" ");

            String op = opContact[0];
            String contact = opContact[1];

            switch (op) {
                case "add":
                    addContract(contact);
                    break;
                case "find":
                    findContract(contact);
                    break;
            }

        }

        scanner.close();
    }

    private static void addContract(String contact) {
        char[] word = contact.toCharArray();
        addWord(start, word);
    }

    private static void addWord(Char current, char[] word) {
        char needed = word[0];
        Char next = current.children.get(needed);

        if (next == null) {
            next = new Char();
            current.children.put(needed, next);
        }
        next.count++;

        if (word.length > 1) {
            addWord(next, Arrays.copyOfRange(word, 1, word.length));
        }
    }

    private static void findContract(String contact) {
        char[] word = contact.toCharArray();
        Char last = getLastChar(start, word);

        System.out.println((last != null)?last.count:0);
    }

    private static Char getLastChar(Char current, char[] word) {
        char needed = word[0];
        Char next = current.children.get(needed);

        if (next != null) {
            if (word.length > 1) {
                return getLastChar(next, Arrays.copyOfRange(word, 1, word.length));
            } else {
                return next;
            }
        } else {
            return null;
        }
    }
}


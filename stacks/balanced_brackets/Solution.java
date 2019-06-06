package stacks.balanced_brackets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 Stacks: Balanced Brackets
 https://www.hackerrank.com/challenges/balanced-brackets/problem

 A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

 Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left of a closing bracket (i.e., ), ], or }) of the exact same type. There are three types of matched pairs of brackets: [], {}, and ().

 A matching pair of brackets is not balanced if the set of brackets it encloses are not matched. For example, {[(])} is not balanced because the contents in between { and } are not balanced. The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses a single, unbalanced closing square bracket, ].

 By this logic, we say a sequence of brackets is balanced if the following conditions are met:
 It contains no unmatched brackets.
 The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.

 Given n strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced, return YES. Otherwise, return NO.

 Function Description
 Complete the function isBalanced in the editor below. It must return a string: YES if the sequence is balanced or NO if it is not.

 isBalanced has the following parameter(s):
 s: a string of brackets

 Input Format
 The first line contains a single integer n, the number of strings.
 Each of the next n lines contains a single string s, a sequence of brackets.

 Output Format
 For each string, return YES or NO.

 Sample Input
 3
 {[()]}
 {[(])}
 {{[[(())]]}}

 Sample Output
 YES
 NO
 YES

 Explanation
 The string {[()]} meets both criteria for being a balanced string, so we print YES on a new line.
 The string {[(])} is not balanced because the brackets enclosed by the matched pair { and } are not balanced: [(]).
 The string {{[[(())]]}} meets both criteria for being a balanced string, so we print YES on a new line.

 ------------------------

 1. Complexity
    1.1 Time Complexity is O(n) - where n is the number of characters in the string
    1.2 Space Complexity is O(1)
 2. Approach
    2.1 The solution is based on stack push() and pop() methods
    2.2 Implementation
        2.2.1 Check if string is empty or number of elements is odd
        2.2.2 Iterate through the string, check the every character:
        2.2.3 If it is open bracket, put it into the stack
        2.2.4 If it is closed bracket - pop the last item from the stack and compare if they are same type
        2.2.5 At the end check the size of remaining stack (!do not forget to check it also when you test
            the closed bracket for cases "{}}}" - when stack is empty because of the missing open brackets)
 */

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        String result = "YES";
        if (s == null || s.length() % 2 == 1) {
            return "NO";
        }

        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (isOpenBracket(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !isPairedBracket(stack.pop(), ch)) {
                    result = "NO";
                    break;
                }
            }
        }

        return (stack.isEmpty()) ? result : "NO";
    }

    private static boolean isOpenBracket(char ch) {
        return ch == '[' || ch == '{' || ch == '(';
    }

    private static boolean isPairedBracket(char first, char second) {
        switch (first) {
            case '[':
                return second == ']';
            case '{':
                return second == '}';
            case '(':
                return second == ')';
            default:
                return false;
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(result);
        }

        scanner.close();
    }
}

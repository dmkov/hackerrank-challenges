package stacks.ctci_balanced_brackets;

import java.util.Scanner;
import java.util.Stack;

/**
 Stacks: Balanced Brackets
 https://www.hackerrank.com/challenges/ctci-balanced-brackets/problem

 A bracket is considered to be any one of the following characters: (, ), {, }, [, or ].

 Two brackets are considered to be a matched pair if the an opening bracket (i.e., (, [, or {) occurs to the left
 of a closing bracket (i.e., ), ], or }) of the exact same type.
 There are three types of matched pairs of brackets: [], {}, and ().

 A matching pair of brackets is not balanced if the set of brackets it encloses are not matched.
 For example, {[(])} is not balanced because the contents in between { and } are not balanced.
 The pair of square brackets encloses a single, unbalanced opening bracket, (, and the pair of parentheses encloses
 a single, unbalanced closing square bracket, ].

 Some examples of balanced brackets are []{}(), [({})]{}() and ({(){}[]})[].

 By this logic, we say a sequence of brackets is considered to be balanced if the following conditions are met:

 - It contains no unmatched brackets.
 - The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.

 Given  strings of brackets, determine whether each sequence of brackets is balanced. If a string is balanced,
 print YES on a new line; otherwise, print NO on a new line.

 Input Format:
 The first line contains a single integer, n, denoting the number of strings.
 Each line i of the n subsequent lines consists of a single string, s, denoting a sequence of brackets.

 Output Format:
 For each string, print whether or not the string of brackets is balanced on a new line.
 If the brackets are balanced, print YES; otherwise, print NO.

 Sample Input 0:
 3
 {[()]}
 {[(])}
 {{[[(())]]}}

 Sample Output 0:
 YES
 NO
 YES
 */

public class Solution {

    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            if (isOpenBrackets(expression.charAt(i))) {
                stack.push(expression.charAt(i));
            } else {
                if (stack.size() > 0 && checkBracketPair(stack.lastElement(), expression.charAt(i))) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }

        return (stack.size() == 0);
    }

    private static boolean isOpenBrackets(char ch) {
        boolean result = false;
        if (ch == '[' || ch == '{' || ch == '(') {
            result = true;
        }

        return result;
    }

    private static boolean checkBracketPair(char first, char second) {
        boolean result = false;
        if ((first == '[' && second == ']') || (first == '{' && second == '}') || (first == '(' && second == ')')) {
            result = true;
        }

        return result;
    }

//  My original solution without stack:
//
//    private static boolean isBalanced(String expression) {
//        boolean isExpressionModified = true;
//
//        while (isExpressionModified && expression.length() >= 2) {
//            isExpressionModified = false;
//
//            for (int i = 0; i < expression.length() - 1; i++) {
//                if (checkBracketPair(expression.charAt(i), expression.charAt(i + 1))) {
//                    expression = ((i != 0) ? (expression.substring(0, i)) : "")
//                            + ((i < expression.length() - 2) ? (expression.substring(i + 2, expression.length())) : "");
//
//                    isExpressionModified = true;
//                }
//            }
//        }
//
//        return !(expression.length() > 0);
//    }
//
//    private static boolean checkBracketPair(char first, char second) {
//        boolean result = false;
//        if ((first == '[' && second == ']') || (first == '{' && second == '}') || (first == '(' && second == ')')) {
//            result = true;
//        }
//
//        return result;
//    }


//  Another good example
//  def is_matched(e):
//    while( len(e) > 0):
//      t = e
//      e = e.replace('()','')
//      e = e.replace('{}','')
//      e = e.replace('[]','')
//            if t == e:
//            return False
//
//    return True

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}


// {[()]}

package warmup.sock_merchant;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/**
 Warm Up: Sock Merchant
 https://www.hackerrank.com/challenges/sock-merchant/problem

 John works at a clothing store. He has a large pile of socks that he must pair by color for sale. Given an array of integers representing the color of each sock, determine how many pairs of socks with matching colors there are.

 For example, there are n=7 socks with colors ar = [1,2,1,2,1,2,3]. There is one pair of color 1 and one of color 2. There are three odd socks left, one of each color. The number of pairs is 2.

 Function Description
 Complete the sockMerchant function in the editor below. It must return an integer representing the number of matching pairs of socks that are available.

 sockMerchant has the following parameter(s):
 n: the number of socks in the pile
 ar: the colors of each sock

 Input Format
 The first line contains an integer n, the number of socks represented in ar.
 The second line contains n space-separated integers describing the colors ar[j] of the socks in the pile.

 Output Format
 Return the total number of matching pairs of socks that John can sell.

 Sample Input
 9
 10 20 20 10 10 30 50 10 20

 Sample Output
 3
 */

public class Solution {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        int result = 0;
        Set<Integer> checkSet = new HashSet<>();

        for (int color: ar) {
            if (checkSet.contains(color)) {
                result++;
                checkSet.remove(color);
            } else {
                checkSet.add(color);
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        System.out.print(result);
    }
}


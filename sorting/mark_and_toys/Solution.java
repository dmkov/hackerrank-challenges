package sorting.mark_and_toys;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 Sorting: Mark and Toys
 https://www.hackerrank.com/challenges/mark-and-toys/problem

 Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money.

 Given a list of prices and an amount to spend, what is the maximum number of toys Mark can buy? For example, if prices=[1,2,3,4] and Mark has k=7 to spend, he can buy items [,1,2,3] for 6, or [3,4] for 7 units of currency. He would choose the first group of 3 items.

 Function Description
 Complete the function maximumToys in the editor below. It should return an integer representing the maximum number of toys Mark can purchase.

 maximumToys has the following parameter(s):
 prices: an array of integers representing toy prices
 k: an integer, Mark's budget

 Input Format
 The first line contains two integers,  and , the number of priced toys and the amount Mark has to spend.
 The next line contains  space-separated integers

 Output Format
 An integer that denotes the maximum number of toys Mark can buy for his son.

 Sample Input
 7 50
 1 12 5 111 200 1000 10

 Sample Output
 4
 */

public class Solution {

    // Complete the maximumToys function below.
    static int maximumToys(int[] prices, int k) {
        int total = 0;
        int toys = 0;

        Arrays.sort(prices);

        for (int price : prices) {
            if (total + price <= k) {
                total += price;
                toys++;
            } else {
                break;
            }
        }
        return toys;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nk = scanner.nextLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] prices = new int[n];

        String[] pricesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pricesItem = Integer.parseInt(pricesItems[i]);
            prices[i] = pricesItem;
        }

        int result = maximumToys(prices, k);

        System.out.println(result);

        scanner.close();
    }
}

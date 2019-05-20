package arrays.minimum_swaps_2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 Arrays: Minimum Swaps 2
 https://www.hackerrank.com/challenges/minimum-swaps-2/problem

 You are given an unordered array consisting of consecutive integers [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.

 For example, given the array [7, 1, 3, 2, 4, 5, 6]  we perform the following steps:

 i   arr                         swap (indices)
 0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
 1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
 2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
 3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
 4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
 5   [1, 2, 3, 4, 5, 6, 7]
 It took 5 swaps to sort the array.

 Function Description
 Complete the function minimumSwaps in the editor below. It must return an integer representing the minimum number of swaps to sort the array.
 minimumSwaps has the following parameter(s):
 arr: an unordered array of integers

 Input Format
 The first line contains an integer, n, the size of arr.
 The second line contains n space-separated integers arr[i].

 Output Format
 Return the minimum number of swaps to sort the given array.

 Sample Input 0
 4
 4 3 1 2

 Sample Output 0
 3

 Sample Input 1
 5
 2 3 4 1 5

 Sample Output 1
 3

 Sample Input 2
 7
 1 3 5 2 4 6 7

 Sample Output 2
 3
 */

public class Solution {
    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int swaps = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != i + 1) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.println(res);

        scanner.close();
    }
}

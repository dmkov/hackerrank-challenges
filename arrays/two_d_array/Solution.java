package arrays.two_d_array;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 Arrays: 2D Array - DS
 https://www.hackerrank.com/challenges/2d-array/problem

 Given a 6x6 2D Array, arr:
 1 1 1 0 0 0
 0 1 0 0 0 0
 1 1 1 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0
 0 0 0 0 0 0

 We define an hourglass in A to be a subset of values with indices falling in this pattern in arr's graphical representation:
 a b c
   d
 e f g

 There are 16 hourglasses in arr, and an hourglass sum is the sum of an hourglass' values. Calculate the hourglass sum for every hourglass in arr, then print the maximum hourglass sum.

 For example, given the 2D array:
 -9 -9 -9  1 1 1
  0 -9  0  4 3 2
 -9 -9 -9  1 2 3
  0  0  8  6 6 0
  0  0  0 -2 0 0
  0  0  1  2 4 0

 We calculate the following 16 hourglass values:
 -63, -34, -9,  12,
 -10,  0,   28, 23,
 -27, -11, -2,  10,
  9,   17,  25, 18

 Our highest hourglass value is 28 from the hourglass:
 0 4 3
   1
 8 6 6
 Note: If you have already solved the Java domain's Java 2D Array challenge, you may wish to skip this challenge.

 Function Description
 Complete the function hourglassSum in the editor below. It should return an integer, the maximum hourglass sum in the array.
 hourglassSum has the following parameter(s):
 arr: an array of integers

 Input Format
 Each of the 6 lines of inputs arr[i] contains 6 space-separated integers arr[i][j].

 Output Format
 Print the largest (maximum) hourglass sum found in .

 Sample Input
 1 1 1 0 0 0
 0 1 0 0 0 0
 1 1 1 0 0 0
 0 0 2 4 4 0
 0 0 0 2 0 0
 0 0 1 2 4 0

 Sample Output
 19
 */

public class Solution {
    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
        int sum;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[0].length - 1; j++) {
                sum = arr[i - 1][j - 1] + arr[i - 1][j] + arr[i - 1][j + 1] + arr[i][j] +
                        arr[i + 1][j - 1] + arr[i + 1][j] + arr[i + 1][j + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        System.out.println(result);

        scanner.close();
    }
}

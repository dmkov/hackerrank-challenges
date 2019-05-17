package arrays.ctci_array_left_rotation;

import java.util.Scanner;

/**
 Arrays: Left Rotation
 https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem

 A left rotation operation on an array of size n shifts each of the array's elements 1 unit to the left.
 For example, if 2 left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].

 Given an array of n integers and a number, d, perform d left rotations on the array.
 Then print the updated array as a single line of space-separated integers. Example 1:

 Sample Input:
 5 4
 1 2 3 4 5

 Output:
 5 1 2 3 4
 */

public class Solution {
    // Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (i + d < a.length) {
                result[i] = a[i + d];
            } else {
                result[i] = a[i + d - a.length];
            }
        }

        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);
        int d = Integer.parseInt(nd[1]);
        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);

            if (i != result.length - 1) {
                System.out.print(" ");
            }
        }

        scanner.close();
    }
}

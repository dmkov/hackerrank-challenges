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

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        printResult(a, d);
    }

    private static void printResult(int[] old, int d) {
        int n = old.length;

        for (int i = 0; i < n; i++) {
            int k = i + d;
            if (k >= n) {
                k = k - n;
            }

            System.out.print(old[k] + " ");
        }
    }
}

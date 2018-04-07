package sorting.ctci_bubble_sort;

import java.util.Scanner;

/**
 Sorting: Bubble Sort
 https://www.hackerrank.com/challenges/ctci-bubble-sort/problem

 Given an n-element array A, sort array A in ascending order using the Bubble Sort algorithm above.
 Once sorted, print the following three lines:

 Array is sorted in numSwaps swaps., where numSwaps is the number of swaps that took place.
 First Element: firstElement, where  is the first element in the sorted array.
 Last Element: lastElement, where  is the last element in the sorted array.

 Hint: To complete this challenge, you must add a variable that keeps a running tally of all swaps that occur
 during execution.

 Input Format:

 The first line contains an integer, n, denoting the number of elements in array A.
 The second line contains n space-separated integers describing the respective values of A.

 Output Format:

 You must print the following three lines of output:
 Array is sorted in numSwaps swaps., where  is the number of swaps that took place.
 First Element: firstElement, where  is the first element in the sorted array.
 Last Element: lastElement, where  is the last element in the sorted array.

 Sample Input 0:
 3
 1 2 3

 Sample Output 0:
 Array is sorted in 0 swaps.
 First Element: 1
 Last Element: 3

 Sample Input 1:
 3
 3 2 1

 Sample Output 1:
 Array is sorted in 3 swaps.
 First Element: 1
 Last Element: 3

 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        sortItems(a);
    }

    private static void sortItems(int[] a) {
        int numSwaps = 0;
        for (int i = 0; i < a.length; i++) {
            boolean check = false;
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j+1]) {
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;

                    check = true;
                    numSwaps++;
                }
            }

            if (!check) {
                break;
            }
        }

        System.out.printf("Array is sorted in %d swaps.\n", numSwaps);
        System.out.printf("First Element: %d", a[0]);
        System.out.printf("Last Element: %d", a[a.length - 1]);
    }
}

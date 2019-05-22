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

    // Complete the countSwaps function below.
    static void countSwaps(int[] a) {
        int swaps = 0;
        boolean sorted = false;
        int sortLimit = a.length - 1;

        while (!sorted) {
            sorted = true;
            for (int i = 0; i < sortLimit; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                    sorted = false;
                    swaps++;
                }
            }
            sortLimit--;
        }

        System.out.printf("Array is sorted in %d swaps.\n", swaps);
        System.out.printf("First Element: %d\n", a[0]);
        System.out.printf("Last Element: %d", a[a.length - 1]);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        countSwaps(a);

        scanner.close();
    }
}

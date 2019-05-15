package heaps.ctci_find_the_running_median;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 Heaps: Find the Running Median
 https://www.hackerrank.com/challenges/ctci-find-the-running-median/problem

 The median of a dataset of integers is the midpoint value of the dataset for which an equal number of integers
 are less than and greater than the value. To find the median, you must first sort your dataset of integers
 in non-decreasing order, then:

 If your dataset contains an odd number of elements, the median is the middle element of the sorted sample.
 In the sorted dataset {1,2,3}, 2 is the median.
 If your dataset contains an even number of elements, the median is the average of the two middle elements
 of the sorted sample. In the sorted dataset {1,2,3,4}, (2+3)/2 = 2.5 is the median.
 Given an input stream of  integers, you must perform the following task for each  integer:

 Add the i integer to a running list of integers.
 Find the median of the updated list (i.e., for the first element through the i element).
 Print the list's updated median on a new line. The printed value must be a double-precision number
 scaled to 1 decimal place (i.e., 12.3 format).

 Input Format:
 The first line contains a single integer, n, denoting the number of integers in the data stream.
 Each line i of the n subsequent lines contains an integer, a(i), to be added to your list.

 Output format:
 After each new integer is added to the list, print the list's updated median on a new line as a
 single double-precision number scaled to 1 decimal place (i.e., 12.3 format).

 Sample Input:
 6
 12
 4
 5
 3
 8
 7

 Sample Output:
 12.0
 8.0
 5.0
 4.5
 5.0
 6.0

 Solution: https://www.hackerrank.com/challenges/ctci-find-the-running-median/editorial
 Commented option is more simple without heaps.
 */

public class Solution {

    public static PriorityQueue<Integer> minQueue;
    public static PriorityQueue<Integer> maxQueue;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] sorted = new int[n];

        minQueue = new PriorityQueue<>(n, Comparator.reverseOrder());
        maxQueue = new PriorityQueue<>(n);

        for(int a_i=0; a_i < n; a_i++){
            int number = in.nextInt();

            a[a_i] = sorted[a_i] = number;

            insertNumber(number);
            balance();
            System.out.println(getMedianValue());

//            balance(sorted, a_i);
//            System.out.println(calculateMedian(sorted, a_i + 1));
        }
    }

    static void insertNumber(Integer num) {
        if (minQueue.size() == 0 || minQueue.peek() > num) {
            minQueue.add(num);
        } else {
            maxQueue.add(num);
        }
    }

    static void balance() {
        if (minQueue.size() > maxQueue.size() + 1) {
            maxQueue.add(minQueue.poll());
        }
        if (minQueue.size() + 1 < maxQueue.size()) {
            minQueue.add(maxQueue.poll());
        }
    }

    static double getMedianValue() {
        if ((minQueue.size() + maxQueue.size()) % 2 == 0) {
            return (double)(minQueue.peek() + maxQueue.peek()) / 2;
        } else {
            return (minQueue.size() > maxQueue.size()) ? minQueue.peek() : maxQueue.peek();
        }
    }


//    public static void balance(int[] arr, int index) {
//        if (index == 0) {
//            return;
//        }
//
//        while (index > 0 && arr[index] > arr[index - 1]) {
//            int temp = arr[index];
//            arr[index] = arr[index - 1];
//            arr[index - 1] = temp;
//            index--;
//        }
//    }
//
//    private static double calculateMedian(int[] sorted, int size) {
//        int mid = size / 2;
//        float result;
//
//        if (size != 1 && size % 2 == 0) {
//            result = (float)(sorted[mid - 1] + sorted[mid]) / 2;
//        } else {
//            result = sorted[mid];
//        }
//
//        return result;
//    }


}

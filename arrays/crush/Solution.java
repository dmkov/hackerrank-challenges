package arrays.crush;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 Arrays: Array Manipulation
 https://www.hackerrank.com/challenges/crush/problem

 Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.

 For example, the length of your array of zeros n=10. Your list of queries is as follows:

 a b k
 1 5 3
 4 8 7
 6 9 1
 Add the values of k between the indices a and b inclusive:

 index->	 1,2,3,4  5  6 7 8 9 10
            [0,0,0,0, 0, 0,0,0,0, 0]
            [3,3,3,3, 3, 0,0,0,0, 0]
            [3,3,3,10,10,7,7,7,0, 0]
            [3,3,3,10,10,8,8,8,1, 0]
 The largest value is 10 after all operations are performed.

 Function Description
 Complete the function arrayManipulation in the editor below. It must return an integer, the maximum value in the resulting array.

 arrayManipulation has the following parameters:
 n - the number of elements in your array
 queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.

 Input Format
 The first line contains two space-separated integers n and m, the size of the array and the number of operations.
 Each of the next m lines contains three space-separated integers a, b and k, the left index, right index and summand.

 Output Format
 Return the integer maximum value in the finished array.

 Sample Input
 5 3
 1 2 100
 2 5 100
 3 4 100

 Sample Output
 200

 Explanation
 After the first update list will be 100 100 0 0 0.
 After the second update list will be 100 200 100 100 100.
 After the third update list will be 100 200 200 200 100.
 The required answer will be 200.
 */

public class Solution {
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        int[] spikes = new int[n];

        for (int i = 0; i < n; i++) {
            spikes[i] = 0;
        }

        for (int[] query: queries) {
            spikes[query[0] - 1] += query[2];
            if (query[1] < n) {
                spikes[query[1]] -= query[2];
            }
        }

        long max = 0L;
        long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += spikes[i];
            if (sum > max) {
                max = sum;
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);

        System.out.println(result);

        scanner.close();
    }

    // Answers:
    // https://www.hackerrank.com/challenges/crush/forum/comments/387537?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
    // https://www.hackerrank.com/challenges/crush/forum/comments/98816?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
}

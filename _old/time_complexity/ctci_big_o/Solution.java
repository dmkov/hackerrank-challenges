package time_complexity.ctci_big_o;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 Time Complexity: Primality
 https://www.hackerrank.com/challenges/ctci-big-o/problem

 A prime is a natural number greater than 1 that has no positive divisors other than 1 and itself. Given p integers,
 determine the primality of each integer and print whether it is Prime or Not prime on a new line.

 Note: If possible, try to come up with an O(sqrt(n)) primality algorithm, or see what sort of optimizations
 you can come up with for an O(n) algorithm. Be sure to check out the Editorial after submitting your code!

 Sample Input:
 3
 12
 5
 7

 Sample Output:
 Not prime
 Prime
 Prime

 Solution:
 */

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();

            if (checkIfNumberIsPrime(n)) {
                System.out.println("Prime");
            } else {
                System.out.println("Not prime");
            }
        }
    }

    private static boolean checkIfNumberIsPrime(int n) {
        if (n == 1) {
            return false;
        }
        int sqrt = (int)Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}


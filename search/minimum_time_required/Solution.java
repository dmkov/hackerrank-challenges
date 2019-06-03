package search.minimum_time_required;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 Minimum Time Required
 https://www.hackerrank.com/challenges/minimum-time-required/problem

 You are planning production for an order. You have a number of machines that each have a fixed number of days to produce an item. Given that all the machines operate simultaneously, determine the minimum number of days to produce the required order.

 For example, you have to produce goal = 10 items. You have three machines that take machines = [2, 3, 2] days to produce an item. The following is a schedule of items produced:

 Day Production  Count
 2   2               2
 3   1               3
 4   2               5
 6   3               8
 8   2              10

 It takes 8 days to produce 10 items using these machines.

 Function Description
 Complete the minimumTime function in the editor below. It should return an integer representing the minimum number of days required to complete the order.

 minimumTime has the following parameter(s):
 machines: an array of integers representing days to produce one item per machine
 goal: an integer, the number of items required to complete the order

 Input Format

 The first line consist of two integers n and goal, the size of machines and the target production.
 The next line contains n space-separated integers, machines[i].

 Output Format
 Return the minimum time required to produce goal items considering all machines work simultaneously.

 Sample Input 0
 2 5
 2 3

 Sample Output 0
 6

 ---------

 1. Complexity
    1.1 Time Complexity is O(m + m*logn) - where n is difference between min and max number of days in machines,
                                            m is number of machines in the array
    1.2 Space Complexity is O(1)
 2. Approach
    2.1 This solution is based on binary search and calculating number of items for every selected day in the search.
    2.2 Implementation
        2.2.1 Find min and max machines from the list.
        2.2.2 Calculate left and right possible day limits based on min and max machines.
        2.2.3 Do a binary search shifting left and right bounds comparing result with a method to calculate actual
            number of items based on days number
 */

public class Solution {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
        long minMachine = Long.MAX_VALUE;
        long maxMachine = 0;
        for (long machine: machines) {
            if (machine > maxMachine) {
                maxMachine = machine;
            }
            if (machine < minMachine) {
                minMachine = machine;
            }
        }

        long minDays = (long) Math.floor(goal * minMachine / machines.length);
        long maxDays = (long) Math.ceil(goal * maxMachine / machines.length);
        while (minDays <= maxDays) {
            long mid = minDays + (maxDays - minDays) / 2;
            long items = getProducedItems(mid, machines);
            if (items < goal) {
                minDays = mid + 1;
            } else {
                maxDays = mid - 1;
            }
        }

        return minDays;
    }

    private static long getProducedItems(long mid, long[] machines) {
        long result = 0;
        for (long machine: machines) {
            result += mid / machine;
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);
        System.out.println(ans);

        scanner.close();
    }
}

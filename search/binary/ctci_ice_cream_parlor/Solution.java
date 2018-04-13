package search.binary.ctci_ice_cream_parlor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 Hash Tables: Ice Cream Parlor
 https://www.hackerrank.com/challenges/ctci-ice-cream-parlor/problem

 Each time Sunny and Johnny take a trip to the Ice Cream Parlor, they pool together money dollars for ice cream.
 On any given day, the parlor offers a line of n flavors. Each flavor, i, is numbered sequentially with a unique ID
 number from 1 to n and has a cost, cost[i], associated with it.

 Given the value of money and the cost of each flavor for t trips to the Ice Cream Parlor, help Sunny and Johnny
 choose two distinct flavors such that they spend their entire pool of money during each visit.
 For each trip to the parlor, print the ID numbers for the two types of ice cream that Sunny and Johnny purchase
 as two space-separated integers on a new line. You must print the smaller ID first and the larger ID second.

 Note: Two ice creams having unique IDs i and j may have the same cost (i.e., cost[i] == cost[j]).

 Input Format:
 The first line contains an integer, t, denoting the number of trips to the ice cream parlor.

 The 3t subsequent lines describe all of Sunny and Johnny's trips to the parlor; each trip is described as follows:
 - The first line contains money.
 - The second line contains n.
 - The third line contains n space-separated integers denoting the cost of each respective flavor. The i-th integer
 corresponds to the cost, cost[i], for the ice cream with ID number i (where 1 <= i <= i).

 Output Format:
 Print two space-separated integers denoting the respective ID numbers for the two distinct flavors they choose
 to purchase, where the smaller ID is printed first and the larger ID is printed second. Recall that each ice cream
 flavor has a unique ID number in the inclusive range from 1 to flavors.

 Questions: 1) Money for both or per person? - both
 2) Can both guys have same flavor in their sets? - Yes, it is only one set of two flavors


 Sample Input 0:
 2
 4
 5
 1 4 5 3 2
 4
 4
 2 2 4 3

 Sample Output 0:
 1 4
 1 2

 Editorial solution: https://www.youtube.com/watch?v=Ifwf3DBN1sc ,
 but can be solved  with https://leetcode.com/articles/two-sum/ (but with hashtable of list of items with this same value)

 Note: Min should go first, max should be second.
 */

public class Solution {

    static class Flavor {
        int index;
        int price;

        public Flavor(int index, int price) {
            this.index = index;
            this.price = price;
        }
    }

    static void solve(int[] arr, int money) {
        if (arr.length < 2 || money <= 0) {
            return;
        }

        ArrayList<Flavor> flavors = new ArrayList<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            flavors.add(new Flavor(i + 1, arr[i]));
        }

        Collections.sort(flavors, Comparator.comparingInt(o -> o.price));

        for (int i = 0; i < flavors.size() - 1; i++) {
            int complement = money - flavors.get(i).price;
            int secondIndex = findSecondFlavor(flavors, complement,i+1, flavors.size() - 1);

            if (secondIndex != 0) {
                printResult(flavors, i, secondIndex);
                break;
            }
        }
    }

    private static int findSecondFlavor(ArrayList<Flavor> flavors, int complement, int start, int end) {
        if (start > end) {
            return 0;
        }

        int mid = start + (end - start)/2;
        if (flavors.get(mid).price == complement) {
            return mid;
        } else if (flavors.get(mid).price < complement) {
            return findSecondFlavor(flavors, complement,mid + 1, end);
        } else if (flavors.get(mid).price > complement) {
            return findSecondFlavor(flavors, complement, start, mid - 1);
        }

        return 0;
    }

    private static void printResult(ArrayList<Flavor> flavors, int i, int secondIndex) {
        int first = flavors.get(i).index;
        int second = flavors.get(secondIndex).index;

        System.out.printf("%d %d%n", Math.min(first, second), Math.max(first, second));
    }


//    Simple solution O(n^2). Did not work because of time limits.
//    static void solve(int[] arr, int money) {
//        if (arr.length < 2 || money <= 0) {
//            return;
//        }
//
//        boolean isFlavorFound = false;
//        int secondFlavor = 0;
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            int firstFlavor = i;
//            for (int j = i + 1; j < arr.length; j++) {
//                if (arr[firstFlavor] + arr[j] == money) {
//                    secondFlavor = j;
//                    isFlavorFound = true;
//                    break;
//                }
//            }
//            if (isFlavorFound) {
//                printResult(firstFlavor, secondFlavor);
//                break;
//            }
//        }
//    }
//
//    private static void printResult(int firstFlavor, int secondFlavor) {
//        if (secondFlavor < firstFlavor) {
//            int temp = firstFlavor;
//            firstFlavor = secondFlavor;
//            secondFlavor = temp;
//        }
//
//        System.out.printf("%d %d", firstFlavor + 1, secondFlavor + 1);
//    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int money = in.nextInt();
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            solve(arr, money);
        }
        in.close();
    }
}

package linked_lists.ctci_linked_list_cycle;

import java.util.LinkedList;

/**
 Linked Lists: Detect a Cycle
 https://www.hackerrank.com/challenges/ctci-linked-list-cycle/problem

 A linked list is said to contain a cycle if any node is visited more than once while traversing the list.

 Complete the function provided in the editor below. It has one parameter: a pointer to a Node object named head that
 points to the head of a linked list. Your function must return a boolean denoting whether or not there is a cycle
 in the list. If there is a cycle, return true; otherwise, return false.

 Input Format:
 Our hidden code checker passes the appropriate argument to your function.
 You are not responsible for reading any input from stdin.

 Output Format:
 If the list contains a cycle, your function must return true.
 If the list does not contain a cycle, it must return false.The binary integer corresponding to the boolean
 value returned by your function is printed to stdout by our hidden code checker.

 Solution: https://www.hackerrank.com/challenges/ctci-ransom-note/editorial
 */

public class Solution {

    //Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.
    class Node {
        int data;
        Node next;
    }

    // My solution
    boolean hasCycle(Node head) {
        if (head == null) {
            return false;
        }

        LinkedList<Node> ownBucket = new LinkedList<>();
        ownBucket.add(head);

        while (head.next != null) {
            for (Node stored: ownBucket) {
                if (head.next == stored) {
                    return true;
                }
            }
            ownBucket.add(head.next);
            head = head.next;
        }

        return false;
    }

//    Editorial solution
//    boolean hasCycle(Node head) {
//        if (head == null) {
//            return false;
//        }
//
//        Node slow = head;
//        Node fast = head.next;
//
//        while (slow.next != null && fast.next != null) {
//            if (slow == fast) {
//                return true;
//            }
//
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//
//        return false;
//    }

}

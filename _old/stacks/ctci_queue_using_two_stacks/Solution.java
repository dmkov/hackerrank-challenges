package stacks.ctci_queue_using_two_stacks;

import java.util.Scanner;
import java.util.Stack;

/**
 Queues: A Tale of Two Stacks
 https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks/problem

 A queue is an abstract data type that maintains the order in which elements were added to it, allowing the oldest
 elements to be removed from the front and new elements to be added to the rear. This is called
 a First-In-First-Out (FIFO) data structure because the first element added to the queue
 (i.e., the one that has been waiting the longest) is always the first one to be removed.

 A basic queue has the following operations:

 - Enqueue: add a new element to the end of the queue.
 - Dequeue: remove the element from the front of the queue and return it.

 In this challenge, you must first implement a queue using two stacks. Then process q queries, where each query is
 one of the following 3 types:
 1 x: Enqueue element  into the end of the queue.
 2: Dequeue the element at the front of the queue.
 3: Print the element at the front of the queue.

 Input Format:
 The first line contains a single integer, q, denoting the number of queries.
 Each line i of the q subsequent lines contains a single query in the form described in the problem statement above.
 All three queries start with an integer denoting the query type, but only query 1 is followed by an additional
 space-separated value, x, denoting the value to be enqueued.

 Output Format:
 For each query of type 3, print the value of the element at the front of the queue on a new line.

 Sample Input:
 10
 1 42
 2
 1 14
 3
 1 28
 3
 1 60
 1 78
 2
 2

 Sample Output:
 14
 14

 Solution: https://www.youtube.com/watch?v=7ArHz8jPglw
 */

public class Solution {

    public static class MyQueue<T> {
        Stack<T> stackNewestOnTop = new Stack<T>();
        Stack<T> stackOldestOnTop = new Stack<T>();

        public void enqueue(T value) { // Push onto newest stack
            stackNewestOnTop.push(value);
        }

        public T peek() {
            checkIfOldestOnTopShouldBeRepopulated();
            return stackOldestOnTop.peek();
        }

        public T dequeue() {
            checkIfOldestOnTopShouldBeRepopulated();
            return stackOldestOnTop.pop();
        }

        private void checkIfOldestOnTopShouldBeRepopulated() {
            if (!stackOldestOnTop.isEmpty() || stackNewestOnTop.isEmpty()) {
                return;
            }

            while (!stackNewestOnTop.empty()) {
                stackOldestOnTop.push(stackNewestOnTop.pop());
            }
        }
    }


    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}

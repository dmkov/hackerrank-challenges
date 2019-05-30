package trees.swap_nodes_algo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 Swap Nodes [Algo]
 https://www.hackerrank.com/challenges/swap-nodes-algo/problem

 A binary tree is a tree which is characterized by one of the following properties:
 - It can be empty (null).
 - It contains a root node only.
 - It contains a root node with a left subtree, a right subtree, or both. These subtrees are also binary trees.

 In-order traversal is performed as
 - Traverse the left subtree.
 - Visit root.
 - Traverse the right subtree.

 For this in-order traversal, start from the left child of the root node and keep exploring the left subtree until you reach a leaf. When you reach a leaf, back up to its parent, check for a right child and visit it if there is one. If there is not a child, you've explored its left and right subtrees fully. If there is a right child, traverse its left subtree then its right in the same manner. Keep doing this until you have traversed the entire tree. You will only store the values of a node as you visit when one of the following is true:
 - it is the first node visited, the first time visited
 - it is a leaf, should only be visited once
 - all of its subtrees have been explored, should only be visited once while this is true
 - it is the root of the tree, the first time visited

 Swapping: Swapping subtrees of a node means that if initially node has left subtree L and right subtree R, then after swapping, the left subtree will be R and the right subtree, L.

 For example, in the following tree, we swap children of node 1.

 Depth
   1               1            [1]
  / \             / \
 2   3     ->    3   2          [2]
 \   \           \   \
 4   5           5   4          [3]
 In-order traversal of left tree is 2 4 1 3 5 and of right tree is 3 5 1 2 4.

 Swap operation:
 We define depth of a node as follows:
 - The root node is at depth 1.
 - If the depth of the parent node is d, then the depth of current node will be d+1.
 - Given a tree and an integer, k, in one operation, we need to swap the subtrees of all the nodes at each depth h, where h ∈ [k, 2k, 3k,...]. In other words, if h is a multiple of k, swap the left and right subtrees of that level.

 You are given a tree of n nodes where nodes are indexed from [1..n] and it is rooted at 1. You have to perform t swap operations on it, and after each swap operation print the in-order traversal of the current state of the tree.

 Function Description
 Complete the swapNodes function in the editor below. It should return a two-dimensional array where each element is an array of integers representing the node indices of an in-order traversal after a swap operation.
 swapNodes has the following parameter(s):
 - indexes: an array of integers representing index values of each node[i], beginning with node[1], the first element, as the root.
 - queries: an array of integers, each representing a k value.

 Input Format
 The first line contains n, number of nodes in the tree.
 Each of the next n lines contains two integers, a b, where a is the index of left child, and b is the index of right child of ith node.

 Note: -1 is used to represent a null node.

 The next line contains an integer, t, the size of queries.
 Each of the next t lines contains an integer queries[i], each being a value k.

 Output Format
 For each k, perform the swap operation and store the indices of your in-order traversal to your result array. After all swap operations have been performed, return your result array for printing.
 */

public class Solution {

    static class Node {
        Node left;
        Node right;
        int value, depth;

        public Node(int value, int depth) {
            this.value = value;
            this.depth = depth;
        }

        public int[] printInOrder() {
            int[] arr = null;
            if (left != null) {
                arr = left.printInOrder();
            }
            arr = mergeArrays(arr, new int[]{value});
            if (right != null) {
                arr = mergeArrays(arr, right.printInOrder());
            }
            return arr;
        }

        private int[] mergeArrays(int[] first, int[] second) {
            if (first == null) {
                return second;
            }
            if (second == null) {
                return first;
            }
            int[] result = Arrays.copyOf(first, first.length + second.length);
            System.arraycopy(second, 0, result, first.length, second.length);

            return result;
        }
    }

    /*
     * Complete the swapNodes function below.
     */
    static int[][] swapNodes(int[][] indexes, int[] queries) {
        List<Node> nodes = new ArrayList<>();
        int[][] result = new int[queries.length][];

        Node root = new Node(1, 1);
        nodes.add(root);

        for (int i = 0; i < indexes.length; i++) {
            int[] index = indexes[i];
            Node parent = nodes.get(i);
            if (parent != null) {
                if (index[0] != -1) {
                    Node left = new Node(index[0], parent.depth + 1);
                    nodes.add(left);
                    parent.left = left;
                }
                if (index[1] != -1) {
                    Node right = new Node(index[1], parent.depth + 1);
                    nodes.add(right);
                    parent.right = right;
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int k = queries[i];
            for (Node node: nodes) {
                if (node.depth % k == 0) {
                    Node temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                }
            }
            result[i] = root.printInOrder();
        }


        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(scanner.nextLine().trim());

        int[][] indexes = new int[n][2];

        for (int indexesRowItr = 0; indexesRowItr < n; indexesRowItr++) {
            String[] indexesRowItems = scanner.nextLine().split(" ");

            for (int indexesColumnItr = 0; indexesColumnItr < 2; indexesColumnItr++) {
                int indexesItem = Integer.parseInt(indexesRowItems[indexesColumnItr].trim());
                indexes[indexesRowItr][indexesColumnItr] = indexesItem;
            }
        }

        int queriesCount = Integer.parseInt(scanner.nextLine().trim());

        int[] queries = new int[queriesCount];

        for (int queriesItr = 0; queriesItr < queriesCount; queriesItr++) {
            int queriesItem = Integer.parseInt(scanner.nextLine().trim());
            queries[queriesItr] = queriesItem;
        }

        int[][] result = swapNodes(indexes, queries);

        for (int resultRowItr = 0; resultRowItr < result.length; resultRowItr++) {
            for (int resultColumnItr = 0; resultColumnItr < result[resultRowItr].length; resultColumnItr++) {
                bufferedWriter.write(String.valueOf(result[resultRowItr][resultColumnItr]));

                if (resultColumnItr != result[resultRowItr].length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            if (resultRowItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}

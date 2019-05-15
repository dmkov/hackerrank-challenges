package trees.ctci_is_binary_search_tree;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 Trees: Is This a Binary Search Tree?
 https://www.hackerrank.com/challenges/ctci-is-binary-search-tree/problem

 For the purposes of this challenge, we define a binary search tree to be a binary tree with the following
 ordering properties:

 - The data value of every node in a node's left subtree is less than the data value of that node.
 - The data value of every node in a node's right subtree is greater than the data value of that node.

 Given the root node of a binary tree, can you determine if it's also a binary search tree?

 Complete the function in your editor below, which has 1 parameter: a pointer to the root of a binary tree.
 It must return a boolean denoting whether or not the binary tree is a binary search tree.
 You may have to write one or more helper functions to complete this challenge.

 Note: We do not consider a binary tree to be a binary search tree if it contains duplicate values.

 Sample Input:
 You are not responsible for reading any input from stdin. Hidden code stubs will assemble a binary tree and pass
 its root node to your function as an argument.

 Sample Output:
 You are not responsible for printing any output to stdout. Your function must return true if the tree is a binary
 search tree; otherwise, it must return false. Hidden code stubs will print this result as a Yes or No answer
 on a new line.

 Solution: https://www.youtube.com/watch?v=i_Q0v_Ct5lY
 */

public class Solution {

    /* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge.
    Hint: you may want to write one or more helper functions. */

    // The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }

    boolean checkBST(Node root) {
        if (root.left != null && root.right != null) {
            if ((root.left.data < root.data && getMaxNode(root.left) < root.data)
                    && (root.right.data > root.data && getMinNode(root.right) > root.data)) {
                return checkBST(root.left) && checkBST(root.right);
            } else {
                return false;
            }
        } else if ((root.left == null && root.right != null) || (root.left != null && root.right == null)) {
            return false;
        }

        return true;
    }

    private int getMaxNode(Node root) {
        if (root.left != null && root.right != null) {
            return Math.max(getMaxNode(root.left), getMaxNode(root.right));
        } else {
            return root.data;
        }
    }

    private int getMinNode(Node root) {
        if (root.left != null && root.right != null) {
            return Math.min(getMinNode(root.left), getMinNode(root.right));
        } else {
            return root.data;
        }
    }

//    Better (faster) solution
//    boolean checkBST(Node root, int minValue, int maxValue) {
//        if (root == null) {
//            return true;
//        }
//
//        if (root.data < minValue || root.data > maxValue) {
//            return false;
//        }
//
//        return (    checkBST(root.left, minValue, root.data - 1)
//                &&  checkBST(root.right, root.data + 1, maxValue)
//        );
//    }
//
//    boolean checkBST(Node root) {
//        return checkBST(root, Integer.MIN, Integer.MAX);
//    }
}

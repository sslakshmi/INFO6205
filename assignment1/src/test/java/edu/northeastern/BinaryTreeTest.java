package edu.northeastern;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class BinaryTreeTest {
    private Node<Integer> initTree() {
        Node<Integer> root = new Node<>(1);

        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(3);

        root.left.left = new Node<Integer>(4);
        root.left.right = new Node<Integer>(5);
        root.right.left = new Node<Integer>(6);
        root.right.right = new Node<Integer>(7);

        root.left.left.left = new Node<Integer>(8);
        root.left.right.left = new Node<Integer>(9);
        root.right.left.right = new Node<Integer>(10);
        root.right.right.right = new Node<Integer>(11);

        return root;
    }

    public Node<Integer> getMinDepthNode() {
        Node<Integer> root = new Node<>(2);

        root.right = new Node<Integer>(3);
        root.right.right = new Node<Integer>(4);
        root.right.right.right = new Node<Integer>(5);
        root.right.right.right.right = new Node<Integer>(6);

        return root;
    }

    @Test
    void minDepthOfBinaryTreeTest() {
        Node<Integer> root = getMinDepthNode();
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(root);
        System.out.println(binaryTree.minDepthOfBinaryTree(root));
    }

    public Node<Integer> getBalancedTree() {
        Node<Integer> root = new Node<>(3);

        root.left = new Node<Integer>(9);
        root.right = new Node<Integer>(20);

        root.right.left = new Node<Integer>(15);
        root.right.right = new Node<Integer>(7);

        return root;
    }

    @Test
    void isBalancedTest() {
        Node<Integer> root = getBalancedTree();
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(root);
        System.out.println(binaryTree.isBalanced(root));
    }

    @Test
    void sumOfAllLeftLeavesTest() {
        Node<Integer> root = initTree();
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(root);
        System.out.println(binaryTree.sumOfAllLeftLeaves(root));
    }

    public Node<Integer> getLeavesTree() {
        Node<Integer> root = new Node<>(1);

        root.left = new Node<Integer>(2);
        root.right = new Node<Integer>(3);

        root.left.left = new Node<Integer>(4);
        root.left.right = new Node<Integer>(5);

        return root;
    }

    @Test
    void findLeavesTest() {
        Node<Integer> root = getLeavesTree();
        BinaryTree<Integer> binaryTree = new BinaryTree<Integer>(root);
        List<List<Integer>> leafList = binaryTree.findLeaves(root);
        leafList.forEach(i -> System.out.println(i));
    }
}
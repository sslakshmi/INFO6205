package edu.northeastern;


import java.util.*;

public class BinaryTree<T> {
    Node<T> root;

    public BinaryTree(Node<T> root) {
        this.root = root;
    }

    /**
     * Given a binary tree, find its minimum depth.
     * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
     * Note: A leaf is a node with no children.
     * @param node
     * @return
     */
    public int minDepthOfBinaryTree(Node<T> node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        } else if (node.left == null) {
            return 1 + minDepthOfBinaryTree(node.right);
        } else if (node.right == null) {
            return 1 + minDepthOfBinaryTree(node.left);
        } else {
            return 1 + Math.min(minDepthOfBinaryTree(node.left), minDepthOfBinaryTree(node.right));
        }
    }

    /**
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as:
     * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
     * @param root
     * @return
     */
    public boolean isBalanced(Node<T> root) {
        if (root == null) {
            return true;
        } else {
            NodeStatus nodeStatus = heightBalanced(root);
            return nodeStatus.isBalanced;
        }
    }

    private NodeStatus heightBalanced(Node<T> node) {
        if (node == null) {
            return new NodeStatus(true, 0);
        } else {
            NodeStatus lStatus = heightBalanced(node.left);
            if (lStatus.isBalanced) {
                NodeStatus rStatus = heightBalanced(node.right);
                if (rStatus.isBalanced) {
                    return new NodeStatus(
                            Math.abs(lStatus.height - rStatus.height) <= 1,
                            1 + Math.max(lStatus.height, rStatus.height)
                    );
                }
            }
            return new NodeStatus(false, 0);
        }
    }

    /**
     * Find the sum of all left leaves in a given binary tree.
     * @param root
     * @return
     */
    public int sumOfAllLeftLeaves(Node<T> root) {
        return sumOfAllLeftLeaves(root, false);
    }

    private int sumOfAllLeftLeaves(Node<T> node, boolean isLeft) {
        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null && isLeft) {
            return (int) node.data;
        } else {
            return sumOfAllLeftLeaves(node.left, true) + sumOfAllLeftLeaves(node.right, false);
        }
    }


    /**
     * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
     * @param root
     * @return
     */
    public List<List<T>> findLeaves(Node<T> root) {
        List<List<T>> result = new ArrayList<>();
        List<T> leafList = new ArrayList<>();
        Set<Node<T>> exploredLeaves = new HashSet<>();
        while (!exploredLeaves.contains(root)) {
            leafList = findLeaves(root, exploredLeaves);
            result.add(leafList);
        }
        return result;
    }

    private List<T> findLeaves(Node<T> node, Set<Node<T>> exploredLeaves) {
        List<T> leafList = new ArrayList<>();
        if (node == null || exploredLeaves.contains(node)) {
            return leafList;
        } else if ((node.left == null && node.right == null) ||
                (exploredLeaves.contains(node.left) && exploredLeaves.contains(node.right)) ||
                (exploredLeaves.contains(node.left) && node.right == null) ||
                (node.left == null && exploredLeaves.contains(node.right))) {
            exploredLeaves.add(node);
            return Arrays.asList(node.data);
        } else {
            leafList.addAll(findLeaves(node.left, exploredLeaves));
            leafList.addAll(findLeaves(node.right, exploredLeaves));
        }
        return leafList;
    }
}

class NodeStatus {
    boolean isBalanced;
    int height;

    public NodeStatus(boolean isBalanced, int height) {
        this.isBalanced = isBalanced;
        this.height = height;
    }
}




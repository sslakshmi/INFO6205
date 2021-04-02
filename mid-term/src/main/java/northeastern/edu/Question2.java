package northeastern.edu;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Question2 {

    //Time complexity - O(n)
    //Space complexity - O(n) - recursion call stack
    public static void main(String[] args) {
        // Given Tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);
        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);
        Question2 q2 = new Question2();
        q2.printPerimeter(root);  // [1,3,7,14,13,11,10,9,8,4,2]
        System.out.println("\n-------------");


        // Root with 1 left and 1 right node
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        q2.printPerimeter(root1);
        System.out.println("\n-------------");


        // Just root
        TreeNode root2 = new TreeNode(1);
        q2.printPerimeter(root2);
        System.out.println("\n-------------");


        //Left only tree
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(4);
        root3.left.right = new TreeNode(5);
        q2.printPerimeter(root3);
        System.out.println("\n-------------");

        //Right only tree
        // Given Tree
        TreeNode root4 = new TreeNode(1);
        root4.right = new TreeNode(3);
        root4.right.left = new TreeNode(6);
        root4.right.right = new TreeNode(7);
        q2.printPerimeter(root4);
        System.out.println("\n-------------");

    }

    private void printRight(TreeNode node, boolean first) {
        if (node == null) {
            return;
        }
        if (node.right == null && node.left == null) {
            return;
        }
        if (node.right != null) {
            if (!first) {
                System.out.print(",");
            }
            System.out.print(node.val);

            printRight(node.right, false);
        }
        if (node.right == null && node.left != null) {
            if (!first) {
                System.out.print(",");
            }
            System.out.print(node.val);
            if (!first) {
                printRight(node.left, false);
            }
        }
    }

    private void printLeaves(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            System.out.print("," + node.val);
        } else {
            printLeaves(node.right);
            printLeaves(node.left);
        }
    }

    private void printLeft(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        if (node.left != null) {
            printLeft(node.left);
            System.out.print("," + node.val);
        }
        if (node.left == null && node.right != null) {
            printLeft(node.right);
            System.out.print("," + node.val);
        }
    }

    public void printPerimeter(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            System.out.print(root.val);
            return;
        }
        printRight(root, true);
        printLeaves(root);
        printLeft(root.left);
    }

}

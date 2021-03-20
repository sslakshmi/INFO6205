package edu.northeastern;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class Question1 {
    public static void main(String[] args) {
        TreeNode subTreeRoot = new TreeNode(4);
        subTreeRoot.left = new TreeNode(1);
        subTreeRoot.right = new TreeNode(2);

        TreeNode treeRoot = new TreeNode(3);
        treeRoot.left = new TreeNode(4);
        treeRoot.right = new TreeNode(5);

        treeRoot.left.left = new TreeNode(1);
        treeRoot.left.right = new TreeNode(2);

        Question1 question1 = new Question1();
        System.out.println(question1.isSubtree(treeRoot, subTreeRoot));
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) return false;
        if (s.val == t.val)
            if (isSubTreeFind(s, t)) {
                return true;
            } else {
                return isSubtree(s.left, t) || isSubtree(s.right, t);
            }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubTreeFind(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null || s.val != t.val)
            return false;
        return isSubTreeFind(s.left, t.left) && isSubTreeFind(s.right, t.right);
    }
}

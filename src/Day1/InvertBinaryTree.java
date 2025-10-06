package Day1;

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root){
        invert(root);
        return root;
    }

    public void invert(TreeNode root){
        if (root == null)
            return;

        TreeNode temp = root.left;
        temp.left = root.right;
        root.right = temp;

        invert(root.left);
        invert(root.right);
    }
}

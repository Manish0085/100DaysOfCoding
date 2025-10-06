package Day1;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {

    public int Iterative(TreeNode root){
        int height = 0;
        if(root == null)
            return height;

        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()){
            int n = que.size();
            for (int i = 0; i < n; i++) {
                TreeNode temp = que.remove();
                if(temp.left != null)
                    que.add(temp.left);
                if (temp.right != null)
                    que.add(temp.right);
            }
            height++;
        }
        return height;
    }

    public int recursive(TreeNode root){
        if(root == null)
            return 0;

        int left = recursive(root.left);
        int right = recursive(root.right);
        return 1+Math.max(left, right);
    }
}

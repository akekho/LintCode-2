/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class LintCode_66 {
    /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        traverse(root, result);
        return result;
    }
    
    private void traverse(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right, result);
    }
    
}

//divide and conquer
public class LintCode_66_2{
        /**
     * @param root: The root of binary tree.
     * @return: Preorder in ArrayList which contains node values.
     */
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        //divide & conquer
        ArrayList<Integer> left = preorderTraversal(root.left);
        ArrayList<Integer> right = preorderTraversal(root.right);
        
        //merge
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }
}
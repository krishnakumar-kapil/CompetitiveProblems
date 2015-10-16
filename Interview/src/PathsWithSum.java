/**
 * Created by kapilkrishnakumar on 10/16/15.
 */
public class PathsWithSum {


    public static int pathsWithSum(TreeNode root, int reqSum){
        if(root == null) return 0;

        int pathLeft = pathsWithSum(root.left, reqSum);
        int pathRight = pathsWithSum(root.right, reqSum);
        int getFromNode = helper(root, reqSum);

        return getFromNode+ pathLeft + pathRight;
    }

    private  static int helper(TreeNode curr, int sum){
        if(curr == null)
            return 0;

        int nextSum = sum - curr.val;
        int totalWays = 0;
        if(nextSum == 0)
            totalWays++;

        return helper(curr.left, nextSum) + helper(curr.right, nextSum)+ totalWays;

    }


    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

    }
}

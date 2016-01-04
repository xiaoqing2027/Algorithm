import java.util.ArrayList;
import java.util.List;

/**
 * Created by maggie on 1/3/16.
 */
public class PathSumII {
    //Note: root - leaf: so if tree is [1,2], right child is null,
    //Given sum = 1, result [[1]] is not correct because it is only contains root, no child.

    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        //trivial case, root == null
        if(root == null){
            return result;
        }

        List<Integer> sub = new ArrayList<Integer>();
        // root doesn't have any children
        if(root.left == null && root.right == null && sum == root.val){
            sub.add(root.val);
            result.add(sub);
            return result;
        }
        dfs(root, sum, sub);
        return result;
    }
    public void dfs(TreeNode node, int sum, List<Integer> sub) {
        //add nodes' value
        if(node != null){
            sub.add(node.val);
            // System.out.print(">>>" + sub);
            // System.out.print(">>>" + node.val);

            //return until the node is leaf
            if(node.left == null && node.right == null){
                if(sum == node.val ){
                    result.add(sub);
                }
                return;
            }
            if(node.left != null){

                dfs(node.left, sum - node.val, new ArrayList<Integer>(sub));
                // sub.remove(sub.size()-1);
            }
            if(node.right != null){
                // sub.add(node.right.val);
                dfs(node.right, sum - node.val,new ArrayList<Integer>(sub));
                //sub.remove(sub.size()-1);
            }
        }
        return;

    }

}


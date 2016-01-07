import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by maggie on 1/3/16.
 */
public class SubSetWithoutDuplicate {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<Integer>());
        // trivial case
        if(nums == null || nums.length == 0){
            return result;
        }
        Arrays.sort(nums);
        //System.out.print(nums);
        dfs(result, nums, 0);
        return result;
    }
    public void dfs( List<List<Integer>> result, int[] nums, int e){
        if(e >= nums.length){
            return;
        }
        //double clone result, r is for outer layer list,
        List<List<Integer>> r = new ArrayList<List<Integer>>();
        for(int i = 0; i < result.size(); i++){
            // this new is for inner layer deep copy
            r.add(new ArrayList<Integer>(result.get(i)));
        }
        // operations for r, except adding new sub-result
        for(int i = 0; i < r.size(); i++){
            List<Integer> sub = r.get(i);
            sub.add(nums[e]);
            result.add(sub);
        }
        dfs(result,nums,e+1);
    }

    public static void main(String[] args){
        SubSetWithoutDuplicate t = new SubSetWithoutDuplicate();
        int[] nums = new int[]{1,2,3};
//        for(int i = 0; i < nums.length; i++){
//            System.out.print(" " + nums[i]);
//        }

        List<List<Integer>> l = t.subsets(nums);
        System.out.print("[");
        for(int i = 0; i < l.size(); i++){
            System.out.print("[");
            for(int j = 0; j < l.get(i).size(); j++){
                System.out.print( l.get(i).get(j)+",");
            }
            System.out.print("],");
        }
        System.out.print("]");

    }

}





/**
 * Created by maggie on 2/9/16.
 */
public class RemoveDuplicateElementFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0 || nums.length == 1){
            return nums.length;
        }

        int[] t = new int[nums.length];
        int j =0;
        t[j]= nums[0];
        for(int i = 1; i < nums.length;i++){
            if(t[j] != nums[i]){
                j++;
                t[j] = nums[i];
                nums[j] = t[j];
            }

        }
        System.out.print("remaining elements : [");
        for(int i =0; i <= j; i++){
            System.out.print(t[i] + ",");

        }
        System.out.println("]");

        System.out.print("remaining elements : [");
        for(int i =0; i < nums.length; i++){
            System.out.print(nums[i] + ",");

        }
        System.out.print("]");

        return j+1;
    }

    public static void main(String[] args){
        int[] t = {1,1,2};
        RemoveDuplicateElementFromSortedArray r = new RemoveDuplicateElementFromSortedArray();
        System.out.println(" length: " + r.removeDuplicates(t));

    }
}

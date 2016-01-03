/**
 * Created by miaodonghan on 12/28/15.
 */
public class CoinChange_DP {
    int nums = 0;
    public int coinChange(int[] coins, int amount) {
        //Base case
        if(coins == null || coins.length == 0 || amount < 0){
            return -1;
        }
        // trivial case
        if(amount == 0){
            return 0;
        }
        //memo array
        int[] nums = new int[amount+1];
        nums[0] = 0;
        for(int i = 1; i <= amount; i++){
            // in order of avoiding that nums[i + coins[j]] and nums[i] are both Max_value,
            // in this case, nums[i] + 1 will become negative value
            nums[i] =Integer.MAX_VALUE-1;
        }
        for(int i = 0; i <= amount; i++){
            for(int j = 0; j < coins.length; j++){
                if(amount >= coins[j] + i){
                    //memoing
                    nums[i+coins[j]] = Math.min(nums[i + coins[j]], nums[i] + 1);
                    //System.out.println(">>>>>>" + nums[amount]);
                }
            }
        }

        return (nums[amount] == Integer.MAX_VALUE-1) ?  -1 : nums[amount];

    }

    // If this problem is solved by greedy, result is unecessarily optimal.
    // such as: amount is 6, coins[1, 3, 4],
    // actually, the fewest number of coins is 2, {3,3}
    // however, the result will be 3 by greedy, {4,1,1}.
    // Therefore, this problem only can be solved computing all combination of coins
    // then choosing the optimal one.
}

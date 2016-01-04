import java.util.Arrays;

/**
 * Created by maggie on 12/23/15.
 */
public class CoinChange_Greedy {

     int nums = 0;

    public  int coinChange(int[]coins, int amount) {
        //Base case
        if(coins == null || coins.length == 0 || amount <= 0){
            return -1;
        }

        if(amount == 0){
            return 0;
        }

        Arrays.sort(coins);

        for(int i = 0; i < coins.length; i++){
            System.out.print(coins[i] + " ");
        }
        int ithElem = coins.length-1;


        if(subAmountChange(coins, amount, ithElem)){
            return nums;
        }else{
            return -1;
        }

    }

    public boolean subAmountChange(int[] coins, int amount, int ithElem){

        //trivial case
        if(amount == 0){
            //System.out.println("end:" + amount);
            return true;
        }

        if(amount < coins[0]){
            return false;
        }

        if(amount >= coins[ithElem]){

            if(subAmountChange(coins, amount - coins[ithElem],ithElem)){

                nums++;

            }else{
                return false;
            }

        }else{
            if(ithElem - 1 >= 0){
                System.out.println(">>>>" + ithElem);
                subAmountChange(coins, amount, ithElem -1);
            }
        }

        return true;
    }

    public static void main(String[] args){

//        int[] coins = new int[]{1,2, 5, 10,};
//        int amount = 27;

        int[] coins = new int[]{3, 4,1};
        int amount = 6;


        CoinChange_Greedy m = new CoinChange_Greedy();
        System.out.println("t>>>>>>>:" + m.coinChange(coins,amount));
    }
}

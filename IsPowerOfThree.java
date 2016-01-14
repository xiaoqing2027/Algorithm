/**
 * Created by maggie on 1/14/16.
 */
public class IsPowerOfThree {

    public boolean PowerOfThree_loop(int n){
        if(n <= 0){
            return false;
        }
        int i = 0;
        //loop method
        while(true){
            if(Math.pow(3,i) == n){
                return true;
            }
            if(Math.pow(3,i) > n){
                return false;
            }
            if(Math.pow(3,i) < n){
                i++;
            }
        }
    }

    //recursion method
    public boolean  PowerOfThree_recursion(int n){
        if(n <= 0){
            return false;
        }
        return PowerOfThree_recursion_helper(n,0);
    }
    public boolean PowerOfThree_recursion_helper(int n, int times){
        if(Math.pow(3,times) == n){
            return true;
        }
        if(Math.pow(3,times) > n){
            return false;
        }
        if(Math.pow(3,times) < n){
            times++;
        }
        return PowerOfThree_recursion_helper(n, times);
    }

    //math method : enumeration
    public boolean PowerOfThree_math(int n){
//        if(n == 1 || n == 3 || n == 9 || n == 27 || n == 81 || n == 243 || n == 729 ||
//                n == 2187 || n == 6561 || n == 19683 || n == 59049 || n == 177147 || n == 531441 ||
//                n == 1594323 || n == 4782969 || n == 14348907 || n == 43046721 || n == 129140163 ||
//                n == 387420489 || n == 1162261467){
//            return true;
//        }
//
//        return false;

        //or
        return (n == 1 || n == 3 || n == 9 || n == 27 || n == 81 || n == 243 || n == 729 ||
        n == 2187 || n == 6561 || n == 19683 || n == 59049 || n == 177147 || n == 531441 ||
                n == 1594323 || n == 4782969 || n == 14348907 || n == 43046721 || n == 129140163 ||
                n == 387420489 || n == 1162261467);
    }
    public static void main(String[] args){
        IsPowerOfThree t = new IsPowerOfThree();
        System.out.println("loop : " + t.PowerOfThree_loop(33));
        System.out.println("recursion: " + t.PowerOfThree_recursion(33));
        System.out.println("math: " + t.PowerOfThree_math(33));
    }
}

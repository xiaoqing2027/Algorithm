/**
 * Created by maggie on 12/23/15.
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        if(x/10 == 0){
            return true;
        }
        String s ="";
        s= s+ x;
        System.out.println(s);
        for(int i = 0, j = s.length()-1; i < j; i++,j--){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
        }

        return true;

    }

    public static void main(String[] args){
        Palindrome p = new Palindrome();
        System.out.println(p.isPalindrome(12321));
    }
}

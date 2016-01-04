/**
 * Created by maggie on 12/23/15.
 */
public class AddDigit {

    public int addDigits(int num) {
        if(num/10 == 0){
            return num;
        }

        return addDigits(getSumOfDigits(num));

}

    public int getSumOfDigits(int num){
        int sum = 0;
        while(num/10 != 0){
            sum = sum + num%10;
            num = (num-num%10)/10;
        }
        return sum + num%10;
    }

    public static void main(String[] args){
        AddDigit t = new AddDigit();
        System.out.println(t.addDigits(38));
    }
}

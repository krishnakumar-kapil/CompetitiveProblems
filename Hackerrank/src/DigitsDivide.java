/**
 * Created by kapilkrishnakumar on 10/14/15.
 */
import java.util.*;
public class DigitsDivide {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        for(int i = 0; i < t; i++){
            int val = sc.nextInt();
            int cur = val;
            int digit = 0;
            int count = 0;
            while(cur > 0){
                digit = cur % 10;
                if(digit != 0) count += val % digit == 0 ? 1 : 0;
                cur /= 10;
            }
            System.out.println(count);

        }
    }
}

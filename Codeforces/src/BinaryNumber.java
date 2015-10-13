/**
 * Created by kapilkrishnakumar on 10/7/15.
 * http://codeforces.com/problemset/problem/92/B
 */
import java.util.*;
public class BinaryNumber {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String bits = sc.next();

        int lastone = bits.lastIndexOf('1');
        int leng = bits.length() - 1;
        if(lastone != 0){
            int n = leng;
            int counter = 2;
            while(n >= 0){
                if(bits.charAt(n) == '0')
                    counter++;
                n--;
            }
            System.out.println(lastone + counter);
        } else
            System.out.println(leng);


    }
}

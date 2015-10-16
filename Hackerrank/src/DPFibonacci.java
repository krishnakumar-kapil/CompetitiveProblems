import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by kapilkrishnakumar on 10/14/15.
 */
public class DPFibonacci {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger a = new BigInteger(sc.next());
        BigInteger b = new BigInteger(sc.next());
        int n = sc.nextInt();
        BigInteger val =  (a.multiply(a)).add(b);;
        for(int i = 2; i <= n; i++){
            val = (a.multiply(a)).add(b);
//            System.out.println(val);
            b = a;
            a = val;
        }
        System.out.println(val);

    }
}

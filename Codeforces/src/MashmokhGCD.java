/**
 * Created by kapilkrishnakumar on 11/4/15.
 */
import java.util.*;
public class MashmokhGCD {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = 0;
        if ((m < n/2) || (m != 0 && n ==1)) {
            System.out.println(-1);
        } else if (m == n/2) {
            for (int i = 1; i <= n; i++) {
                System.out.println(i+1);
            }
        } else {
            a = (m - n/2 + 1);
            System.out.println(a);
            System.out.println(a*2);
            a = 2*a;
            for (int i = 1; i <= n-2; i++) {
                System.out.println(a+i+1);
            }
        }
    }
}

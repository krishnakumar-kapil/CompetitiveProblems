/**
 * Created by kapilkrishnakumar on 10/13/15.
 */
import java.util.*;
public class BigSum {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for(int i =0 ; i < n; i++){
            int val = sc.nextInt();
            sum += val;
        }
        System.out.println(sum);
    }
}

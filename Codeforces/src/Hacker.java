/**
 * Created by kapilkrishnakumar on 10/4/15.
 */
import java.util.*;
public class Hacker {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long m = sc.nextLong();

        long[] a = new long[n];
        long max = 0;
        for(int i = 0; i < m; i++){
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            long val = sc.nextLong();
            for(; start <= end && start < a.length; start++){
//                System.out.println(start);
                a[start] += val;
                if(a[start] > max)
                    max = a[start];
            }

        }
        System.out.println(max);
    }
}


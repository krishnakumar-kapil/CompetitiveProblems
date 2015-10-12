/**
 * Created by kapilkrishnakumar on 9/30/15.
 * http://codeforces.com/problemset/problem/448/D/
 */
import java.util.*;
public class MultTable {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long k = sc.nextLong();

        long low = 0;
        long high = n * m + 1;

//        int count = 0;

        while( 1 < (high - low)){
            long mid = low + (high - low )/2;
            long rows = n;
            long sum = 0;
            while(rows >= 1){
                long numbers = mid / rows;
                if( numbers > m){
                    numbers = m;
                }
                sum += numbers;
                rows --;
            }

            if( k > sum)
                low = mid;
            else
                high = mid;
        }
        System.out.println(high);

    }
}

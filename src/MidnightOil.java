/**
 * Created by kapilkrishnakumar on 9/30/15.
 */
//http://codeforces.com/problemset/problem/165/B/
import java.util.*;
public class MidnightOil {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int low = 0;
        int high = n;
        int mid = 0;
        while( low <= high){
            mid = low + (high - low) / 2;
            boolean check = check(n, mid, k);
            if(check && !check(n , mid - 1, k))
                break;
            if(check)
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println(mid);
    }

    public static boolean check(int n, int v , int k){
        int curr = v;
        int sum = 0;
        while(curr != 0){
            sum += curr;
            curr /= k;
        }
        return sum >= n;
    }
}

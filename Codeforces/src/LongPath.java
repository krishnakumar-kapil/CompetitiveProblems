/**
 * Created by kapilkrishnakumar on 10/21/15.
 */
import java.util.*;
public class LongPath {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int bound = (int)1e9 + 7;
        int n = sc.nextInt();

        int[] dp = new int[n + 1];
        for(int i = 1; i <= n; i++){
            dp[i] = ((((2*dp[i-1] - dp[sc.nextInt() -1]) + 2) % bound + bound) % bound);
        }
        System.out.println(dp[n]);
    }
}

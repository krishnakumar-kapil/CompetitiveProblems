/**
 * Created by kapilkrishnakumar on 10/12/15.
 *http://codeforces.com/problemset/problem/166/E
 */

import java.util.*;
public class Tetrahedron {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 3;
        dp[3] = 3;

        for(int i = 3; i < dp.length; i++){

        }

        System.out.println(dp[n]);

    }

}

/**
 * Created by kapilkrishnakumar on 10/12/15.
 *http://codeforces.com/problemset/problem/166/E
 */

import java.util.*;
public class Tetrahedron {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long endD = 1;
        long endOther = 0;
        long MOD = (long) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            long newEndD = endOther * 3 % MOD;
            long newEndOther = (endD + endOther * 2) % MOD;
            endD = newEndD;
            endOther = newEndOther;
        }
        System.out.println(endD);

    }

}

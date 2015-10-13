/**
 * Created by kapilkrishnakumar on 10/12/15.
 * http://codeforces.com/problemset/problem/189/A/
 */
import java.util.*;
public class CutRibbon {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int[] memo = new int[4001];
        memo[a] = 1;
        memo[b] = 1;
        memo[c] = 1;

        for(int i = 1; i <= n; i++){
            if(i >= a && memo[i-a] != 0){
                memo[i] = Math.max(memo[i], (memo[i-a] + 1));
            }
            if(i >= b && memo[i-b] != 0){
                memo[i] = Math.max(memo[i], (memo[i-b] + 1));
            }
            if(i >= c && memo[i-c] != 0){
                memo[i] = Math.max(memo[i], (memo[i-c] + 1));
            }
        }

        System.out.println(memo[n]);
    }

}

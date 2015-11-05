/**
 * Created by kapilkrishnakumar on 11/4/15.
 * http://codeforces.com/problemset/problem/573/A
 */
import java.util.*;
public class BearPoker {

    public static void  main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] lowest = new int[n];
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            while(val % 2 == 0 || val % 3 == 0){
                if(val % 2 == 0){
                    val /= 2;
                }
                if(val % 3 == 0){
                    val /= 3;
                }
            }
            lowest[i] = val;

        }


        int ch = lowest[0];
        boolean t = true;
        for(int j = 0; j < n; j++){
            if(lowest[j] != ch){
                t = false;
                break;
            }
        }
        String res = t ? "Yes" : "No";
        System.out.println(res);
    }
}

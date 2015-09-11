/**
 * Created by kapilkrishnakumar on 8/28/15.
 */

import java.util.*;

public class Codeforces1 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int numCol = sc.nextInt();
        ArrayList<Integer> ts = new ArrayList<Integer>();
        for(int i = 0; i < numCol; i++){
            int num = sc.nextInt();
            ts.add(num);
        }
        Collections.sort(ts);
        for(int n: ts){
            System.out.print(n + " ");
        }
    }
}

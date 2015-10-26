/**
 * Created by kapilkrishnakumar on 10/26/15.
 */
import java.util.*;
public class MinCoins {

    public static void main(String[] args){

    }

    public static int minCoins(int[] denom, int sum){
        //every val of denom is > 0

        int[] map = new int[sum + 1];
        Arrays.fill(map, Integer.MAX_VALUE);
//        at base cases fill in ones
        // beyond that a point will have the min amount + 1?


        //go till the end of the loop
        //at every point go till i + sum and fill??
        for(int i = 1; i <= sum; i++){

            int min = Integer.MAX_VALUE;
            for(int val: denom){
                if(i - val >= 0 && map[i - val] != Integer.MAX_VALUE){
                    //can choose this coin
                    map[i - val] = Math.min(map[i], map[i - val] + 1);
                }
            }

        }


        return map[sum];
    }
}

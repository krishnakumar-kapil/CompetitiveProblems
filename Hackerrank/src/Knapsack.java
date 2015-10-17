/**
 * Created by kapilkrishnakumar on 10/16/15.
 */
import java.util.*;
public class Knapsack {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for(int i = 0; i < test ; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];

            for(int j = 0; j < a.length; j++){
                int val = sc.nextInt();
                a[j] = val;
            }

            int[] weights = new int[k + 1];
            for(int w = 0; w <= k; w++){
                //every point --> find the one below the amount
                //
                int max = 0;
                for(int item: a){
                    if(w - item >= 0) {
                        int val = weights[w - item];
                        if(val + item > max && val + item <= k) max = val + item;
                    }
//                    System.out.println(max);
                }
                weights[w] = max;

            }
//            System.out.println(Arrays.toString(weights));
            System.out.println(weights[k]);
        }
    }
}

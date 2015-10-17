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
        }
    }
}

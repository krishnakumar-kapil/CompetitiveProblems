import java.util.*;

/**
 * Created by kapilkrishnakumar on 10/15/15.
 * https://www.hackerrank.com/challenges/stockmax
 */
public class StockMax {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n = sc.nextInt();

//            int maxProfit = 0;
//            int totalPrice = 0;
            int[] prices = new int[n];
            for(int i =0; i < n;i++){
                int s = sc.nextInt();
                prices[i] = s;
            }

            int[] maxToRight = new int[n];
            int currMax = Integer.MIN_VALUE;
            for(int i = n - 1; i >= 0; i--){
                int val = prices[i];
                if(val > currMax){
                    currMax = val;
                }
                maxToRight[i] = currMax;
            }

            long profit = 0;
            for(int i = 0; i < n; i++){
                int max = maxToRight[i];
                int cur = prices[i];
                if(cur < max){
                    profit += max - cur;
                }
            }
            System.out.println(profit);
        }
    }
}

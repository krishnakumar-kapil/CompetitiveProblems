/**
 * Created by kapilkrishnakumar on 10/25/15.
 */
import java.util.*;
public class MaxIndexProduct {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n + 1];
        int[] leftMax = new int[n + 1];
        int[] rightMax = new int[n + 1];

        int maxIndex = 0;
        for(int i = 1; i <= n; i++){
            array[i] = sc.nextInt();

            if(array[i] > array[maxIndex])
                maxIndex = i;
            leftMax[i] = maxIndex;
        }

        maxIndex = n;
        for(int i = n; i >= 1; i--){
            if(array[i] > array[maxIndex])
                maxIndex = i;
            rightMax[i] = maxIndex;
        }

        System.out.println(Arrays.toString(leftMax));
        System.out.println(Arrays.toString(rightMax));

        int currMaxProduct = 0;
        for(int i = 1; i <= n; i++){
            int leftVal = leftMax[i] < i? leftMax[i] : 0;
            int rightVal = rightMax[i] > i? rightMax[i] : 0;
            System.out.println(i + " "+currMaxProduct);
            if(leftVal * rightVal > currMaxProduct)
                currMaxProduct = leftVal * rightVal;

        }

        System.out.println(currMaxProduct);

    }
}

import java.util.Scanner;

/**
 * Created by kapilkrishnakumar on 10/9/15.
 */
public class BinarySearchSum {

    public static void main(String[] args) {

        for(int i = 0 ; i <= 14; i++){
            check(14, i);
        }


    }

    public static void check(int n, int k){
        int sum = 0;
        int low = 0;
        int high = n;
        int mid = 0;
        while (low <= high) {
            mid = low + (high - low) / 2;
            sum+= mid;
            if (mid == k)
                break;
            if (k < mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        System.out.println(sum);

    }
}

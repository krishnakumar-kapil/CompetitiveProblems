import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by kapilkrishnakumar on 9/18/15.
 */
public class Zero {

    public static void main(String[] args) throws IOException{
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//        String[] tmp = in.readLine().split(" ");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] nums = new int[num];
        for(int i = 0; i < num; i++){
            nums[i] = sc.nextInt();
        }
    }
}

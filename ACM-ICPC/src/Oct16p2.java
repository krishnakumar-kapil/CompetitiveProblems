/**
 * Created by kapilkrishnakumar on 10/16/15.
 */
import java.util.*;
public class Oct16p2 {



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int test = sc.nextInt();
        for(int t = 0; t < test; t++){
            int n  = sc.nextInt();
            int count = 0;
            for(int i = 0; i < n; i++){
                if(i == 2)
                    count++;
            }

            System.out.println(count);
        }
    }
}

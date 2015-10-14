/**
 * Created by kapilkrishnakumar on 10/13/15.
 */
import java.util.*;
public class CounterGame {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        for(long i = 0; i < test; i++){
            long counter = sc.nextInt();
            HashSet<Long> powers = new HashSet<Long>();
            long val = 1;
            while(val <= counter){
                powers.add(val);
                val *= 2;
            }


            boolean louis = true;
            while(counter > 1){
                double log = Math.log(counter) / Math.log(2);
                if(log == Math.floor(log))
                    counter /= 2;
                else {
                    counter -= Math.floor(log);
                }
                louis = !louis;
            }
            String result = louis ? "Louis" : "Richard";
            System.out.println(result);
        }
    }
}

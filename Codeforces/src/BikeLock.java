import java.util.*;

/**
 * Created by kapilkrishnakumar on 9/18/15.
 */
public class BikeLock {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        for(int poss = 0; poss < val; poss++){
            String s = sc.next();
            HashMap<Integer, Integer> ranges = new HashMap<Integer, Integer>();

            int numDk = 0;


            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c == '?') {
                    numDk++;
                    int diff = 1;
                    int range = 0;
                    if(i - diff >=0){
                        char q = s.charAt(i - diff);
                        if(q != '?')

                        range++;
                        diff++;
                    }
                }

            }
        }
    }
}

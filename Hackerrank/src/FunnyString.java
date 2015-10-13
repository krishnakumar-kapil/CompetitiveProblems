/**
 * Created by kapilkrishnakumar on 10/13/15.
 */
import java.util.*;

public class FunnyString {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            String s = sc.next();
            boolean tr = true;
            for(int j = 0; j < s.length() - 1; j++){
                char c11 = s.charAt(j);
                char c12 = s.charAt(j + 1);
                char c21 = s.charAt(s.length() - 1 - j);
                char c22 = s.charAt(s.length() - 2 - j);
                int diff = Math.abs(c11 - c12);
                int diff2 = Math.abs(c21 - c22);
                if(diff != diff2){
                    tr = false;
                    break;
                }

            }
            String r = tr? "Funny" : "Not Funny";
            System.out.println(r);
        }
    }
}

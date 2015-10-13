/**
 * Created by kapilkrishnakumar on 10/13/15.
 */
import java.util.*;
public class maxXOR {

    static int maxXor(int l, int r) {
        int max = l ^ r;
        for(int i = l; i < r; i++){
            for(int j = l; j < r; j++){
                int val = i ^ j;
                if(max < val)
                    max = val;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        int _l;
        _l = Integer.parseInt(in.nextLine());

        int _r;
        _r = Integer.parseInt(in.nextLine());

        res = maxXor(_l, _r);
        System.out.println(res);

    }
}

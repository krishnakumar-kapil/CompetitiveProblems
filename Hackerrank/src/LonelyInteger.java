/**
 * Created by kapilkrishnakumar on 10/13/15.
 */
import java.util.*;
public class LonelyInteger {

    static int lonelyinteger(int[] a) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i: a){
            if(hs.contains(i))
                hs.remove(i);
            else
                hs.add(i);
        }
        for(int v: hs){
            return v;
        }
        return 0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _a_size = Integer.parseInt(in.nextLine());
        int[] _a = new int[_a_size];
        int _a_item;
        String next = in.nextLine();
        String[] next_split = next.split(" ");

        for(int _a_i = 0; _a_i < _a_size; _a_i++) {
            _a_item = Integer.parseInt(next_split[_a_i]);
            _a[_a_i] = _a_item;
        }

        res = lonelyinteger(_a);
        System.out.println(res);

    }
}

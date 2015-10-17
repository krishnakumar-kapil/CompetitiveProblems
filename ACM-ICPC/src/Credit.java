/**
 * Created by kapilkrishnakumar on 9/18/15.
 */
import java.util.*;
public class Credit {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTest = sc.nextInt();
        String str = sc.nextLine();
        for(int z = 0; z < numTest; z++) {

            str = sc.nextLine();
            String[] arr = str.split("-");
            int[] vals = new int[16];
            int co = 0;
            for (int i = 0; i < arr.length; i++) {
                String s = arr[i];
                for (int j = 0; j < s.length(); j++) {
                    int val = s.charAt(j) - '0';
                    vals[co] = val;
                    co++;
                }
            }
//            System.out.println(Arrays.toString(vals));
            int total = 0;

            for(int i = 0; i < vals.length; i++){
                if(i % 2 == 0)
                    vals[i] *= 2;

                int sum = 0;
                if(vals[i] > 9) {
                    sum = vals[i] %10;
                    sum  += vals[i] / 10 ;
                    vals[i] = sum;
                } else
                   sum= vals[i];

//                System.out.println(total + " val: "+vals[i]);
                total += sum;

            }
//            System.out.println(Arrays.toString(vals));
//            System.out.println(total);
            if(total %10 == 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

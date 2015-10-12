/**
 * Created by kapilkrishnakumar on 10/7/15.
 * http://codeforces.com/contest/468/status
 */
import java.util.*;
public class TwentyFourGame {

    public static void main (String [] args) {
        Scanner sc = new Scanner (System.in);
        int n = sc.nextInt();
        if (n <= 3) {
            System.out.println("NO");
        }
        else if(n % 2 == 0){
            System.out.print("YES\n");
            System.out.print("1 * 2 = 2\n");
            System.out.print("2 * 3 = 6\n");
            System.out.print("6 * 4 = 24\n");
            for (int i = 5; i < n; i+=2) {
                String s = String.format("%d - %d = 1\n", i+1, i);
                System.out.print(s);
                System.out.print("24 * 1 = 24\n");
            }
        }else{
            System.out.print("YES\n");
            System.out.print("5 - 3 = 2\n");
            System.out.print("2 * 4 = 8\n");
            System.out.print("2 + 1 = 3\n");
            System.out.print("8 * 3 = 24\n");
            for (int i = 6; i < n; i+=2) {
                String s = String.format("%d - %d = 1\n", i+1, i);
                System.out.print(s);
                System.out.print("24 * 1 = 24\n");
            }
        }
    }
}


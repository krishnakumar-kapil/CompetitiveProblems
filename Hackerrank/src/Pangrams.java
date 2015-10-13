/**
 * Created by kapilkrishnakumar on 10/13/15.
 */

import java.util.*;
public class Pangrams {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toLowerCase();
        HashSet<Character> hs = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!hs.contains(c) && c != ' ')
                hs.add(c);

            if(hs.size() == 26) {
                System.out.println("pangram");
                return;
            }
        }
        System.out.println("not pangram");

    }
}
